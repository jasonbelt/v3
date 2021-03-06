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


package ffi

import GitHub.RequestableCallback

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

object GitHub {
  type RequestableCallback = js.Function3[js.Dynamic, js.Dynamic, js.Dynamic, js.Any]
}

@js.native
@JSGlobal
class GitHub(auth: RequestableAuth = ???, apiBase: String = ???) extends js.Object {
  def getRepo(user: String, repo: String): Repository = js.native
  def getRateLimit(): RateLimit = js.native
}

@js.native
trait RequestableAuth extends js.Object {
  var username: String = js.native
  var password: String = js.native
  var token: String = js.native
}

@js.native
trait Repository extends js.Object {
  def getContents(ref: String, path: String, raw: Boolean, cb: RequestableCallback): js.Promise[js.Dynamic] = js.native
  def getDetails(cb: RequestableCallback): js.Promise[js.Dynamic] = js.native
  def getContributors(cb: RequestableCallback): js.Promise[js.Dynamic] = js.native
  def writeFile(branch: String, path: String, content: String, message: String, option: WriteOption, cb: RequestableCallback): js.Promise[js.Dynamic] = js.native
  def deleteFile(branch: String, path: String, cb: RequestableCallback): js.Promise[js.Dynamic] = js.native
}

@js.native
trait WriteOption extends js.Object {
  var encode: Boolean = js.native
}

@js.native
trait RateLimit extends js.Object {
  def getRateLimit(cb: RequestableCallback): js.Promise[js.Dynamic] = js.native
}