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

package org.sireum.option

import org.sireum.option.annotation._
import org.sireum.util._

import scala.beans.BeanProperty

@Mode(
  name = "java",
  header =
    """
      |Sireum Java Tooling
    """,
  description = "Java tooling"
)
final case class JavaOption(@BeanProperty
                            var translator: JavaBytecodeTranslatorOption = JavaBytecodeTranslatorOption()) {
  def this() = this(JavaBytecodeTranslatorOption())
}


@Main(
  name = "translator",
  header =
    """
      |Sireum Java Bytecode Translator
    """,
  description = "Java bytecode translator",
  handler = "org.sireum.java.translator.JavaBytecodeTranslator"
)
final case class JavaBytecodeTranslatorOption(@BeanProperty
                                              @Opt(shortKey = Some("v"), description = "Verbose mode")
                                              var verbose: Boolean = false,
                                              @BeanProperty
                                              @Arg(name = "{class-name,file.{class,zip,jar},dir-path}")
                                              var inputs: Array[String] = Array()) {
  def this() = this(false, Array())
}
