// #Sireum
/*
 Copyright (c) 2017, Robby, Kansas State University
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

package org.sireum.lang.tipe

import org.sireum._
import org.sireum.lang.symbol.{GlobalDeclarationResolver, Resolver}
import org.sireum.lang.{ast => AST}
import org.sireum.lang.symbol.Resolver._
import org.sireum.lang.util._

object TypeChecker {

  @enum object BasicKind {
    'B
    'C
    'Z
    'Range
    'Bits
    'F32
    'F64
    'R
  }

  val typeCheckerKind: String = "Type Checker"
  val typeUnit: AST.Typed = AST.Typed.Name(ISZ("Unit"), ISZ(), None())
  val typeUnitOpt: Option[AST.Typed] = Some(typeUnit)
  val errType: AST.Typed = AST.Typed.Name(ISZ(), ISZ(), None())
  val builtInMethods: HashSet[String] = HashSet.empty[String].addAll(ISZ(
    "assert", "assume", "println", "print", "eprintln", "eprint"
  ))

  var _typeHierarchyReporter: Option[(TypeHierarchy, AccumulatingReporter)] = None()

  def typeHierarchyReporter: (TypeHierarchy, AccumulatingReporter) = {
    if (_typeHierarchyReporter.nonEmpty) {
      return _typeHierarchyReporter.get
    }
    val (initNameMap, initTypeMap) = Resolver.addBuiltIns(HashMap.empty, HashMap.empty)
    val (reporter, nameMap, typeMap) = Resolver.parseProgramAndGloballyResolve(
      Library.files, initNameMap, initTypeMap)
    val th = TypeHierarchy.build(TypeHierarchy(nameMap, typeMap, Poset.empty, HashMap.empty), reporter)
    val thOutlined = TypeOutliner.checkOutline(th, reporter)
    val r = (thOutlined, reporter)
    _typeHierarchyReporter = Some(r)
    return r
  }

  @pure def substType(m: HashMap[String, AST.Typed], t: AST.Typed): AST.Typed = {
    t match {
      case t: AST.Typed.Name =>
        if (t.ids.size == 1 && t.args.isEmpty) {
          m.get(t.ids(0)) match {
            case Some(t2) => return t2
            case _ =>
          }
        }
        return t(args = t.args.map(ta => substType(m, ta)))
      case t: AST.Typed.Tuple => return t(args = t.args.map(ta => substType(m, ta)))
      case t: AST.Typed.Fun => return t(args = t.args.map(ta => substType(m, ta)), ret = substType(m, t.ret))
    }
  }

  def buildSubstMap(name: QName,
                    posOpt: Option[AST.PosInfo],
                    typeParams: ISZ[AST.TypeParam],
                    args: ISZ[AST.Typed],
                    reporter: Reporter): Option[HashMap[String, AST.Typed]] = {
    if (typeParams.size != args.size) {
      reporter.error(posOpt, typeCheckerKind, st"Type ${(name, ".")} requires ${typeParams.size} type arguments, but only ${args.size} is supplied.".render)
      return None()
    }
    var substMap = HashMap.empty[String, AST.Typed]
    for (i <- z"0" until args.size) {
      substMap = substMap.put(typeParamName(typeParams(i)), args(i))
    }
    return Some(substMap)
  }

  @pure def isUnitType(t: AST.Typed): B = {
    t match {
      case t: AST.Typed.Tuple if t.args.isEmpty => return T
      case _ => return t == typeUnit
    }
  }

  @pure def isEqType(t1: AST.Typed, t2: AST.Typed): B = {
    (t1, t2) match {
      case (t1: AST.Typed.Name, t2: AST.Typed.Name) =>
        if (t1.args.size != t2.args.size) {
          return F
        }
        if (t1.ids != t2.ids) {
          return F
        }
        for (i <- z"0" until t1.args.size) {
          if (!isEqType(t1.args(i), t2.args(i))) {
            return F
          }
        }
        return T
      case (t1: AST.Typed.Tuple, t2: AST.Typed.Tuple) =>
        if (t1.args.size != t2.args.size) {
          return F
        }
        for (i <- z"0" until t1.args.size) {
          if (!isEqType(t1.args(i), t2.args(i))) {
            return F
          }
        }
        return T
      case (t1: AST.Typed.Fun, t2: AST.Typed.Fun) =>
        if (t1.isPure != t2.isPure || t1.isByName != t2.isByName) {
          return F
        }
        if (t1.args.size != t2.args.size) {
          return F
        }
        if (!isEqType(t1.ret, t2.ret)) {
          return F
        }
        for (i <- z"0" until t1.args.size) {
          if (!isEqType(t1.args(i), t2.args(i))) {
            return F
          }
        }
        return T
      case (t1: AST.Typed.Fun, _) if t1.isByName =>
        return isEqType(t1.ret, t2)
      case (_, t2: AST.Typed.Fun) if t2.isByName =>
        return isEqType(t1, t2.ret)
      case _ =>
        if (isUnitType(t1) && isUnitType(t2)) {
          return T
        }
        return F
    }
  }

  @pure def deBruijn(t: AST.Typed): AST.Typed = {
    var map = HashMap.empty[String, Z]

    def db(t: AST.Typed): AST.Typed = {
      t match {
        case t: AST.Typed.Name =>
          if (t.args.nonEmpty) {
            var args = ISZ[AST.Typed]()
            for (arg <- t.args) {
              val ta = db(arg)
              args = args :+ ta
            }
            return t(args = args)
          } else if (t.ids.size == 1 && isTypeParamNameString(t.ids(0).value)) {
            val k = t.ids(0).value
            val i: Z = map.get(k) match {
              case Some(n) => n
              case _ =>
                val n = map.size
                map = map.put(k, n)
                n
            }
            return t(ids = ISZ(typeParamNameString(s"!$i")))
          } else {
            return t
          }
        case t: AST.Typed.Tuple =>
          var args = ISZ[AST.Typed]()
          for (arg <- t.args) {
            val ta = db(arg)
            args = args :+ ta
          }
          return t(args = args)
        case t: AST.Typed.Fun =>
          var args = ISZ[AST.Typed]()
          for (arg <- t.args) {
            val ta = db(arg)
            args = args :+ ta
          }
          val tr = db(t.ret)
          return t(args = args, ret = tr)
      }
    }

    val r = db(t)
    return r
  }

  @pure def extractMethodType(isPure: B, m: AST.MethodSig): AST.Typed.Fun = {
    var pts = ISZ[AST.Typed]()
    for (p <- m.params) {
      pts = pts :+ p.tipe.typedOpt.get
    }
    val t = deBruijn(AST.Typed.Fun(isPure, F, pts, m.returnType.typedOpt.get, m.id.attr.posOpt))
    t match {
      case t: AST.Typed.Fun => return t
      case _ => halt("Infeasible")
    }
  }

  def checkWorksheet(program: AST.TopUnit.Program,
                     reporter: Reporter): AST.TopUnit.Program = {
    val (th, rep) = typeHierarchyReporter
    if (rep.hasIssue) {
      reporter.reports(rep.messages)
      return program
    }

    val gdr = GlobalDeclarationResolver(th.nameMap, th.typeMap, reporter)
    gdr.resolveProgram(program)
    if (reporter.hasIssue) {
      return program
    }

    val th2 = TypeHierarchy.build(th(nameMap = gdr.globalNameMap, typeMap = gdr.globalTypeMap), reporter)
    if (reporter.hasIssue) {
      return program
    }

    val th3 = TypeOutliner.checkOutline(th2, reporter)
    if (reporter.hasIssue) {
      return program
    }

    val tc = TypeChecker(th3, ISZ())
    val scope = Scope.Local(HashMap.empty, HashMap.empty, None(), Some(Scope.Global(ISZ(), ISZ(), ISZ())))
    val (_, newStmts) = tc.checkStmts(scope, program.body.stmts, reporter)
    return program(body = program.body(newStmts))
  }
}

import TypeChecker._

@datatype class TypeChecker(typeHierarchy: TypeHierarchy,
                            context: QName) {

  val typeB: AST.Typed.Name = {
    val name = ISZ[String]("org", "sireum", "B")
    AST.Typed.Name(name, ISZ(), typeHierarchy.typeMap.get(name).get.posOpt)
  }

  val typeBOpt: Option[AST.Typed] = Some(typeB)

  val typeC: AST.Typed.Name = {
    val name = ISZ[String]("org", "sireum", "C")
    AST.Typed.Name(name, ISZ(), typeHierarchy.typeMap.get(name).get.posOpt)
  }

  val typeCOpt: Option[AST.Typed] = Some(typeC)

  val typeF32: AST.Typed.Name = {
    val name = ISZ[String]("org", "sireum", "F32")
    AST.Typed.Name(name, ISZ(), typeHierarchy.typeMap.get(name).get.posOpt)
  }

  val typeF32Opt: Option[AST.Typed] = Some(typeF32)

  val typeF64: AST.Typed.Name = {
    val name = ISZ[String]("org", "sireum", "F64")
    AST.Typed.Name(name, ISZ(), typeHierarchy.typeMap.get(name).get.posOpt)
  }

  val typeF64Opt: Option[AST.Typed] = Some(typeF64)

  val typeZ: AST.Typed.Name = {
    val name = ISZ[String]("org", "sireum", "Z")
    AST.Typed.Name(name, ISZ(), typeHierarchy.typeMap.get(name).get.posOpt)
  }

  val typeZOpt: Option[AST.Typed] = Some(typeZ)

  val typeR: AST.Typed.Name = {
    val name = ISZ[String]("org", "sireum", "R")
    AST.Typed.Name(name, ISZ(), typeHierarchy.typeMap.get(name).get.posOpt)
  }

  val typeROpt: Option[AST.Typed] = Some(typeR)

  val typeString: AST.Typed.Name = {
    val name = ISZ[String]("org", "sireum", "String")
    AST.Typed.Name(name, ISZ(), typeHierarchy.typeMap.get(name).get.posOpt)
  }

  val typeStringOpt: Option[AST.Typed] = Some(typeString)

  val typeST: AST.Typed.Name = {
    val name = ISZ[String]("org", "sireum", "ST")
    AST.Typed.Name(name, ISZ(), typeHierarchy.typeMap.get(name).get.posOpt)
  }

  val typeSTOpt: Option[AST.Typed] = Some(typeST)

  def basicKind(scope: Scope, t: AST.Typed,
                posOpt: Option[AST.PosInfo],
                reporter: Reporter): Option[(AST.Typed, BasicKind.Type)] = {
    val tpe = typeHierarchy.dealias(t, posOpt, reporter)
    tpe match {
      case tpe: AST.Typed.Name =>
        if (tpe.args.nonEmpty) {
          return None()
        }
        if (tpe.ids.size == 3) {
          if (tpe.ids == typeB.ids) {
            return Some((tpe, BasicKind.B))
          }
          if (tpe.ids == typeZ.ids) {
            return Some((tpe, BasicKind.Z))
          }
          if (tpe.ids == typeC.ids) {
            return Some((tpe, BasicKind.C))
          }
          if (tpe.ids == typeF32.ids) {
            return Some((tpe, BasicKind.F32))
          }
          if (tpe.ids == typeF64.ids) {
            return Some((tpe, BasicKind.F64))
          }
          if (tpe.ids == typeR.ids) {
            return Some((tpe, BasicKind.R))
          }
        }
        scope.resolveType(typeMap, tpe.ids) match {
          case Some(ti: TypeInfo.SubZ) =>
            return Some((tpe, if (ti.ast.isBitVector) BasicKind.Bits else BasicKind.Range))
          case _ =>
        }
      case _ =>
    }
    return None()
  }

  @pure def typeMap: TypeMap = {
    return typeHierarchy.typeMap
  }

  @pure def nameMap: NameMap = {
    return typeHierarchy.nameMap
  }

  def checkExp(expectedOpt: Option[AST.Typed],
               scope: Scope,
               exp: AST.Exp,
               reporter: Reporter): (AST.Exp, Option[AST.Typed]) = {

    @pure def checkExpected(t: AST.Typed): Option[AST.Typed] = {
      expectedOpt match {
        case Some(expected) =>
          if (typeHierarchy.isSubType(t, expected)) {
            return Some(t)
          } else {
            reporter.error(exp.posOpt, typeCheckerKind, s"Expected type $expected, but found $t")
            return None()
          }
        case _ => return Some(t)
      }
    }

    exp match {

      case exp: AST.Exp.Binary =>

        val (left, leftTypeOpt) = checkExp(None(), scope, exp.left, reporter)
        val (right, rightTypeOpt) = checkExp(None(), scope, exp.right, reporter)
        val newBinaryExp = exp(left = left, right = right)
        (leftTypeOpt, rightTypeOpt) match {
          case (Some(leftType), Some(rightType)) =>
            val lOpt = basicKind(scope, leftType, exp.left.posOpt, reporter)
            val rOpt = basicKind(scope, rightType, exp.right.posOpt, reporter)
            (lOpt, rOpt) match {
              case (Some((leftT, leftKind)), Some((rightT, rightKind))) =>
                if (leftKind != rightKind) {
                  reporter.error(exp.posOpt, typeCheckerKind,
                    st"Incompatible types for binary operation ${AST.Util.typedString(leftT)} ${AST.Util.binop(exp.op)} ${AST.Util.typedString(rightT)}.".render)
                  return (newBinaryExp, None())
                }
                if ((leftKind == BasicKind.B && AST.Util.isBoolBinop(exp.op)) ||
                  (AST.Util.isArithBinop(exp.op) && leftKind != BasicKind.B) ||
                  (AST.Util.isBitsBinop(exp.op) && leftKind == BasicKind.Bits)) {
                  var r = newBinaryExp
                  val tOpt = checkExpected(leftT)
                  up(r.attr.typedOpt) = tOpt
                  return (r, tOpt)
                } else if (AST.Util.isCompareBinop(exp.op) && leftKind != BasicKind.B) {
                  var r = newBinaryExp
                  val tOpt: Option[AST.Typed] = checkExpected(typeB)
                  up(r.attr.typedOpt) = tOpt
                  return (r, tOpt)
                } else {
                  reporter.error(exp.posOpt, typeCheckerKind,
                    st"Undefined binary operation ${AST.Util.binop(exp.op)} on ${AST.Util.typedString(leftT)}".render)
                }
                halt("Unimplemented") // TODO
              case _ =>
                halt("Unimplemented") // TODO: find <op> binary methods
            }
          case _ => return (exp(left = left, right = right), None())
        }

      case exp: AST.Exp.Eta => halt("Unimplemented") // TODO

      case exp: AST.Exp.ForYield => halt("Unimplemented") // TODO

      case exp: AST.Exp.Fun => halt("Unimplemented") // TODO

      case exp: AST.Exp.Ident =>
        scope.resolveName(typeHierarchy.nameMap, ISZ(exp.id.value)) match {
          case Some(info: Info.LocalVar) =>
            // TODO: update closure captures
            val tOpt = Some(info.tpe)
            return (exp(attr = exp.attr(typedOpt = tOpt, resOpt = Some(info.resolvedInfo))), tOpt)
          case _ => halt("Unimplemented") // TODO
        }

      case exp: AST.Exp.If => halt("Unimplemented") // TODO

      case exp: AST.Exp.Invoke => halt("Unimplemented") // TODO

      case exp: AST.Exp.InvokeNamed => halt("Unimplemented") // TODO

      case exp: AST.Exp.LitB => return (exp, checkExpected(typeB))

      case exp: AST.Exp.LitC => return (exp, checkExpected(typeC))

      case exp: AST.Exp.LitF32 => return (exp, checkExpected(typeF32))

      case exp: AST.Exp.LitF64 => return (exp, checkExpected(typeF64))

      case exp: AST.Exp.LitR => return (exp, checkExpected(typeR))

      case exp: AST.Exp.LitString => return (exp, checkExpected(typeString))

      case exp: AST.Exp.LitZ => return (exp, checkExpected(typeZ))

      case exp: AST.Exp.Quant => halt("Unimplemented") // TODO

      case exp: AST.Exp.Select => halt("Unimplemented") // TODO

      case exp: AST.Exp.StringInterpolate =>
        var args = ISZ[AST.Exp]()
        var argTypes = ISZ[AST.Typed]()
        var ok = T
        for (arg <- exp.args) {
          val (newArg, argTypeOpt) = checkExp(None(), scope, arg, reporter)
          args = args :+ newArg
          argTypeOpt match {
            case Some(argType) => argTypes = argTypes :+ argType
            case _ => ok = F
          }
        }
        exp.prefix.native match {
          case "s" => return (exp(args = args), checkExpected(typeString))
          case "st" => return (exp(args = args), checkExpected(typeST))
          case _ => halt("Unimplemented") // TODO
        }

      case exp: AST.Exp.Super => halt("Unimplemented") // TODO

      case exp: AST.Exp.This => halt("Unimplemented") // TODO

      case exp: AST.Exp.Tuple =>
        var args = ISZ[AST.Exp]()
        var argTypes = ISZ[AST.Typed]()
        var ok = T
        for (arg <- args) {
          val (newArg, argTypeOpt) = checkExp(None(), scope, arg, reporter)
          args = args :+ newArg
          argTypeOpt match {
            case Some(argType) => argTypes = argTypes :+ argType
            case _ => ok = F
          }
        }
        var r = exp
        up(r.args) = args
        if (!ok) {
          return (r, None())
        }
        val t: AST.Typed = AST.Typed.Tuple(argTypes, exp.posOpt)
        val tOpt = checkExpected(t)
        up(r.attr.typedOpt) = tOpt
        return (r, tOpt)

      case exp: AST.Exp.Unary =>
        val (newExp, expTypeOpt) = checkExp(None(), scope, exp.exp, reporter)
        val newUnaryExp = exp(exp = newExp)
        expTypeOpt match {
          case Some(expType) =>
            val kindOpt = basicKind(scope, expType, exp.posOpt, reporter)
            kindOpt match {
              case Some((tpe, kind)) =>
                if (exp.op == AST.Exp.UnaryOp.Not && kind != BasicKind.B) {
                  reporter.error(exp.posOpt, typeCheckerKind,
                    st"Undefined unary operation ! on ${AST.Util.typedString(tpe)}.".render)
                  return (newUnaryExp, None())
                }
                if (exp.op == AST.Exp.UnaryOp.Complement &&
                  !(kind == BasicKind.B || kind == BasicKind.Bits)) {
                  reporter.error(exp.posOpt, typeCheckerKind,
                    st"Undefined unary operation ~ on ${AST.Util.typedString(tpe)}.".render)
                  return (newUnaryExp, None())
                }
                var r = newUnaryExp
                val tOpt = checkExpected(tpe)
                up(r.attr.typedOpt) = tOpt
                return (newUnaryExp, tOpt)
              case _ =>
                // TODO: resolve unary_<op> on <expType>
                reporter.error(exp.posOpt, typeCheckerKind,
                  st"Undefined unary operation ${AST.Util.unop(exp.op)} on ${AST.Util.typedString(expType)}.".render)
            }
          case _ =>
        }
        return (newExp, None())
    }
  }

  def checkAssignExp(expected: Option[AST.Typed], scope: Scope, aexp: AST.AssignExp,
                     reporter: Reporter): (AST.AssignExp, Option[AST.Typed]) = {
    aexp match {
      case aexp: AST.Stmt.Expr =>
        val (newExp, tOpt) = checkExp(expected, scope, aexp.exp, reporter)
        return (aexp(exp = newExp), tOpt)
      case aexp: AST.Stmt.Block => halt("Unimplemented") // TODO
      case aexp: AST.Stmt.If => halt("Unimplemented") // TODO
      case aexp: AST.Stmt.Match => halt("Unimplemented") // TODO
    }

  }

  def checkStmts(scope: Scope.Local, stmts: ISZ[AST.Stmt],
                 reporter: Reporter): (Option[Scope.Local], ISZ[AST.Stmt]) = {
    var newScope = scope
    var newStmts = ISZ[AST.Stmt]()
    for (i <- z"0" until stmts.size) {
      val (newScope2Opt, newStmt) = checkStmt(newScope, stmts(i), reporter)
      newScope2Opt match {
        case Some(newScope2) =>
          newScope = newScope2
          newStmts = newStmts :+ newStmt
        case _ =>
          for (j <- i until stmts.size) {
            newStmts = newStmts :+ stmts(j)
          }
          return (None(), newStmts)
      }
    }
    return (Some(newScope), newStmts)
  }

  def checkBody(scope: Scope.Local, stmt: AST.Body, reporter: Reporter): (Option[Scope.Local], AST.Body) = {
    val (newScopeOpt, newStmts) = checkStmts(scope, stmt.stmts, reporter)
    return (newScopeOpt, stmt(stmts = newStmts))
  }

  def checkStmt(scope: Scope.Local, stmt: AST.Stmt, reporter: Reporter): (Option[Scope.Local], AST.Stmt) = {

    def checkAssertume(name: String, assertumeStmt: AST.Stmt.Expr, assertumeExp: AST.Exp.Invoke,
                       cond: AST.Exp, msgOpt: Option[AST.Exp]): AST.Stmt = {
      val (newCondExp, _) = checkExp(typeBOpt, scope, cond, reporter)

      msgOpt match {
        case Some(msg) =>
          val (newMsg, _) = checkExp(typeStringOpt, scope, msg, reporter)
          val attr = assertumeExp.attr(typedOpt = typeUnitOpt,
            resOpt = Some(AST.ResolvedInfo.BuiltIn(name)))
          return assertumeStmt(exp = assertumeExp(args = ISZ(newCondExp, newMsg), attr = attr),
            attr = assertumeStmt.attr(typedOpt = typeUnitOpt))
        case _ =>
          val attr = assertumeExp.attr(typedOpt = typeUnitOpt,
            resOpt = Some(AST.ResolvedInfo.BuiltIn(name)))
          return assertumeStmt(exp = assertumeExp(args = ISZ(newCondExp), attr = attr),
            attr = assertumeStmt.attr(typedOpt = typeUnitOpt))
      }
    }

    def checkPrint(name: String, printStmt: AST.Stmt.Expr,
                   printExp: AST.Exp.Invoke, args: ISZ[AST.Exp], reporter: Reporter): AST.Stmt = {
      var newArgs = ISZ[AST.Exp]()
      for (arg <- args) {
        val (newArg, _) = checkExp(None(), scope, arg, reporter)
        newArgs = newArgs :+ newArg
      }
      val attr = printExp.attr(
        typedOpt = typeUnitOpt,
        resOpt = Some(AST.ResolvedInfo.BuiltIn(name)))
      return printStmt(exp = printExp(args = newArgs, attr = attr),
        attr = printStmt.attr(typedOpt = typeUnitOpt))
    }

    def checkExpr(stmt: AST.Stmt.Expr): AST.Stmt = {
      stmt.exp match {

        case exp@AST.Exp.Invoke(None(), AST.Id(name), targs, args) if targs.isEmpty && builtInMethods.contains(name) =>
          val (isPrint: B, isAssertume: B) = name.native match {
            case "assert" => (F, T)
            case "assume" => (F, T)
            case "println" => (T, F)
            case "print" => (T, F)
            case "eprintln" => (T, F)
            case "eprint" => (T, F)
            case _ => (F, F)
          }
          if (isAssertume) {
            args.size match {
              case z"1" => val r = checkAssertume(name, stmt, exp, args(0), None()); return r
              case z"2" => val r = checkAssertume(name, stmt, exp, args(0), Some(args(1))); return r
              case _ =>
                reporter.error(stmt.exp.posOpt, typeCheckerKind,
                  s"Invalid number of arguments (${args.size}) for $name.")
                return stmt
            }
          }
          if (isPrint) {
            val r = checkPrint(name, stmt, exp, args, reporter)
            return r
          }
          halt(s"Unimplemented built-in method $name.")
        case _ => halt("Unimplemented.") // TODO
      }
    }

    def checkImport(stmt: AST.Stmt.Import): (Option[Scope.Local], AST.Stmt) = {
      // TODO: resolve import

      @pure def addImport(s: Scope.Local): Scope.Local = {
        s.outerOpt match {
          case Some(outer: Scope.Local) => s(outerOpt = Some(addImport(outer)))
          case Some(outer: Scope.Global) => s(outerOpt = Some(outer(imports = outer.imports :+ stmt)))
          case _ => halt("Unexpected local scope without an outer scope.")
        }
      }

      return (Some(addImport(scope)), stmt)
    }

    def checkVar(stmt: AST.Stmt.Var): (Option[Scope.Local], AST.Stmt) = {
      val key = stmt.id.value

      def err(): Unit = {
        reporter.error(stmt.id.attr.posOpt, typeCheckerKind, s"Cannot declare $key because the name has already been declared previously.")
      }

      val name = context :+ stmt.id.value
      var r = stmt
      scope.resolveName(typeHierarchy.nameMap, ISZ(key)) match {
        case Some(other: Info.Var) =>
          r = other.ast
          if (stmt.attr.posOpt != other.posOpt) {
            err()
            return (None(), r)
          }
        case Some(_) =>
          err()
          return (None(), r)
        case _ =>
      }
      val expected: Option[AST.Typed] = stmt.tipeOpt match {
        case Some(tipe) =>
          tipe.typedOpt match {
            case tOpt@Some(_) => tOpt
            case _ =>
              val tOpt = typeHierarchy.typed(scope, tipe, reporter)
              if (tOpt.isEmpty) {
                return (None(), r)
              }
              r = r(tipeOpt = Some(tipe.typed(tOpt.get)))
              tOpt
          }
        case _ => None()
      }
      val (rhs, tOpt) = checkAssignExp(expected, scope, stmt.initOpt.get, reporter)
      tOpt match {
        case Some(t) =>
          val newScope = scope(nameMap = scope.nameMap.put(key,
            Info.LocalVar(name, r.id, t, AST.ResolvedInfo.LocalVar(context, key))))
          val newStmt = r(initOpt = Some(rhs))
          return (Some(newScope), newStmt)
        case _ =>
          return (None(), r)
      }
    }

    def checkAssign(stmt: AST.Stmt.Assign): AST.Stmt = {
      stmt.lhs match {
        case lhs: AST.Exp.Ident =>
          scope.resolveName(typeHierarchy.nameMap, ISZ(lhs.id.value)) match {
            case Some(info: Info.LocalVar) =>
              val expected = Some(info.tpe)
              val (rhs, _) = checkAssignExp(expected, scope, stmt.rhs, reporter)
              return stmt(lhs = lhs(attr = lhs.attr(resOpt = Some(info.resolvedInfo), typedOpt = expected)),
                rhs = rhs)
            case Some(_) => halt("Unimplemented.") // TODO
            case _ => halt("Unimplemented.") // TODO
          }
        case _ => halt("Unimplemented.") // TODO
      }
    }

    stmt match {

      case stmt: AST.Stmt.LStmt => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.AbstractDatatype => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.Assign => val r = checkAssign(stmt); return (Some(scope), r)

      case stmt: AST.Stmt.AssignPattern => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.AssignUp => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.Block =>
        val (_, newBody) = checkBody(scope, stmt.body, reporter)
        return (Some(scope), stmt(body = newBody))

      case stmt: AST.Stmt.DoWhile =>
        val (newScopeOpt, newBody) = checkBody(scope, stmt.body, reporter)
        newScopeOpt match {
          case Some(newScope) =>
            val (newCond, _) = checkExp(typeBOpt, newScope, stmt.cond, reporter)
            return (Some(scope), stmt(cond = newCond, body = newBody))
          case _ =>
            return (None(), stmt(body = newBody))
        }

      case stmt: AST.Stmt.Enum => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.Expr => val r = checkExpr(stmt); return (Some(scope), r)

      case stmt: AST.Stmt.ExtMethod => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.For => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.If =>
        val (newCond, _) = checkExp(typeBOpt, scope, stmt.cond, reporter)
        val (_, tBody) = checkBody(scope, stmt.thenbody, reporter)
        val (_, eBody) = checkBody(scope, stmt.elsebody, reporter)
        return (Some(scope), stmt(cond = newCond, thenbody = tBody, elsebody = eBody))

      case stmt: AST.Stmt.Import => val r = checkImport(stmt); return r

      case stmt: AST.Stmt.Match => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.Method => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.Object => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.Return =>
        (scope.returnOpt, stmt.expOpt) match {
          case (tOpt@Some(_), Some(exp)) =>
            val (newExp, expTypeCond) = checkExp(tOpt, scope, exp, reporter)
            expTypeCond match {
              case Some(t) =>
                if (typeHierarchy.isSubType(t, tOpt.get)) {
                  reporter.error(exp.posOpt, typeCheckerKind,
                    s"Expecting type ${AST.Util.typedString(tOpt.get)}, but found incompatible type ${AST.Util.typedString(t)}.")
                }
                return (Some(scope), stmt(expOpt = Some(newExp), attr = stmt.attr(typedOpt = tOpt)))
              case _ => return (None(), stmt(expOpt = Some(newExp)))
            }
          case (Some(t), _) =>
            reporter.error(stmt.posOpt, typeCheckerKind,
              s"Expecting type ${AST.Util.typedString(t)}, but none found.")
            return (None(), stmt)
          case (_, Some(exp)) =>
            val (newExp, _) = checkExp(None(), scope, exp, reporter)
            reporter.error(exp.posOpt, typeCheckerKind, s"Unexpected return expression.")
            return (None(), stmt(expOpt = Some(newExp)))
          case _ =>
            return (Some(scope), stmt)
        }

      case stmt: AST.Stmt.Sig => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.SpecMethod => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.SpecVar => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.SubZ => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.TypeAlias => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.Var => val r = checkVar(stmt); return r

      case stmt: AST.Stmt.VarPattern => halt("Unimplemented.") // TODO

      case stmt: AST.Stmt.While =>
        val (newCond, _) = checkExp(typeBOpt, scope, stmt.cond, reporter)
        val (_, newBody) = checkBody(scope, stmt.body, reporter)
        return (Some(scope), stmt(cond = newCond, body = newBody))

    }
  }


}
