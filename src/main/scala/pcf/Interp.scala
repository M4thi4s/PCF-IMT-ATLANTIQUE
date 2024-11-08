package main.scala.pcf

import main.scala
import main.scala.ast.Term
import main.scala.interp.Interp.interp
import main.scala.interp.{Interp, Value}
import main.scala.parser.{ASTVisitor, ErrorListener, PCFParser, ReportingPCFLexer, SyntaxError}
import main.scala.typer.{Type, Typer}
import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream}

import java.io.{FileInputStream, InputStream}

object Interp :
  def main(args: Array[String]): Unit =
    val is = if (args.length == 0) System.in else new FileInputStream(args(0))
    val verbose = args.length == 0 || args.length > 0 && args(1) == "-v"
    val (result, a) = interpret(is, verbose)
    println(s"==> $result: $a")

  def interpret(is: InputStream, verbose: Boolean): (Value, Type) =
    val input = new ANTLRInputStream(is)
    // val lexer = new CalcLexer(input)
    val lexer = new ReportingPCFLexer(input)
    val tokens = new CommonTokenStream(lexer)
    val parser = new PCFParser(tokens)
    parser.removeErrorListeners()
    parser.addErrorListener(new ErrorListener())
    val tree = parser.term()
    if (verbose) println(s"ANTLR Parse Tree: ${tree.toStringTree(parser)}")
    if ! scala.parser.Error.flag then
      val visitor = new ASTVisitor
      val term = visitor.visit(tree).asInstanceOf[Term]
      if (verbose) println(s"AST: $term")
      val a = Typer.typer(term, Map[String, Type]())
      val result = interp(term, Map())
      (result, a)
    else throw new SyntaxError(scala.parser.Error.msg)



