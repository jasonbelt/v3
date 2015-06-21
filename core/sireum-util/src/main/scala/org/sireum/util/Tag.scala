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

package org.sireum.util

sealed trait Tag {
  def kind: String
}

sealed trait UriTag {
  def uri: Uri
}

sealed trait LocationInfoTag {
  def lineBegin: Int

  def columnBegin: Int

  def lineEnd: Int

  def columnEnd: Int

  def offset: Int

  def length: Int
}

sealed trait SeverityTag

sealed trait ErrorTag extends SeverityTag

sealed trait WarningTag extends SeverityTag

sealed trait InfoTag extends SeverityTag

sealed trait MessageTag {
  def message: String
}

final case class
LocationInfo(lineBegin: Int,
             columnBegin: Int,
             lineEnd: Int,
             columnEnd: Int,
             offset: Int,
             length: Int)
  extends LocationInfoTag

final case class
FileLocationInfoErrorMessage(kind: String,
                             uri: Uri,
                             lineBegin: Int,
                             columnBegin: Int,
                             lineEnd: Int,
                             columnEnd: Int,
                             offset: Int,
                             length: Int,
                             message: String)
  extends UriTag
  with LocationInfoTag
  with ErrorTag
  with MessageTag


final case class
FileLocationInfoWarningMessage(kind: String,
                               uri: Uri,
                               lineBegin: Int,
                               columnBegin: Int,
                               lineEnd: Int,
                               columnEnd: Int,
                               offset: Int,
                               length: Int,
                               message: String)
  extends UriTag
  with LocationInfoTag
  with WarningTag
  with MessageTag


final case class
FileLocationInfoInfoMessage(kind: String,
                            uri: Uri,
                            lineBegin: Int,
                            columnBegin: Int,
                            lineEnd: Int,
                            columnEnd: Int,
                            offset: Int,
                            length: Int,
                            message: String)
  extends UriTag
  with LocationInfoTag
  with InfoTag
  with MessageTag


final case class
LocationInfoErrorMessage(kind: String,
                         lineBegin: Int,
                         columnBegin: Int,
                         lineEnd: Int,
                         columnEnd: Int,
                         offset: Int,
                         length: Int,
                         message: String)
  extends LocationInfoTag
  with ErrorTag
  with MessageTag


final case class
LocationInfoWarningMessage(kind: String,
                           lineBegin: Int,
                           columnBegin: Int,
                           lineEnd: Int,
                           columnEnd: Int,
                           offset: Int,
                           length: Int,
                           message: String)
  extends LocationInfoTag
  with WarningTag
  with MessageTag


final case class
LocationInfoInfoMessage(kind: String,
                        lineBegin: Int,
                        columnBegin: Int,
                        lineEnd: Int,
                        columnEnd: Int,
                        offset: Int,
                        length: Int,
                        message: String)
  extends LocationInfoTag
  with InfoTag
  with MessageTag


final case class
ErrorMessage(kind: String,
             message: String)
  extends ErrorTag
  with MessageTag


final case class
WarningMessage(kind: String,
               message: String)
  extends WarningTag
  with MessageTag


final case class
InfoMessage(kind: String,
            message: String)
  extends InfoTag
  with MessageTag