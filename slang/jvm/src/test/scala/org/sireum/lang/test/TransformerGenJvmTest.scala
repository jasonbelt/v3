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

package org.sireum.lang.test

import java.io.File

import org.sireum.test.SireumSpec
import Paths._
import com.sksamuel.diffpatch.DiffMatchPatch
import org.sireum.lang.tools.TransformerGenJvm
import org.sireum.lang.util.{AccumulatingReporter, FileUtil}
import org.sireum.ISZ

class TransformerGenJvmTest extends SireumSpec {

  *(gen(slangAstPath, slangMTransformerPath, isImmutable = false))

  *(gen(slangAstPath, slangTransformerPath, isImmutable = true))

  def gen(src: File, dest: File, isImmutable: Boolean): Boolean = {
    val reporter = AccumulatingReporter(ISZ())
    val rOpt = TransformerGenJvm(allowSireumPackage = true,
      isImmutable, Some(licensePath), src, dest, None, reporter)
    reporter.printMessages()
    rOpt match {
      case Some(r) =>
        val expected = FileUtil.readFile(dest)
        val result = r
        if (result != expected) {
          val dmp = new DiffMatchPatch()
          Console.err.println(dmp.patch_toText(dmp.patch_make(expected, result)))
          Console.err.flush()
          //FileUtil.writeFile(dest, r)
          //Console.err.println(r)
          //Console.err.flush()
          false
        } else !reporter.hasIssue
      case _ => false
    }
  }
}
