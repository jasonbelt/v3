/*
 Copyright (c) 2016, Robby, Kansas State University
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

package org.sireum.logika.eval

import org.sireum.logika.ast._
import org.sireum.logika.math._
import org.sireum.logika.collection._
import org.sireum.util._

object Eval {
  type Value = Any
  type Store = IMap[String, Value]

  final private val z8Type = Z8Type()
  final private val z16Type = Z16Type()
  final private val z32Type = Z32Type()
  final private val z64Type = Z64Type()
  final private val nType = NType()
  final private val n8Type = N8Type()
  final private val n16Type = N16Type()
  final private val n32Type = N32Type()
  final private val n64Type = N64Type()
  final private val s8Type = S8Type()
  final private val s16Type = S16Type()
  final private val s32Type = S32Type()
  final private val s64Type = S32Type()
  final private val u8Type = U8Type()
  final private val u16Type = U16Type()
  final private val u32Type = U32Type()
  final private val u64Type = U64Type()

  def simplify(bitWidth: Int, store: Store)(e: Exp): Exp = {
    org.sireum.logika.ast.Rewriter.build[Exp](
      mode = org.sireum.util.Rewriter.TraversalMode.BOTTOM_UP)({
      case n: BooleanLit => n
      case n: IntLit => n
      case n: RealLit => n
      case n: FloatLit => n
      case n: SeqLit => n
      case n: Exp => evalExp(store)(n) match {
        case Some(v) => toLit(bitWidth, v)
        case _ => n
      }
    })(e)
  }

  def assignVar(store: Store)(x: String, e: Exp): Option[(Store, Value)] =
    for (v <- evalExp(store)(e)) yield (store + (x -> v), v)

  def assignSeq(store: Store)(id: Id, index: Exp, e: Exp): Option[(Store, Value, Value)] =
    for (ms <- evalExp(store)(id);
         i <- evalExp(store)(index);
         v <- evalExp(store)(e)) yield ((ms, i, v): @unchecked) match {
      case (ms: MS[_, _], i: LogikaIntegralNumber, v: Value) =>
        val ms2 = ms.clone.asInstanceOf[MS[LogikaIntegralNumber, Value]]
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
    }

  def evalExp(store: Store)(e: Exp): Option[Value] =
    try {
      new Eval(store).eval(e)
    } catch {
      case _: IndexOutOfBoundsException |
           _: ArithmeticException |
           _: IllegalArgumentException => None
    }

  def toLit(bitWidth: Int, v: Value): Exp = v match {
    case v: Boolean => BooleanLit(v)
    case v: Z => IntLit(v.toString, bitWidth, None)
    case v: ZT#Value =>
      v.bitWidth match {
        case 8 => IntLit(v.toString, 8, Some(z8Type))
        case 16 => IntLit(v.toString, 16, Some(z16Type))
        case 32 => IntLit(v.toString, 32, Some(z32Type))
        case 64 => IntLit(v.toString, 64, Some(z64Type))
      }
    case v: N => IntLit(v.toString, bitWidth, Some(nType))
    case v: NT#Value =>
      v.bitWidth match {
        case 8 => IntLit(v.toString, 8, Some(n8Type))
        case 16 => IntLit(v.toString, 16, Some(n16Type))
        case 32 => IntLit(v.toString, 32, Some(n32Type))
        case 64 => IntLit(v.toString, 64, Some(n64Type))
      }
    case v: ST#Value =>
      v.bitWidth match {
        case 8 => IntLit(v.toString, 8, Some(s8Type))
        case 16 => IntLit(v.toString, 16, Some(s16Type))
        case 32 => IntLit(v.toString, 32, Some(s32Type))
        case 64 => IntLit(v.toString, 64, Some(s64Type))
      }
    case v: UT#Value =>
      v.bitWidth match {
        case 8 => IntLit(v.toString, 8, Some(u8Type))
        case 16 => IntLit(v.toString, 16, Some(u16Type))
        case 32 => IntLit(v.toString, 32, Some(u32Type))
        case 64 => IntLit(v.toString, 64, Some(u64Type))
      }
    case v: R => RealLit(v.toString)
    case v: FT#Value =>
      v.bitWidth match {
        case 32 => FloatLit(v.floatValue.toString + "f")
        case 64 => FloatLit(v.doubleValue.toString + "d")
      }
    case v: S[_, _] => SeqLit(???, v.elements.toVector.map(e => toLit(bitWidth, e)))
  }
}

import Eval._

private final class Eval(store: Store) {

  def eval(exp: Exp): Option[Value] = exp match {
    case BooleanLit(v) => Some(v)
    case Id(v) => store.get(v)
    case Size(e) => for (v <- eval(e)) yield v match {
      case v: S[_, _] => v.size
    }
    case Clone(id) => for (v <- eval(id)) yield v match {
      case v: S[_, _] => v.clone
    }
    case _: Result => store.get("result")
    case Apply(id, Seq(arg)) =>
      try for (ms <- eval(id);
               i <- eval(arg)) yield (ms, i) match {
        case (s: S[_, _], i: LogikaIntegralNumber) => s.asInstanceOf[S[LogikaIntegralNumber, Value]](i)
        case _ => None
      }
      catch {
        case _: IndexOutOfBoundsException => None
      }
    case _: RandomInt => None
    case _: ReadInt => None
    case e: IntLit =>
      val v = Z(e.normalize)
      Some(if (e.tpeOpt.isDefined) e.tpeOpt.get match {
        case _: ZType => v
        case _: Z8Type => v.toZ8
        case _: Z16Type => v.toZ16
        case _: Z32Type => v.toZ32
        case _: Z64Type => v.toZ64
        case _: NType => v
        case _: N8Type => v.toN8
        case _: N16Type => v.toN16
        case _: N32Type => v.toN32
        case _: N64Type => v.toN64
        case _: S8Type => v.toS8
        case _: S16Type => v.toS16
        case _: S32Type => v.toS32
        case _: S64Type => v.toS64
        case _: U8Type => v.toU8
        case _: U16Type => v.toU16
        case _: U32Type => v.toU32
        case _: U64Type => v.toU64
      } else v)
    case e: FloatLit =>
      Some(e.primitiveValue match {
        case Left(v) => F32(v)
        case Right(v) => F64(v)
      })
    case e: RealLit => Some(R(e.value))
    case e: IntMin =>
      if (e.bitWidth == 0) None
      else {
        val v = Z(e.value)
        Some(e.integralType match {
          case _: ZType => v.toZ
          case _: Z8Type => v.toZ8
          case _: Z16Type => v.toZ16
          case _: Z32Type => v.toZ32
          case _: Z64Type => v.toZ64
          case _: NType => v
          case _: N8Type => v.toN8
          case _: N16Type => v.toN16
          case _: N32Type => v.toN32
          case _: N64Type => v.toN64
          case _: S8Type => v.toS8
          case _: S16Type => v.toS16
          case _: S32Type => v.toS32
          case _: S64Type => v.toS64
          case _: U8Type => v.toU8
          case _: U16Type => v.toU16
          case _: U32Type => v.toU32
          case _: U64Type => v.toU64
        })
      }
    case e: IntMax =>
      if (e.bitWidth == 0) None
      else {
        val v = Z(e.value)
        Some(e.integralType match {
          case _: ZType => v.toZ
          case _: Z8Type => v.toZ8
          case _: Z16Type => v.toZ16
          case _: Z32Type => v.toZ32
          case _: Z64Type => v.toZ64
          case _: NType => v
          case _: N8Type => v.toN8
          case _: N16Type => v.toN16
          case _: N32Type => v.toN32
          case _: N64Type => v.toN64
          case _: S8Type => v.toS8
          case _: S16Type => v.toS16
          case _: S32Type => v.toS32
          case _: S64Type => v.toS64
          case _: U8Type => v.toU8
          case _: U16Type => v.toU16
          case _: U32Type => v.toU32
          case _: U64Type => v.toU64
        })
      }
    case _: Random => None
    case e: Mul =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield ((v1, v2): @unchecked) match {
        case (v1: Z, v2: Z) => v1 * v2
        case (v1: Z8.Value, v2: Z8.Value) => v1 * v2
        case (v1: Z16.Value, v2: Z16.Value) => v1 * v2
        case (v1: Z32.Value, v2: Z32.Value) => v1 * v2
        case (v1: Z64.Value, v2: Z64.Value) => v1 * v2
        case (v1: N, v2: N) => v1 * v2
        case (v1: N8.Value, v2: N8.Value) => v1 * v2
        case (v1: N16.Value, v2: N16.Value) => v1 * v2
        case (v1: N32.Value, v2: N32.Value) => v1 * v2
        case (v1: N64.Value, v2: N64.Value) => v1 * v2
        case (v1: S8.Value, v2: S8.Value) => v1 * v2
        case (v1: S16.Value, v2: S16.Value) => v1 * v2
        case (v1: S32.Value, v2: S32.Value) => v1 * v2
        case (v1: S64.Value, v2: S64.Value) => v1 * v2
        case (v1: U8.Value, v2: U8.Value) => v1 * v2
        case (v1: U16.Value, v2: U16.Value) => v1 * v2
        case (v1: U32.Value, v2: U32.Value) => v1 * v2
        case (v1: U64.Value, v2: U64.Value) => v1 * v2
        case (v1: R, v2: R) => v1 * v2
        case (v1: F32.Value, v2: F32.Value) => v1 * v2
        case (v1: F64.Value, v2: F64.Value) => v1 * v2
      }
    case e: Div =>
      try for (v1 <- eval(e.left);
               v2 <- eval(e.right)) yield ((v1, v2): @unchecked) match {
        case (v1: Z, v2: Z) => v1 / v2
        case (v1: Z8.Value, v2: Z8.Value) => v1 / v2
        case (v1: Z16.Value, v2: Z16.Value) => v1 / v2
        case (v1: Z32.Value, v2: Z32.Value) => v1 / v2
        case (v1: Z64.Value, v2: Z64.Value) => v1 / v2
        case (v1: N, v2: N) => v1 / v2
        case (v1: N8.Value, v2: N8.Value) => v1 / v2
        case (v1: N16.Value, v2: N16.Value) => v1 / v2
        case (v1: N32.Value, v2: N32.Value) => v1 / v2
        case (v1: N64.Value, v2: N64.Value) => v1 / v2
        case (v1: S8.Value, v2: S8.Value) => v1 / v2
        case (v1: S16.Value, v2: S16.Value) => v1 / v2
        case (v1: S32.Value, v2: S32.Value) => v1 / v2
        case (v1: S64.Value, v2: S64.Value) => v1 / v2
        case (v1: U8.Value, v2: U8.Value) => v1 / v2
        case (v1: U16.Value, v2: U16.Value) => v1 / v2
        case (v1: U32.Value, v2: U32.Value) => v1 / v2
        case (v1: U64.Value, v2: U64.Value) => v1 / v2
        case (v1: R, v2: R) => v1 / v2
        case (v1: F32.Value, v2: F32.Value) => v1 / v2
        case (v1: F64.Value, v2: F64.Value) => v1 / v2
      } catch {
        case _: ArithmeticException => None
      }
    case e: Rem =>
      try for (v1 <- eval(e.left);
               v2 <- eval(e.right)) yield ((v1, v2): @unchecked) match {
        case (v1: Z, v2: Z) => v1 % v2
        case (v1: Z8.Value, v2: Z8.Value) => v1 % v2
        case (v1: Z16.Value, v2: Z16.Value) => v1 % v2
        case (v1: Z32.Value, v2: Z32.Value) => v1 % v2
        case (v1: Z64.Value, v2: Z64.Value) => v1 % v2
        case (v1: N, v2: N) => v1 % v2
        case (v1: N8.Value, v2: N8.Value) => v1 % v2
        case (v1: N16.Value, v2: N16.Value) => v1 % v2
        case (v1: N32.Value, v2: N32.Value) => v1 % v2
        case (v1: N64.Value, v2: N64.Value) => v1 % v2
        case (v1: S8.Value, v2: S8.Value) => v1 % v2
        case (v1: S16.Value, v2: S16.Value) => v1 % v2
        case (v1: S32.Value, v2: S32.Value) => v1 % v2
        case (v1: S64.Value, v2: S64.Value) => v1 % v2
        case (v1: U8.Value, v2: U8.Value) => v1 % v2
        case (v1: U16.Value, v2: U16.Value) => v1 % v2
        case (v1: U32.Value, v2: U32.Value) => v1 % v2
        case (v1: U64.Value, v2: U64.Value) => v1 % v2
        case (v1: R, v2: R) => v1 % v2
        case (v1: F32.Value, v2: F32.Value) => v1 % v2
        case (v1: F64.Value, v2: F64.Value) => v1 % v2
      } catch {
        case _: ArithmeticException => None
      }
    case e: Add =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield ((v1, v2): @unchecked) match {
        case (v1: Z, v2: Z) => v1 + v2
        case (v1: Z8.Value, v2: Z8.Value) => v1 + v2
        case (v1: Z16.Value, v2: Z16.Value) => v1 + v2
        case (v1: Z32.Value, v2: Z32.Value) => v1 + v2
        case (v1: Z64.Value, v2: Z64.Value) => v1 + v2
        case (v1: N, v2: N) => v1 + v2
        case (v1: N8.Value, v2: N8.Value) => v1 + v2
        case (v1: N16.Value, v2: N16.Value) => v1 + v2
        case (v1: N32.Value, v2: N32.Value) => v1 + v2
        case (v1: N64.Value, v2: N64.Value) => v1 + v2
        case (v1: S8.Value, v2: S8.Value) => v1 + v2
        case (v1: S16.Value, v2: S16.Value) => v1 + v2
        case (v1: S32.Value, v2: S32.Value) => v1 + v2
        case (v1: S64.Value, v2: S64.Value) => v1 + v2
        case (v1: U8.Value, v2: U8.Value) => v1 + v2
        case (v1: U16.Value, v2: U16.Value) => v1 + v2
        case (v1: U32.Value, v2: U32.Value) => v1 + v2
        case (v1: U64.Value, v2: U64.Value) => v1 + v2
        case (v1: R, v2: R) => v1 + v2
        case (v1: F32.Value, v2: F32.Value) => v1 + v2
        case (v1: F64.Value, v2: F64.Value) => v1 + v2
      }
    case e: Sub =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield ((v1, v2): @unchecked) match {
        case (v1: Z, v2: Z) => v1 - v2
        case (v1: Z8.Value, v2: Z8.Value) => v1 - v2
        case (v1: Z16.Value, v2: Z16.Value) => v1 - v2
        case (v1: Z32.Value, v2: Z32.Value) => v1 - v2
        case (v1: Z64.Value, v2: Z64.Value) => v1 - v2
        case (v1: N, v2: N) => v1 - v2
        case (v1: N8.Value, v2: N8.Value) => v1 - v2
        case (v1: N16.Value, v2: N16.Value) => v1 - v2
        case (v1: N32.Value, v2: N32.Value) => v1 - v2
        case (v1: N64.Value, v2: N64.Value) => v1 - v2
        case (v1: S8.Value, v2: S8.Value) => v1 - v2
        case (v1: S16.Value, v2: S16.Value) => v1 - v2
        case (v1: S32.Value, v2: S32.Value) => v1 - v2
        case (v1: S64.Value, v2: S64.Value) => v1 - v2
        case (v1: U8.Value, v2: U8.Value) => v1 - v2
        case (v1: U16.Value, v2: U16.Value) => v1 - v2
        case (v1: U32.Value, v2: U32.Value) => v1 - v2
        case (v1: U64.Value, v2: U64.Value) => v1 - v2
        case (v1: R, v2: R) => v1 - v2
        case (v1: F32.Value, v2: F32.Value) => v1 - v2
        case (v1: F64.Value, v2: F64.Value) => v1 - v2
      }
    case e: Lt =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield ((v1, v2): @unchecked) match {
        case (v1: Z, v2: Z) => v1 < v2
        case (v1: Z8.Value, v2: Z8.Value) => v1 < v2
        case (v1: Z16.Value, v2: Z16.Value) => v1 < v2
        case (v1: Z32.Value, v2: Z32.Value) => v1 < v2
        case (v1: Z64.Value, v2: Z64.Value) => v1 < v2
        case (v1: N, v2: N) => v1 < v2
        case (v1: N8.Value, v2: N8.Value) => v1 < v2
        case (v1: N16.Value, v2: N16.Value) => v1 < v2
        case (v1: N32.Value, v2: N32.Value) => v1 < v2
        case (v1: N64.Value, v2: N64.Value) => v1 < v2
        case (v1: S8.Value, v2: S8.Value) => v1 < v2
        case (v1: S16.Value, v2: S16.Value) => v1 < v2
        case (v1: S32.Value, v2: S32.Value) => v1 < v2
        case (v1: S64.Value, v2: S64.Value) => v1 < v2
        case (v1: U8.Value, v2: U8.Value) => v1 < v2
        case (v1: U16.Value, v2: U16.Value) => v1 < v2
        case (v1: U32.Value, v2: U32.Value) => v1 < v2
        case (v1: U64.Value, v2: U64.Value) => v1 < v2
        case (v1: R, v2: R) => v1 < v2
        case (v1: F32.Value, v2: F32.Value) => v1 < v2
        case (v1: F64.Value, v2: F64.Value) => v1 < v2
      }
    case e: Le =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield ((v1, v2): @unchecked) match {
        case (v1: Z, v2: Z) => v1 <= v2
        case (v1: Z8.Value, v2: Z8.Value) => v1 <= v2
        case (v1: Z16.Value, v2: Z16.Value) => v1 <= v2
        case (v1: Z32.Value, v2: Z32.Value) => v1 <= v2
        case (v1: Z64.Value, v2: Z64.Value) => v1 <= v2
        case (v1: N, v2: N) => v1 <= v2
        case (v1: N8.Value, v2: N8.Value) => v1 <= v2
        case (v1: N16.Value, v2: N16.Value) => v1 <= v2
        case (v1: N32.Value, v2: N32.Value) => v1 <= v2
        case (v1: N64.Value, v2: N64.Value) => v1 <= v2
        case (v1: S8.Value, v2: S8.Value) => v1 <= v2
        case (v1: S16.Value, v2: S16.Value) => v1 <= v2
        case (v1: S32.Value, v2: S32.Value) => v1 <= v2
        case (v1: S64.Value, v2: S64.Value) => v1 <= v2
        case (v1: U8.Value, v2: U8.Value) => v1 <= v2
        case (v1: U16.Value, v2: U16.Value) => v1 <= v2
        case (v1: U32.Value, v2: U32.Value) => v1 <= v2
        case (v1: U64.Value, v2: U64.Value) => v1 <= v2
        case (v1: R, v2: R) => v1 <= v2
        case (v1: F32.Value, v2: F32.Value) => v1 <= v2
        case (v1: F64.Value, v2: F64.Value) => v1 <= v2
      }
    case e: Gt =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield ((v1, v2): @unchecked) match {
        case (v1: Z, v2: Z) => v1 > v2
        case (v1: Z8.Value, v2: Z8.Value) => v1 > v2
        case (v1: Z16.Value, v2: Z16.Value) => v1 > v2
        case (v1: Z32.Value, v2: Z32.Value) => v1 > v2
        case (v1: Z64.Value, v2: Z64.Value) => v1 > v2
        case (v1: N, v2: N) => v1 > v2
        case (v1: N8.Value, v2: N8.Value) => v1 > v2
        case (v1: N16.Value, v2: N16.Value) => v1 > v2
        case (v1: N32.Value, v2: N32.Value) => v1 > v2
        case (v1: N64.Value, v2: N64.Value) => v1 > v2
        case (v1: S8.Value, v2: S8.Value) => v1 > v2
        case (v1: S16.Value, v2: S16.Value) => v1 > v2
        case (v1: S32.Value, v2: S32.Value) => v1 > v2
        case (v1: S64.Value, v2: S64.Value) => v1 > v2
        case (v1: U8.Value, v2: U8.Value) => v1 > v2
        case (v1: U16.Value, v2: U16.Value) => v1 > v2
        case (v1: U32.Value, v2: U32.Value) => v1 > v2
        case (v1: U64.Value, v2: U64.Value) => v1 > v2
        case (v1: R, v2: R) => v1 > v2
        case (v1: F32.Value, v2: F32.Value) => v1 > v2
        case (v1: F64.Value, v2: F64.Value) => v1 > v2
      }
    case e: Ge =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield ((v1, v2): @unchecked) match {
        case (v1: Z, v2: Z) => v1 >= v2
        case (v1: Z8.Value, v2: Z8.Value) => v1 >= v2
        case (v1: Z16.Value, v2: Z16.Value) => v1 >= v2
        case (v1: Z32.Value, v2: Z32.Value) => v1 >= v2
        case (v1: Z64.Value, v2: Z64.Value) => v1 >= v2
        case (v1: N, v2: N) => v1 >= v2
        case (v1: N8.Value, v2: N8.Value) => v1 >= v2
        case (v1: N16.Value, v2: N16.Value) => v1 >= v2
        case (v1: N32.Value, v2: N32.Value) => v1 >= v2
        case (v1: N64.Value, v2: N64.Value) => v1 >= v2
        case (v1: S8.Value, v2: S8.Value) => v1 >= v2
        case (v1: S16.Value, v2: S16.Value) => v1 >= v2
        case (v1: S32.Value, v2: S32.Value) => v1 >= v2
        case (v1: S64.Value, v2: S64.Value) => v1 >= v2
        case (v1: U8.Value, v2: U8.Value) => v1 >= v2
        case (v1: U16.Value, v2: U16.Value) => v1 >= v2
        case (v1: U32.Value, v2: U32.Value) => v1 >= v2
        case (v1: U64.Value, v2: U64.Value) => v1 >= v2
        case (v1: R, v2: R) => v1 >= v2
        case (v1: F32.Value, v2: F32.Value) => v1 >= v2
        case (v1: F64.Value, v2: F64.Value) => v1 >= v2
      }
    case e: Shr =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield ((v1, v2): @unchecked) match {
        case (v1: S8.Value, v2: S8.Value) => v1 >> v2
        case (v1: S16.Value, v2: S16.Value) => v1 >> v2
        case (v1: S32.Value, v2: S32.Value) => v1 >> v2
        case (v1: S64.Value, v2: S64.Value) => v1 >> v2
      }
    case e: UShr =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield ((v1, v2): @unchecked) match {
        case (v1: S8.Value, v2: S8.Value) => v1 >>> v2
        case (v1: S16.Value, v2: S16.Value) => v1 >>> v2
        case (v1: S32.Value, v2: S32.Value) => v1 >>> v2
        case (v1: S64.Value, v2: S64.Value) => v1 >>> v2
        case (v1: U8.Value, v2: U8.Value) => v1 >>> v2
        case (v1: U16.Value, v2: U16.Value) => v1 >>> v2
        case (v1: U32.Value, v2: U32.Value) => v1 >>> v2
        case (v1: U64.Value, v2: U64.Value) => v1 >>> v2
      }
    case e: Shl =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield ((v1, v2): @unchecked) match {
        case (v1: S8.Value, v2: S8.Value) => v1 << v2
        case (v1: S16.Value, v2: S16.Value) => v1 << v2
        case (v1: S32.Value, v2: S32.Value) => v1 << v2
        case (v1: S64.Value, v2: S64.Value) => v1 << v2
        case (v1: U8.Value, v2: U8.Value) => v1 << v2
        case (v1: U16.Value, v2: U16.Value) => v1 << v2
        case (v1: U32.Value, v2: U32.Value) => v1 << v2
        case (v1: U64.Value, v2: U64.Value) => v1 << v2
      }
    case e: Eq =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield v1 == v2
    case e: Ne =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield v1 != v2
    case e: Append =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield ((v1, v2): @unchecked) match {
        case (v1: S[_, _], v2: Value) => v1.asInstanceOf[S[LogikaIntegralNumber, Value]] :+ v2
      }
    case e: Prepend =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield ((v2, v1): @unchecked) match {
        case (v2: S[_, _], v1: Boolean) => v1 +: v2.asInstanceOf[S[LogikaIntegralNumber, Value]]
      }
    case e: And =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield ((v1, v2): @unchecked) match {
        case (v1: Boolean, v2: Boolean) => v1 & v2
        case (v1: S8.Value, v2: S8.Value) => v1 & v2
        case (v1: S16.Value, v2: S16.Value) => v1 & v2
        case (v1: S32.Value, v2: S32.Value) => v1 & v2
        case (v1: S64.Value, v2: S64.Value) => v1 & v2
        case (v1: U8.Value, v2: U8.Value) => v1 & v2
        case (v1: U16.Value, v2: U16.Value) => v1 & v2
        case (v1: U32.Value, v2: U32.Value) => v1 & v2
        case (v1: U64.Value, v2: U64.Value) => v1 & v2
      }
    case e: Xor =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield ((v1, v2): @unchecked) match {
        case (v1: Boolean, v2: Boolean) => v1 ^ v2
        case (v1: S8.Value, v2: S8.Value) => v1 ^| v2
        case (v1: S16.Value, v2: S16.Value) => v1 ^| v2
        case (v1: S32.Value, v2: S32.Value) => v1 ^| v2
        case (v1: S64.Value, v2: S64.Value) => v1 ^| v2
        case (v1: U8.Value, v2: U8.Value) => v1 ^| v2
        case (v1: U16.Value, v2: U16.Value) => v1 ^| v2
        case (v1: U32.Value, v2: U32.Value) => v1 ^| v2
        case (v1: U64.Value, v2: U64.Value) => v1 ^| v2
      }
    case e: Or =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield ((v1, v2): @unchecked) match {
        case (v1: Boolean, v2: Boolean) => v1 | v2
        case (v1: S8.Value, v2: S8.Value) => v1 | v2
        case (v1: S16.Value, v2: S16.Value) => v1 | v2
        case (v1: S32.Value, v2: S32.Value) => v1 | v2
        case (v1: S64.Value, v2: S64.Value) => v1 | v2
        case (v1: U8.Value, v2: U8.Value) => v1 | v2
        case (v1: U16.Value, v2: U16.Value) => v1 | v2
        case (v1: U32.Value, v2: U32.Value) => v1 | v2
        case (v1: U64.Value, v2: U64.Value) => v1 | v2
      }
    case e: Implies =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield ((v1, v2): @unchecked) match {
        case (v1: Boolean, v2: Boolean) => !v1 | v2
      }
    case e: Not =>
      for (v <- eval(e.exp)) yield (v: @unchecked) match {
        case v: Boolean => !v
        case v: S8.Value => ~v
        case v: S16.Value => ~v
        case v: S32.Value => ~v
        case v: S64.Value => ~v
        case v: U8.Value => ~v
        case v: U16.Value => ~v
        case v: U32.Value => ~v
        case v: U64.Value => ~v
      }
    case e: Minus =>
      for (v <- eval(e.exp)) yield (v: @unchecked) match {
        case v: Z => -v
        case v: S8.Value => -v
        case v: S16.Value => -v
        case v: S32.Value => -v
        case v: S64.Value => -v
        case v: R => -v
        case v: F32.Value => -v
        case v: F64.Value => -v
      }
    case _: ForAll => None
    case _: Exists => None
    case e: SeqLit =>
      var args = ivectorEmpty[Value]
      for (arg <- e.args) eval(arg) match {
        case Some(v) => args :+= arg
        case _ => return None
      }
      Some(e.tpe match {
        case _: ZSType => MS[Z, Z](args.map(_.asInstanceOf[Z]): _*)
        case _ => ???
      })
  }
}
