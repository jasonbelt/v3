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

package org.sireum.test

import org.junit.Assert
import org.sireum.util._

object JUnitTestFramework extends TestFramework {

  override def assertEquals(expected: Any, result: Any): Unit = {
    (expected, result) match {
      case (expected: Product, result: Product) =>
        Assert.assertEquals(
          ProductUtil.toScalaString(expected).toString(),
          ProductUtil.toScalaString(result).toString())
      case (expected: CMap[Any, Any]@unchecked, result: CMap[Any, Any]@unchecked) =>
        for ((k, v) <- expected) {
          result.get(k) match {
            case Some(v2) => Assert.assertEquals(s"Mapping for $k was not equal", v, v2)
            case _ => Assert.assertTrue(s"No mapping for $k was found in result", false)
          }
        }
        if (expected.size != result.size) {
          for ((k, v) <- result if !expected.contains(k)) {
            Assert.assertTrue(s"Did not expect: $k -> $v", false)
          }
        }
      case (expected: Iterable[Any]@unchecked, result: Iterable[Any]@unchecked) =>
        var i = 0
        val ie = expected.iterator
        val ir = result.iterator
        while (ie.hasNext && ir.hasNext) {
          Assert.assertEquals(s"Element at $i is not equal", ie.next(), ir.next())
          i += 1
        }
        compareResult(ie.size.compareTo(ir.size)) match {
          case CompareResult.LT =>
            var rest = ivectorEmpty[Any]
            while (ir.hasNext) rest = rest :+ ir.next()
            Assert.assertTrue(s"Did not expect elements starting at $i: $rest", false)
          case CompareResult.GT =>
            var rest = ivectorEmpty[Any]
            while (ie.hasNext) rest = rest :+ ie.next()
            Assert.assertTrue(s"Expected element starting at $i: $rest", false)
          case _ =>
        }
      case _ => Assert.assertEquals(expected, result)
    }
  }

  override def assertEqualsRaw(expected: Any, result: Any): Unit = Assert.assertEquals(expected, result)

  override def assertEmpty(it: Iterable[_]): Unit = {
    if (it.nonEmpty) {
      Console.err.println("Expecting an empty iterable but found: ")
      for (e <- it) {
        Console.err.print("- ")
        e match {
          case e: Product =>
            Console.err.println(ProductUtil.toScalaString(e, 1).toString())
          case _ => Console.err.println(e)
        }
      }
      Console.err.flush()
    }
    Assert.assertTrue(it.isEmpty)
  }

  override def assertTrue(b: Boolean): Unit =
    Assert.assertTrue(b)
}
