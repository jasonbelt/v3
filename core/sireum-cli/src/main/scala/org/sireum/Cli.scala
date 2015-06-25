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

package org.sireum

import org.sireum.option._

object Cli {
  private type M = Vector[(String, (Array[String], Int, Product) => Unit)]

  final val topCommand = "sireum"

  final def main(args: Array[String]): Unit = {
    new Cli().parseSireumOption(args, 0)
  }

  private implicit class At[T](val a: Array[T]) extends AnyVal {
    def at(i: Int): Option[T] =
      if (i < a.length) Some(a(i)) else None
  }

}

final class Cli {

  import Cli._

  val sireumOptionMap: M = Vector(
    ("pilar", parsePilarOption _)
  )
  val pilarOptionMap: M = Vector(
    ("parser", parsePilarParserOption _)
  )

  def parseSireumOption(args: Array[String], index: Int, o: Product = SireumOption()): Unit = {

    if (index < 0 || index >= args.length) {
      println(
        // @formatter:off
        """
          |Sireum: A Software Analysis Platform (v3)
          |(c) 2011-2015, SAnToS Laboratory, Kansas State University
          |http://sireum.org
          |
          |Usage: sireum <mode>
          |
          |Available mode:
          |
          |pilar    Pilar IR tooling
        """.stripMargin.trim
        // @formatter:on
      )
      return
    }
    select(args, index, sireumOptionMap, o)
  }

  def parsePilarOption(args: Array[String], index: Int, o: Product = PilarOption()): Unit = {
    if (index < 0 || index >= args.length) {
      println(
        // @formatter:off
        """
          |Pilar: Sireum's Intermediate Representation (IR)
          |
          |Usage: sireum pilar <mode>
          |
          |Available mode:
          |
          |parser   Pilar parser, pretty printer, JSON de/serializer
        """.stripMargin.trim
        // @formatter:on
      )
      return
    }
    select(args, index, pilarOptionMap, o)
  }

  def parsePilarParserOption(args: Array[String], index: Int, o: Product = PilarParserOption()): Unit = {
    val len = args.length
    var foundHelp = false
    val option = o.asInstanceOf[PilarParserOption]

    var i = index
    var processingOptions = true
    while (i < len && processingOptions) {
      args(i) match {
        case "-h" | "--help" =>
          foundHelp = true
        case "-in" | "--standard-input" =>
          option.standardInput = true
        case "-f" | "--output-file" =>
          args.at(i) match {
            case Some(arg) =>
              option.outputFile = Some(arg)
            case _ =>
              println("Expecting a path for output file")
              return
          }
        case "-i" | "--input-mode" =>
          i += 1
          args.at(i) match {
            case Some("pilar") => option.inputMode = "pilar"
            case Some("json") => option.inputMode = "json"
            case Some("auto") => option.inputMode = "auto"
            case Some(arg) =>
              println(s"Only either 'pilar', 'json', or 'auto' is allowed for input mode instead of '$arg'")
              return
            case None =>
              println("Expected either 'pilar', 'json', or 'auto' for input mode")
              return
          }
        case "-o" | "--output-mode" =>
          i += 1
          args.at(i) match {
            case Some("pilar") => option.inputMode = "pilar"
            case Some("json") => option.inputMode = "json"
            case Some(arg) =>
              println(s"Only either 'pilar' or 'auto' is allowed for output mode instead of '$arg'")
              return
            case None =>
              println("Expected either 'pilar' or 'auto' for output mode")
              return
          }
        case "-a" | "--antlr4" =>
          option.antlr4 = true
        case "-e" | "--max-errors" =>
          i += 1
          args.at(i) match {
            case Some(arg) =>
              try arg.toString catch {
                case t: Throwable =>
                  println(s"Invalid integer for max errors: 'arg'")
                  return
              }
            case _ =>
              println("Expected an integer value for max errors")
          }
        case _ => processingOptions = false
      }

      if (processingOptions) i += 1
    }

    while (i < len) {
      option.inputs = option.inputs :+ args(i)
      i += 1
    }

    if (foundHelp) {
      println(
        // @formatter:off
        s"""
           |Pilar Parser
           |... and pretty printer and JSON de/serializer
           |
           |Usage: sireum pilar parser <file-1> ... <file-N>
           |
           |Options:
           | -a,  --antlr4            Use ANTLR4 Pilar parser instead of the hand-written one
           | -e,  --max-errors        Maximum number of errors found before parsing stop; default: ${option.maxErrors}
           | -i,  --input-mode        Input mode { auto, pilar, json, scala }; default: ${option.inputMode}
           |-in,  --standard-input    Use standard input stream
           | -f,  --output-file       Output file (if unspecified, use standard output stream)
           | -o,  --output-mode       Output mode { pilar, json, scala }; default: ${option.outputMode}
           | -h,  --help              Display usage information
        """.stripMargin.trim
        // @formatter:on
      )
      return
    }

    org.sireum.pilar.parser.Parser.run(option)
  }

  private def select(args: Array[String], index: Int, m: M, o: Product): Unit = {
    val arg = args(index)
    m.indexWhere(_._1 == arg) match {
      case -1 =>
        val selections = m.zipWithIndex.filter(_._1._1.startsWith(arg))
        selections.size match {
          case 0 =>
            println(s"$arg is not a mode for: $topCommand ${args.slice(0, index).mkString(" ")}")
          case 1 =>
            val p = o.productElement(selections.head._2).asInstanceOf[Product]
            selections.head._1._2(args, index + 1, p)
          case _ =>
            println("Did you mean one of the following modes?")
            for ((mode, _) <- selections) {
              println(mode)
            }
        }
      case i =>
        m(i)._2(args, index + 1, o.productElement(i).asInstanceOf[Product])
    }
  }

}