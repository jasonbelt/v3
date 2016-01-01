/*
Copyright (c) 2015, Robby, Kansas State University
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package org.sireum.logika

import org.sireum.logika.ast._
import org.sireum.logika.util._
import org.sireum.util.Rewriter.TraversalMode
import org.sireum.util._

object Checker {
  private[logika] final val top = BooleanLit(true)
  private[logika] final val bottom = BooleanLit(false)
  private[logika] final val zero = IntLit("0")

  final def check(unitNode: UnitNode, autoEnabled: Boolean = false,
                  timeoutInMs: Int = 2000, checkSat: Boolean = false)(
                   implicit reporter: Reporter): Boolean = unitNode match {
    case s: Sequent =>
      assert(s.mode == LogicMode.Propositional ||
        s.mode == LogicMode.Predicate)
      var vars = isetEmpty[String]
      for (e <- s.premises ++ s.conclusions)
        vars ++= collectVars(e)
      s.proofOpt match {
        case Some(proof) =>
          implicit val nodeLocMap = s.nodeLocMap
          val r = ProofContext(s.mode, autoEnabled, timeoutInMs,
            checkSat, premises = s.premises.toSet).check(proof).isDefined
          val exps = proof.steps.flatMap(_ match {
            case s: RegularStep => Some(s.exp)
            case _ => None
          }).toSet
          for (c <- s.conclusions) {
            if (!exps.contains(c)) {
              val cLi = nodeLocMap(c)
              reporter.error(cLi.lineBegin, cLi.columnBegin, cLi.offset,
                s"The sequent conclusion has not been proved.")
            }
          }
          if (r) reporter.info(s"${unitNode.mode.value} logic proof is accepted.")
          else reporter.error(s"${unitNode.mode.value} logic proof is rejected.")
          r
        case _ =>
          reporter.error(s"${unitNode.mode.value} logic proof is yet to be done.")
          false
      }
    case program: Program =>
      implicit val nodeLocMap = program.nodeLocMap
      var hasProof = false
      Visitor.build({
        case _: ProofStmt => hasProof = true; false
        case InvStmt(inv) if inv.exps.nonEmpty =>
          hasProof = true; false
        case Requires(exps) if exps.nonEmpty =>
          hasProof = true; false
        case Ensures(exps) if exps.nonEmpty =>
          hasProof = true; false
        case LoopInv(inv, _) if inv.exps.nonEmpty =>
          hasProof = true; false
      })(program)
      if (!hasProof) {
        reporter.error("No programming logic proof element found.")
        false
      } else {
        val r =
          ProofContext(program.mode, autoEnabled, timeoutInMs,
            checkSat).check(program)
        if (r) reporter.info(s"Programming logic proof is accepted.")
        else reporter.error(s"Programming logic proof is rejected.")
        r
      }
    case _: Proof => assert(assertion = false, "Unexpected situation."); false
  }

  private[logika] final def collectVars(e: Exp): ISet[String] = {
    var result = isetEmpty[String]
    Visitor.build({
      case Id(value) =>
        result += value
        false
    })(e)
    result
  }
}

private final case class
ProofContext(mode: LogicMode,
             autoEnabled: Boolean,
             timeoutInMs: Int,
             checkSat: Boolean,
             invariants: ISet[Exp] = isetEmpty,
             premises: ISet[Exp] = isetEmpty,
             vars: ISet[String] = isetEmpty,
             facts: IMap[String, Exp] = imapEmpty,
             provedSteps: IMap[Natural, ProofStep] = imapEmpty,
             declaredStepNumbers: IMap[Natural, LocationInfo] = imapEmpty)
            (implicit reporter: Reporter,
             nodeLocMap: MIdMap[Node, LocationInfo]) {

  val satTimeoutInMs = scala.math.min(timeoutInMs / 2, 500)

  def check(program: Program): Boolean = {
    if (facts.nonEmpty && !checkSat(facts.values,
      unsatMsg = "The specified set of facts are unsatisfiable.",
      unknownMsg = "The set of facts might not be satisfiable.",
      timeoutMsg = "Could not check satisfiability of the set of facts due to timeout."
    )) return false
    copy(facts = facts ++ program.fact.factOrFunDecls.
      flatMap(_ match {
        case f: Fact => Some(f.id.value -> f.exp)
        case _ => None
      })
    ).check(program.block).isDefined
  }

  def checkSat(exps: Iterable[Exp], unsatMsg: => String,
               unknownMsg: => String, timeoutMsg: => String): Boolean =
    if (checkSat)
      Z3.checkSat(satTimeoutInMs,
        facts.values.toVector: _*) match {
        case Z3.Sat => true
        case Z3.Unsat => error(facts.head._2, unsatMsg); false
        case Z3.Unknown => reporter.warn(unknownMsg); true
        case Z3.Timeout => reporter.warn(timeoutMsg); true
        case Z3.Error => false
      }
    else false

  def check(block: Block): Option[ProofContext] = {
    var hasError = false
    var pcOpt: Option[ProofContext] = Some(this)
    for (stmt <- block.stmts if pcOpt.isDefined) {
      val pc =
        if (stmt.isInstanceOf[ProofStmt]) pcOpt.get
        else pcOpt.get.cleanup
      if (!stmt.isInstanceOf[ProofElementStmt] &&
        !stmt.isInstanceOf[MethodDecl]) {
        hasError = pc.checkRuntimeError(stmt) || hasError
      }
      pcOpt =
        stmt match {
          case ProofStmt(proof) =>
            pc.check(proof) match {
              case Some(pc2) =>
                Some(pc2.copy(
                  premises = filter(extractClaims(proof)),
                  provedSteps = imapEmpty))
              case _ => None
            }
          case SequentStmt(sequent) =>
            if (!autoEnabled) {
              hasError = true
              error(stmt, s"Auto is not enabled, but sequent is used.")
            }
            if (sequent.premises.nonEmpty) {
              if (!isValid(pc.premises, sequent.premises)) {
                hasError = true
                error(stmt, "Could not automatically deduce the specified sequent's premises.")
              }
              if (!isValid(sequent.premises, sequent.conclusions)) {
                hasError = true
                error(stmt, "Could not automatically deduce the specified sequent's conclusions from its premises.")
              }
            } else if (!isValid(pc.premises, sequent.conclusions)) {
              hasError = true
              error(stmt, "Could not automatically deduce the specified sequent's conclusions.")
            }
            Some(pc.copy(premises =
              filter(sequent.premises.toSet) ++
                filter(sequent.conclusions.toSet)))
          case Assert(e) =>
            Some(pc.copy(premises = pc.premises + e))
          case SeqAssign(id, index, exp) =>
            val old = newId(id.value + "_old", id.tipe)
            val m = imapEmpty[Node, Node] + (id -> old)
            val qVar = newId("q_i", tipe.Z)
            Some(pc.copy(premises =
              pc.premises.map(e => subst(e, m)) ++
                ivector(
                  Eq(Size(id), Size(old)),
                  Eq(Apply(id, Node.seq(subst(index, m))), subst(exp, m)),
                  ForAll(
                    Node.seq(qVar),
                    Some(RangeDomain(Checker.zero, Size(id),
                      loLt = false, hiLt = true)),
                    Implies(
                      Ne(qVar, index),
                      Eq(Apply(id, Node.seq(qVar)), Apply(old, Node.seq(qVar)))
                    )
                  )
                )))
          case ExpStmt(exp) =>
            val (he, pc2) = pc.invoke(exp, None)
            hasError ||= he
            Some(pc2)
          case a: VarAssign =>
            val id = a.id
            val exp = a.exp
            exp match {
              case _: ReadInt => pcOpt
              case exp: Clone => pc.assign(id, exp.id)
              case exp: Apply if exp.id.tipe != tipe.ZS =>
                val (he, pc2) = pc.invoke(exp, Some(id))
                hasError ||= he
                Some(pc2)
              case _ => pc.assign(id, exp)
            }
          case If(exp, thenBlock, elseBlock) =>
            val thenPcOpt = pc.copy(premises = pc.premises + exp).check(thenBlock)
            val elsePcOpt = pc.copy(premises = pc.premises + Not(exp)).check(elseBlock)
            (thenPcOpt, elsePcOpt) match {
              case (Some(thenPc), Some(elsePc)) =>
                Some(pc.copy(premises =
                  orClaims(thenPc.premises, elsePc.premises)))
              case _ => None
            }
          case stmt: MethodDecl =>
            val effectivePre = pc.invariants ++ stmt.contract.requires.exps
            val effectivePost = pc.invariants ++ stmt.contract.ensures.exps
            hasError =
              checkSat(effectivePre,
                unsatMsg = s"The effective pre-condition of method ${stmt.id.value} is unsatisfiable.",
                unknownMsg = s"The effective pre-condition of method ${stmt.id.value} might not be satisfiable.",
                timeoutMsg = s"Could not check satisfiability of the effective pre-condition of method ${stmt.id.value} due to timeout (${timeoutInMs}ms)."
              ) || hasError
            hasError =
              checkSat(effectivePost,
                unsatMsg = s"The effective post-condition of method ${stmt.id.value} is unsatisfiable.",
                unknownMsg = s"The effective post-condition of method ${stmt.id.value} might not be satisfiable.",
                timeoutMsg = s"Could not check satisfiability of the effective post-condition of method ${stmt.id.value} due to timeout (${timeoutInMs}ms)."
              ) || hasError
            val modifiedIds = stmt.contract.modifies.ids.toSet
            val mods = modifiedIds.map(id =>
              Eq(id, newId(id.value + "_in", id.tipe)))
            pc.copy(premises = effectivePre ++ mods).
              check(stmt.block) match {
              case Some(pc2) =>
                var modifiedInvariants = isetEmpty[Exp]
                for (e <- pc.invariants) {
                  var modified = false
                  Visitor.build({
                    case id: Id =>
                      if (modifiedIds.contains(id)) {
                        modified = true
                      }
                      false
                  })(e)
                  if (modified) modifiedInvariants += e
                }
                if (autoEnabled) {
                  if (modifiedInvariants.nonEmpty &&
                    !isValid(pc2.premises, modifiedInvariants)) {
                    val locs = buildLocs(modifiedInvariants)
                    error(stmt, s"Could not automatically deduce the global invariant(s) at $locs at the end of method ${stmt.id.value}.")
                    hasError = true
                  }
                } else {
                  for (e <- modifiedInvariants)
                    if (!pc2.premises.contains(e)) {
                      error(e, s"The global invariant has not been proven at the end of method ${stmt.id.value}.")
                      hasError = true
                    }
                }
                val post = stmt.contract.ensures.exps
                val postPremises = stmt.returnExpOpt match {
                  case Some(e) =>
                    val m = imapEmpty[Node, Node] + (e -> Result())
                    pc2.premises.map(e => subst(e, m))
                  case _ => pc2.premises
                }
                if (autoEnabled) {
                  if (post.nonEmpty && !isValid(postPremises, post)) {
                    hasError = true
                    val locs = buildLocs(post)
                    error(post.head, s"Could not automatically deduce method ${stmt.id.value}'s post-condition(s) defined at $locs.")
                  }
                } else {
                  var i = 1
                  for (e <- post) {
                    if (!postPremises.contains(e)) {
                      if (post.size == 1)
                        error(e, s"The post-condition of method ${stmt.id.value} has not been proven.")
                      else
                        error(e, s"Post-condition #$i of method ${stmt.id.value} has not been proven.")
                      hasError = true
                    }
                    i += 1
                  }
                }
              case _ => hasError = true
            }
            pcOpt
          case InvStmt(inv) =>
            var i = 1
            if (autoEnabled) {
              if (!isValid(pc.premises, inv.exps)) {
                hasError = true
                error(stmt, s"Could not automatically deduce the global invariant(s).")
              }
            } else {
              for (e <- inv.exps) {
                if (!pc.premises.contains(e)) {
                  if (inv.exps.size == 1)
                    error(e, s"The global invariant has not been proven.")
                  else
                    error(e, s"The global invariant #$i has not been proved.")
                  hasError = true
                }
                i += 1
              }
            }
            Some(pc.copy(invariants = pc.invariants ++ inv.exps))
          case While(exp, loopBlock, loopInv) =>
            val es = loopInv.invariant.exps
            if (autoEnabled) {
              if (es.nonEmpty && !isValid(pc.premises, es)) {
                hasError = true
                error(loopInv, s"Could not automatically deduce the loop invariant(s) at the beginning of the loop.")
              }
            } else {
              var i = 1
              for (e <- es) {
                if (!pc.premises.contains(e)) {
                  if (es.size == 1)
                    error(e, s"The loop invariant has not been proved at the beginning of the loop.")
                  else
                    error(e, s"Loop invariant #$i has not been proved at the end of the loop.")
                  hasError = true
                }
                i += 1
              }
            }
            pc.copy(premises = pc.premises ++ es + exp).
              check(loopBlock) match {
              case Some(pc2) =>
                if (autoEnabled) {
                  if (es.nonEmpty && !isValid(pc2.premises, es)) {
                    hasError = true
                    error(loopInv, s"Could not automatically deduce the loop invariant(s) at the end of the loop.")
                  }
                } else {
                  var i = 1
                  for (e <- es) {
                    if (!pc2.premises.contains(e)) {
                      if (es.size == 1)
                        error(e, s"The loop invariant has not been proved at the end of the loop.")
                      else
                        error(e, s"Loop invariant #$i has not been proved at the end of the loop.")
                      hasError = true
                    }
                    i += 1
                  }
                }
                Some(pc.copy(premises = es.toSet + Not(exp)))
              case _ => None
            }
          case _: Print => pcOpt
        }
    }
    if (hasError) None else pcOpt.map(_.cleanup)
  }

  def buildLocs(it: Iterable[Node]): String = {
    val sb = new StringBuilder
    val locs =
      it.toVector.map(n => nodeLocMap(n)).sortWith((li1, li2) =>
        if (li1.lineBegin < li2.lineBegin) true
        else if (li1.lineBegin > li2.lineBegin) false
        else li1.columnBegin < li2.columnBegin)
    sb.append(s"[${locs.head.lineBegin}, ${locs.head.columnBegin}]")
    var i = 1
    val size = locs.size
    for (loc <- locs.tail) {
      if (i == size - 1) sb.append(", and ")
      else sb.append(", ")
      sb.append(s"[${loc.lineBegin}, ${loc.columnBegin}]")
      i += 1
    }
    sb.toString
  }

  def isValid(premises: Iterable[Exp], conclusions: Iterable[Exp]): Boolean =
    Z3.isValid(timeoutInMs, premises.toVector, conclusions.toVector)

  def newId(x: String, t: tipe.Tipe) = {
    val r = Id(x)
    r.tipe = t
    r
  }

  def invoke(a: Apply, lhsOpt: Option[Id]): (Boolean, ProofContext) = {
    var hasError = false
    val md = a.declOpt.get
    var substMap = md.params.map(_.id).zip(a.args).toMap[Node, Node]
    val pres = md.contract.requires.exps.map(e => subst(e, substMap))
    if (autoEnabled) {
      if (pres.nonEmpty && !isValid(premises, pres)) {
        hasError = true
        error(a, s"Could not automatically deduce the pre-condition(s) of the method.")
      }
    } else {
      var i = 1
      for (pre <- pres) {
        if (!premises.contains(pre)) {
          if (pres.size == 1)
            error(a, s"The pre-condition of method ${md.id.value} has not been proven.")
          else
            error(a, s"Pre-condition #$i of method ${md.id.value} has not been proven.")
          hasError = true
        }
        i += 1
      }
    }
    val (lhs, postSubstMap) = lhsOpt match {
      case Some(x) =>
        (x, imapEmpty[Node, Node] + (x -> newId(x.value + "_old", x.tipe)))
      case _ =>
        (newId(md.id.value + "_result",
          md.id.tipe.asInstanceOf[tipe.Fn].result),
          imapEmpty[Node, Node])
    }
    substMap += Result() -> lhs
    for (id@Id(g) <- md.contract.modifies.ids) {
      substMap += newId(g + "_in", id.tipe) -> newId(g + "_old", id.tipe)
    }
    (hasError, copy(premises =
      premises.map(e => subst(e, postSubstMap)) ++
        md.contract.ensures.exps.map(e => subst(e, substMap))
    ))
  }

  def checkRuntimeError(stmt: Stmt): Boolean = {
    var hasError = false
    def divisor(e: Exp): Boolean = {
      val req = Ne(e, Checker.zero)
      if (autoEnabled) {
        if (!isValid(premises, ivector(req))) {
          error(e, s"Could not automatically deduce that the divisor is non-zero.")
          hasError = true
        }
      } else if (!premises.contains(req)) {
        error(e, s"Divisor has to be proven to be non-zero (... != 0).")
        hasError = true
      }
      true
    }
    def index(id: Id, e: Exp): Boolean = {
      val req1 = Le(Checker.zero, e)
      val req2 = Lt(e, Size(id))
      if (autoEnabled) {
        if (!isValid(premises, ivector(req1, req2))) {
          hasError = true
          error(e, s"Could not automatically deduce that the index is not out of bound of ${id.value}.")
        }
      } else {
        if (!premises.contains(req1)) {
          hasError = true
          error(e, "The sequence index has to be proven non-negative (0 <= ...)")
        }
        if (!premises.contains(req2)) {
          hasError = true
          error(e, s"The sequence index has to be proven less than the sequence size (... < ${id.value}.size)")
        }
      }
      true
    }
    Visitor.build({
      case _: Block => false
      case Div(_, e2) => divisor(e2)
      case Rem(_, e2) => divisor(e2)
      case a@Apply(id, Seq(e)) if id.tipe == tipe.ZS => index(id, e)
      case SeqAssign(id, e, _) => index(id, e)
    })(stmt)
    hasError
  }

  def orClaims(es1: Iterable[Exp], es2: Iterable[Exp]): ISet[Exp] =
    (for (e1 <- es1; e2 <- es2) yield
      ivector(Or(e1, e2)) ++
        (if (e1 != e2) ivectorEmpty else ivector(e1))).
      flatten.toSet

  def extractClaims(pg: ProofGroup): ISet[Exp] =
    pg.allSteps.flatMap(_ match {
      case step: RegularStep => Some(step.exp)
      case _ => None
    }).toSet

  def assign(id: Id, exp: Exp): Option[ProofContext] = {
    val sst = expRewriter(Map[Node, Node](id -> newId(id.value + "_old", id.tipe)))
    Some(copy(premises = premises.map(sst) + Eq(id, sst(exp))))
  }

  def cleanup: ProofContext =
    copy(premises = filter(premises), provedSteps = imapEmpty,
      declaredStepNumbers = imapEmpty)

  def filter(premises: ISet[Exp]): ISet[Exp] = {
    def keep(e: Exp) = {
      var r = true
      Visitor.build({
        case Id(value) =>
          if (value.endsWith("_old") ||
            value.endsWith("_result") || value == "q_i")
            r = false
          false
      })(e)
      r
    }
    premises.filter(keep)
  }

  def check(proofGroup: ProofGroup): Option[ProofContext] = {
    var addedVars = isetEmpty[String]
    var addedSteps = isetEmpty[Natural]
    var pcOpt: Option[ProofContext] =
      proofGroup match {
        case p: SubProof =>
          val popt = p.assumeStep match {
            case PlainAssumeStep(_, exp) =>
              addProvedStep(p.assumeStep)
            case ForAllAssumeStep(num, id, _) =>
              addedVars += id.value
              addVar(id, num.value)
            case ExistsAssumeStep(num, id, exp, _) =>
              addedVars += id.value
              addVar(id, num.value).flatMap(_.addProvedStep(p.assumeStep))
          }
          popt.flatMap(_.addProvedStep(p))
        case _ => Some(this)
      }
    for (step <- proofGroup.steps if pcOpt.isDefined) {
      addedSteps += step.num.value
      step match {
        case p: RegularStep => pcOpt = pcOpt.flatMap(_.check(p))
        case p: SubProof => pcOpt = pcOpt.get.check(p)
        case _: ForAllAssumeStep => assert(assertion = false, "Unexpected situation.")
      }
    }
    pcOpt.map(pc => pc.copy(
      vars = pc.vars -- addedVars,
      provedSteps = pc.provedSteps -- addedSteps))
  }

  def check(step: RegularStep): Option[ProofContext] = {
    val num = step.num.value
    step match {
      case Premise(_, exp) =>
        if (premises.contains(exp) || exp == Checker.top) addProvedStep(step)
        else error(exp, s"Could not find the claimed premise in step #$num.")
      case AndIntro(_, and, lStep, rStep) =>
        (for (lExp <- findRegularStepExp(lStep, num);
              rExp <- findRegularStepExp(rStep, num)) yield {
          val expected = And(lExp, rExp)
          if (expected == step.exp) addProvedStep(step)
          else error(and, s"And-intro in step #$num with #${lStep.value} on the left and #${rStep.value} on the right does not produce the expressed form.")
        }).flatten
      case AndElim1(_, exp, andStep) =>
        findRegularStepExp(andStep, num) match {
          case Some(And(expected, _)) =>
            if (expected == exp) addProvedStep(step)
            else error(exp, s"The conjunction's left sub-expression in step #${andStep.value} does not match #$num for And-elim1.")
          case Some(_) => error(andStep, s"And-elim1 in step #$num requires a conjunction.")
          case _ => None
        }
      case AndElim2(_, exp, andStep) =>
        findRegularStepExp(andStep, num) match {
          case Some(And(_, expected)) =>
            if (expected == exp) addProvedStep(step)
            else error(exp, s"The conjunction's right sub-expression in step #${andStep.value} does not match #$num for And-elim2.")
          case Some(_) => error(andStep, s"And-elim2 in step #$num requires a conjunction.")
          case _ => None
        }
      case OrIntro1(_, or@Or(lExp, _), step2) =>
        findRegularStepExp(step2, num) match {
          case Some(expected) =>
            if (expected == lExp) addProvedStep(step)
            else error(lExp, s"The disjunction's left sub-expression in step #$num does not match #${step2.value} for Or-intro1.")
          case _ => None
        }
      case OrIntro2(_, or@Or(_, rExp), step2) =>
        findRegularStepExp(step2, num) match {
          case Some(expected) =>
            if (expected == rExp) addProvedStep(step)
            else error(rExp, s"The disjunction's right sub-expression in step #$num does not match #${step2.value} for Or-intro2.")
          case _ => None
        }
      case OrElim(_, exp, orStep, lSubProof, rSubProof) =>
        findRegularStepExp(orStep, num) match {
          case someE@Some(_: Or | _: Le | _: Ge) =>
            val r =
              for (lsp <- findSubProof(lSubProof, num);
                   rsp <- findSubProof(rSubProof, num)) yield {
                var hasError = false
                (lsp.first, rsp.first) match {
                  case (lfs: PlainAssumeStep, rfs: PlainAssumeStep) =>
                    val (lExp, rExp) =
                      (someE.x: @unchecked) match {
                        case Or(le, re) => (le, re)
                        case Le(le, re) => (Lt(le, re), Eq(le, re))
                        case Ge(le, re) => (Gt(le, re), Eq(le, re))
                      }
                    if (lfs.exp != lExp) {
                      error(lSubProof, s"Assumed expression does not match the left sub-expression of #${orStep.value} for Or-elim in step #$num.")
                      hasError = true
                    }
                    if (rfs.exp != rExp) {
                      error(lSubProof, s"Assumed expression does not match the right sub-expression of #${orStep.value} for Or-elim in step #$num.")
                      hasError = true
                    }
                    val expectedClaims =
                      orClaims(extractClaims(lsp), extractClaims(rsp))
                    if (!expectedClaims.contains(exp)) {
                      error(exp, s"Could not find the expression in step #$num in #${lSubProof.value} or #${rSubProof.value} for Or-elim.")
                      hasError = true
                    }
                  case (lfs, rfs) =>
                    if (!lfs.isInstanceOf[PlainAssumeStep])
                      error(lSubProof, s"Wrong form for Or-elim left assumption in step #$num.")
                    if (!rfs.isInstanceOf[PlainAssumeStep])
                      error(lSubProof, s"Wrong form for Or-elim right assumption in step #$num.")
                    hasError = true
                }
                if (hasError) None else addProvedStep(step)
              }
            r.flatten
          case _ => error(orStep, s"Or-elim in step #$num requires a disjunction in step # ${orStep.value}.")
        }
      case ImpliesIntro(_, Implies(antecedent, conclusion), subProof) =>
        findSubProof(subProof, num) match {
          case Some(sp) =>
            var hasError = false
            sp.first match {
              case fs: PlainAssumeStep =>
                if (fs.exp != antecedent) {
                  error(antecedent, s"The antecedent of step #$num does not match the assumption of #${subProof.value} for Implies-intro.")
                  hasError = true
                }
                val expectedClaims = extractClaims(sp)
                if (!expectedClaims.contains(conclusion)) {
                  error(antecedent, s"Could not find the consequent of step #$num in #${subProof.value} for Implies-intro.")
                  hasError = true
                }
              case fs =>
                error(sp, s"Wrong form for Implies-intro assumption in step #$num.")
                hasError = true
            }
            if (hasError) None else addProvedStep(step)
          case _ => None
        }
      case ImpliesElim(_, exp, impliesStep, antecedentStep) =>
        (findRegularStepExp(impliesStep, num),
          findRegularStepExp(antecedentStep, num)) match {
          case (Some(Implies(a, c)), Some(antecedent)) =>
            var hasError = false
            if (a != antecedent) {
              error(step, s"The expression in #${antecedentStep.value} does not match the antecedent in #${impliesStep.value} for Implies-elim of step #$num.")
              hasError = true
            }
            if (c != exp) {
              error(exp, s"The conclusion in #${impliesStep.value} does not match the expression in #$num for Implies-elim.")
              hasError = true
            }
            if (hasError) None else addProvedStep(step)
          case (Some(_), _) =>
            error(impliesStep, s"Implies-elim in step #$num requires an implication.")
            None
          case _ => None
        }
      case NegIntro(_, exp, subProof) =>
        findSubProof(subProof, num) match {
          case Some(sp) =>
            var hasError = false
            (sp.first, sp.last) match {
              case (fs: PlainAssumeStep, ls: RegularStep) =>
                if (fs.exp != exp.exp) {
                  error(exp.exp, s"The assumption in step #${subProof.value} does not match the non-negated expression of #$num for Negation-intro.")
                  hasError = true
                }
                if (ls.exp != Checker.bottom) {
                  error(ls.exp, s"The conclusion in step #${subProof.value} is expected to be a falsicum (⊥) for Negation-intro of #$num.")
                  hasError = true
                }
              case (fs, ls) =>
                if (!fs.isInstanceOf[PlainAssumeStep])
                  error(sp, s"Wrong form for Negation-intro assumption in step #$num.")
                if (!ls.isInstanceOf[RegularStep])
                  error(sp, s"Wrong form for Negation-intro conclusion in step #$num.")
                hasError = true
            }
            if (hasError) None else addProvedStep(step)
          case _ => None
        }
      case NegElim(_, exp, step2, negStep) =>
        (findRegularStepExp(step2, num), findRegularStepExp(negStep, num)) match {
          case (Some(e1), Some(e2: Not)) =>
            var hasError = false
            if (e1 != e2.exp) {
              error(step, s"The negated expression of step #${step2.value} does not match #${negStep.value} for Negation-elim in #$num.")
              hasError = true
            }
            if (exp != Checker.bottom) {
              error(exp, s"The expression of step #$num is expected to be a falsicum (⊥) for Negation-elim.")
              hasError = true
            }
            if (hasError) None else addProvedStep(step)
          case (_, Some(e2)) =>
            error(negStep, s"The second expression argument of step #${negStep.value} for Negation-elim in step #$num has to be negation.")
            None
          case _ => None
        }
      case BottomElim(_, exp, falseStep) =>
        findRegularStepExp(falseStep, num) match {
          case Some(e) =>
            if (e != Checker.bottom) {
              error(e, s"The expression of step #${falseStep.value} is expected to be a falsicum (⊥) for Bottom-elim of #$num.")
              None
            } else addProvedStep(step)
          case _ => None
        }
      case Pbc(_, exp, subProof) =>
        findSubProof(subProof, num) match {
          case Some(sp: SubProof) =>
            var hasError = false
            (sp.first, sp.last) match {
              case (fs: PlainAssumeStep, ls: RegularStep) =>
                if (fs.exp != Not(exp)) {
                  error(exp, s"The negated expression in step #$num does not match the assumption in #${subProof.value} for Pbc.")
                  hasError = true
                }
                if (ls.exp != Checker.bottom) {
                  error(ls.exp, s"The conclusion of step #${subProof.value} is expected to be a falsicum (⊥) for Pbc of #$num.")
                  hasError = true
                }
              case (fs, ls) =>
                if (!fs.isInstanceOf[PlainAssumeStep])
                  error(sp, s"Wrong form for Pbc assumption in step #$num.")
                if (ls.isInstanceOf[RegularStep])
                  error(sp, s"Wrong form for Pbc conclusion in step #$num.")
                hasError = true
            }
            if (hasError) None else addProvedStep(step)
          case _ => None
        }
      case Subst1(_, exp, eqStep, step2) =>
        var hasError = false
        (findRegularStepOrFactExp(eqStep, num),
          findRegularStepExp(step2, num)) match {
          case (Some(Eq(exp1, exp2)), Some(e)) =>
            val expected =
              org.sireum.logika.ast.Rewriter.build[Exp]()({
                case `exp1` => exp2
              })(e)
            if (expected != exp) {
              val eqStepText = text(eqStep)
              error(exp, s"The expression in step #$num does not match the substituted expression of [left/right $eqStepText]#${step2.value} for Subst1.")
              hasError = true
            }
          case (Some(_), Some(_)) =>
            error(eqStep, s"The second expression argument of step #${text(eqStep)} for Subst1 in step #$num has to be an equality.")
            hasError = true
          case _ => hasError = true
        }
        if (hasError) None else addProvedStep(step)
      case Subst2(_, exp, eqStep, step2) =>
        var hasError = false
        (findRegularStepOrFactExp(eqStep, num),
          findRegularStepExp(step2, num)) match {
          case (Some(Eq(exp1, exp2)), Some(e)) =>
            val expected =
              org.sireum.logika.ast.Rewriter.build[Exp]()({
                case `exp2` => exp1
              })(e)
            if (expected != exp) {
              val eqStepText = text(eqStep)
              error(exp, s"The expression in step #$num does not match the substituted expression of [right/left $eqStepText]#${step2.value} for Subst2.")
              hasError = true
            }
          case (Some(_), Some(_)) =>
            error(eqStep, s"The second expression argument of step #${text(eqStep)} for Subst2 in step #$num has to be an equality.")
            hasError = true
          case _ => hasError = true
        }
        if (hasError) None else addProvedStep(step)
      case Algebra(_, exp, stepOrFacts) =>
        if (deduce(num, exp, stepOrFacts, checkAlgebraExp, "apply algebra"))
          addProvedStep(step)
        else None
      case ForAllIntro(_, q, subProof) =>
        findSubProof(subProof, num) match {
          case Some(sp) =>
            var hasError = false
            (sp.first, sp.last) match {
              case (fs: ForAllAssumeStep, ls: RegularStep) =>
                val freshVarId = fs.id
                val freshVar = freshVarId.value
                if (!Checker.collectVars(ls.exp).contains(freshVar))
                  warn(ls.exp, s"The conclusion in step #${subProof.value} does not use the fresh variable $freshVar introducted in #${fs.num.value}.")
                val expected = subst(q.simplify.exp, Map(q.ids.head -> freshVarId))
                if (expected != ls.exp) {
                  error(q, s"Supplying $freshVar for ${q.ids.head} in step #$num does not produce matching expression in #${ls.num.value} for Forall-intro.")
                  hasError = true
                }
              case (fs, ls) =>
                if (!fs.isInstanceOf[ForAllAssumeStep])
                  error(sp, s"Wrong form for the start of Forall-intro in step #$num that is expected to have only a fresh variable.")
                if (!ls.isInstanceOf[RegularStep])
                  error(sp, s"Wrong form for Forall-intro conclusion in step #$num.")
                hasError = true
            }
            if (hasError) None else addProvedStep(step)
          case _ => None
        }
      case ForAllElim(_, exp, stepOrFact, args) =>
        findRegularStepOrFactExp(stepOrFact, num) match {
          case Some(q: ForAll) =>
            buildSubstMap(q.simplify, args) match {
              case Some((m, e)) =>
                val expected = subst(e, m)
                if (exp != expected) {
                  error(exp, s"Supplying the specified arguments to the quantification ${text(stepOrFact)} does not produce matching expression in #$num for Forall-elim.")
                  None
                } else addProvedStep(step)
              case _ => error(step, s"The numbers of quantified variables and arguments do not match in Forall-elim of step #$num.")
            }
          case Some(_) => error(stepOrFact, s"Forall-elim in $num requires a universal quantification ${text(stepOrFact)}.")
          case _ => None
        }
      case ExistsIntro(_, q, step2, args) =>
        findRegularStepExp(step2, num) match {
          case Some(result) =>
            buildSubstMap(q.simplify, args) match {
              case Some((m, e)) =>
                val expected = subst(e, m)
                if (result != expected) {
                  error(q, s"Supplying the specified arguments to the quantification in step #$num does not produce matching expression in #${step2.value} for Exists-intro.")
                  None
                } else addProvedStep(step)
              case _ => error(step, s"The numbers of quantified variables and arguments do not match in Exists-intro of step #$num.")
            }
          case _ => None
        }
      case ExistsElim(_, exp, stepOrFact, subProof) =>
        findRegularStepOrFactExp(stepOrFact, num) match {
          case Some(q: Exists) =>
            findSubProof(subProof, num) match {
              case Some(sp) =>
                var hasError = false
                sp.first match {
                  case fs: ExistsAssumeStep =>
                    val freshVar = fs.id.value
                    val expected = subst(q.simplify.exp, Map(q.ids.head -> Id(freshVar)))
                    if (expected != fs.exp) {
                      error(exp, s"Supplying $freshVar for ${q.ids.head} ${text(stepOrFact)} does not produce matching expression in the assumption of #${subProof.value} for Exists-elim.")
                      hasError = true
                    }
                    val expectedClaims = extractClaims(sp)
                    if (!expectedClaims.contains(exp)) {
                      error(exp, s"Could not find the expression in step #$num in #${subProof.value} for Exists-elim.")
                      hasError = true
                    }
                    if (Checker.collectVars(exp).contains(freshVar)) {
                      error(exp, s"The expression in step #$num should not contain $freshVar for Exists-elim.")
                      hasError = true
                    }
                  case fs =>
                    error(sp, s"Wrong form for Exists-elim assumption in step #$num that is expected to have a fresh variable and a formula.")
                    hasError = true
                }
                if (hasError) None else addProvedStep(step)
              case _ => None
            }
          case Some(_) => error(stepOrFact, s"Exists-elim in step #$num requires an existensial quantification ${text(stepOrFact)}.")
          case _ => None
        }
      case Auto(_, exp, stepOrFacts) =>
        if (!autoEnabled)
          error(step, s"Auto is not enabled, but used in step #$num.")
        if (deduce(num, exp, stepOrFacts, e => true, "automatically")) addProvedStep(step)
        else None
      case Invariant(_, exp) =>
        if (invariants.contains(exp)) addProvedStep(step)
        else error(exp, s"Could not find the invariant in step #$num.")
      case _: ExistsAssumeStep | _: PlainAssumeStep =>
        assert(assertion = false, "Unexpected situation.")
        None
    }
  }

  def deduce(num: Int, exp: Exp, stepOrFacts: Node.Seq[NumOrId],
             f: Exp => Boolean, method: String): Boolean = {
    var antecedents = Node.emptySeq[Exp]
    var hasError = false
    for (numOrId <- stepOrFacts)
      findRegularStepOrFactExp(numOrId, num) match {
        case Some(e) => if (f(e)) antecedents :+= e
        case _ => hasError = true
      }
    if (hasError) return false
    if (isValid(antecedents ++ facts.values, ivector(exp))) true
    else {
      error(exp, s"Could not $method deduce the claim in step#$num.")
      false
    }
  }

  def checkAlgebraExp(e: Exp): Boolean = {
    var hasError = false
    Visitor.build({
      case e: And =>
        hasError = true
        error(e, "Algebra justification cannot be used for conjunction.")
        true
      case e: Or =>
        hasError = true
        error(e, "Algebra justification cannot be used for disjunction.")
        true
      case e: Implies =>
        hasError = true
        error(e, "Algebra justification cannot be used for implication.")
        true
      case q: Quant[_] =>
        hasError = true
        error(e, "Algebra justification cannot be used for quantification.")
        true
    })(e)
    !hasError
  }

  def expRewriter(m: IMap[Node, Node]): Exp => Exp =
    org.sireum.logika.ast.Rewriter.build[Exp](TraversalMode.BOTTOM_UP) {
      case n: Node => m.getOrElse(n, n)
    }

  def subst(e: Exp, m: IMap[Node, Node]): Exp = expRewriter(m)(e)

  def buildSubstMap(q: Quant[_], args: Node.Seq[Exp]): Option[(IMap[Node, Node], Exp)] = {
    val r = imapEmpty[Node, Node] ++ q.ids.zip(args)
    if (r.isEmpty) None
    else if (r.size < q.ids.size) {
      q match {
        case q: ForAll =>
          Some((r, ForAll(q.ids.slice(r.size, q.ids.size), q.domainOpt, q.exp)))
        case q: Exists =>
          Some((r, Exists(q.ids.slice(r.size, q.ids.size), q.domainOpt, q.exp)))
      }
    } else if (r.size < args.size) {
      q.exp match {
        case q2: Quant[_] =>
          buildSubstMap(q2, args.slice(r.size, args.size)) match {
            case Some((m, e)) => Some((r ++ m, e))
            case _ => None
          }
        case _ => None
      }
    } else Some((r, q.exp))
  }

  def text(stepOrFact: NumOrId): String = stepOrFact match {
    case Num(num) => s"in #$num"
    case Id(id) => s"fact named $id"
  }

  def findRegularStepOrFactExp(stepOrFact: NumOrId, stepNum: Int): Option[Exp] =
    stepOrFact match {
      case num: Num => findRegularStepExp(num, stepNum)
      case id: Id => facts.get(id.value) match {
        case eOpt@Some(_) => eOpt
        case _ =>
          val (l, c, o) = lineColumnOffset(stepOrFact)
          reporter.error(l, c, o, s"Could not find the referenced fact ${id.value} in #$stepNum.")
          None
      }
    }

  def addProvedStep(step: ProofStep): Option[ProofContext] = {
    val num = step.num.value
    declaredStepNumbers.get(num) match {
      case Some(li) =>
        error(step, s"Step #$num has already been used in at line ${li.lineBegin}, column ${li.columnBegin}.")
        None
      case _ =>
        Some(copy(provedSteps = provedSteps + (num -> step),
          declaredStepNumbers = declaredStepNumbers + (num -> nodeLocMap(step))))
    }
  }

  def addVar(id: Id, stepNum: Int): Option[ProofContext] = {
    val varId = id.value
    if (vars.contains(varId)) {
      error(id, s"The variable $varId in step #$stepNum, is not fresh.")
      None
    } else Some(copy(vars = vars + varId))
  }

  def lineColumnOffset(n: Node): (Int, Int, Int) = {
    val li = nodeLocMap(n)
    (li.lineBegin, li.columnBegin, li.offset)
  }

  def findSubProof(num: Num, stepNum: Int): Option[SubProof] = {
    provedSteps.get(num.value) match {
      case Some(r: SubProof) => Some(r)
      case Some(_) =>
        val (l, c, o) = lineColumnOffset(num)
        reporter.error(l, c, o, s"#${num.value} should be a sub-proof.")
        None
      case _ =>
        val (l, c, o) = lineColumnOffset(num)
        if (declaredStepNumbers.contains(num.value))
          reporter.error(l, c, o, s"Step #${num.value} is out of scope from #$stepNum.")
        else
          reporter.error(l, c, o, s"Could not find the referenced sub-proof #${num.value} in #$stepNum.")
        None
    }
  }

  def findRegularStepExp(num: Num, stepNum: Int): Option[Exp] =
    provedSteps.get(num.value) match {
      case Some(r: RegularStep) => Some(r.exp)
      case _ =>
        val (l, c, o) = lineColumnOffset(num)
        if (declaredStepNumbers.contains(num.value))
          reporter.error(l, c, o, s"Step #${num.value} is out of scope from #$stepNum.")
        else
          reporter.error(l, c, o, s"Could not find the referenced step #${num.value} in #$stepNum.")
        None
    }

  def error(n: Node, msg: String): Option[ProofContext] = {
    val (l, c, o) = lineColumnOffset(n)
    reporter.error(l, c, o, msg)
    None
  }

  def warn(n: Node, msg: String): Option[ProofContext] = {
    val (l, c, o) = lineColumnOffset(n)
    reporter.warn(l, c, o, msg)
    None
  }
}