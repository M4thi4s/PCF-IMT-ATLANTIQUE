package main.scala.interp

import main.scala.ast.{ATerm, Term}
import Term.*
import main.scala.ast.Op.*
import Value.*

import scala.io.Source
import scala.language.implicitConversions

// ATerm part (TP 2)
enum Code:
  case Ins(ins: String)
  case Seq(seq: List[Code])
  case Test(code1: Code, code2: Code)

object Interp :
  type Env = Map[String, Value | IceCube]
  implicit def Int2Value(i: Int): Value = IntVal(i)
  implicit def Value2Int(v: Value): Int =
    v match
      case IntVal(i) => i
      case _ => throw new InterpError(s"expecting integer, found $v")

  def interp(t: Term, e: Env): Value = t match
    case Lit(value) => value
    case BOp(op, t1, t2) =>
      val v1 = interp(t1, e)
      val v2 = interp(t2, e)
      op match
        case PLUS => v1 + v2
        case MINUS => v1 - v2
        case TIMES => v1 * v2
        case DIVIDE => v1 / v2
    case IfZ(test, t1, t2) =>
      if interp(test, e) == IntVal(0) then interp(t1, e)
      else interp(t2, e)
    case Var(x) =>
      e.get(x) match
        case Some(IceCube(x1, t1, e1)) => interp(Fix(x1, t1), e1)
        case Some(value: Value) => value
        case None => throw new InterpError(s"undefined variable $x in $e")
    case Let(x, t1, t2) =>
      val v1 = interp(t1, e)
      val e1 = e + (x -> v1)
      interp(t2, e1)
    case Fun(x, t) =>
      Closure(x, t, e)
    case Fix(x, t) =>
      interp(t, e + (x -> IceCube(x, t, e)))
    case App(t1, t2) =>
      val v1 = interp(t1, e)
      v1 match
        case Closure(id, t0, e0) =>
          val v2 = interp(t2, e)
          v2 match
            case VList(vs) =>
              vs.foldLeft(v2)((acc, v) => interp(t0, e0 + (id -> v)))
            case _ => interp(t0, e0 + (id -> v2))
        case _ => throw new InterpError(s"unexpected function $v1 in $t")

    case TNil() => VNil()
    case TList(ts) => VList(ts.map(t => interp(t, e)))
    case Cons(t, ts) =>
      val v = interp(t, e)
      val vs = interp(ts, e)
      vs match
        case VNil() => VList(List(v))
        case VList(vs) => VList(v :: vs)
        case _ => throw new InterpError(s"unexpected value $vs in $t")

  // Variables
  private var idx = 0 // next index in the table of closure bodies
  private var bodies: List[Code] = Nil // list of closure bodies

  // push $ENV on the stack
  private val PushEnv: Code =
    Code.Seq(List(Code.Ins(";; PushEnv"), Code.Ins("global.get $ENV")))

  // pop $ENV from the stack
  private val PopEnv: Code =
    Code.Seq(List(Code.Ins(";; PopEnv"),
      Code.Ins("global.set $ACC"),
      Code.Ins("global.set $ENV"),
      Code.Ins("global.get $ACC")))

  // retrieve value of variable with de Bruijn index idx
  private def Search(idx: Int): Code =
    Code.Seq(List(Code.Ins(s"i32.const $idx"), Code.Ins("(global.get $ENV)"), Code.Ins("call $search")))

  // extend the environment with the value on top of the stack using cons
  private val Extend: Code =
    Code.Seq(List(Code.Ins(";; Extend"),
      Code.Ins("global.get $ENV"),
      Code.Ins("call $cons"),
      Code.Ins("global.set $ENV")))

  // build the closure of index idx
  private def MkClos(idx: Int): Code =
    Code.Seq(List(Code.Ins(";; MkClos"),
      Code.Ins(s"i32.const $idx"),
      Code.Ins("global.get $ENV"),
      Code.Ins("call $pair")))

  private val Apply: Code = Code.Ins("call $apply")

  private def emit(term: ATerm): Code = term match
    case ATerm.Lit(n) => Code.Ins(s"i32.const $n")

    case ATerm.BOp(op, t1, t2) =>
      val left = emit(t1)
      val right = emit(t2)
      val opCode = op match
        case PLUS => "i32.add"
        case MINUS => "i32.sub"
        case TIMES => "i32.mul"
        case DIVIDE => "i32.div_s"
      Code.Seq(List(left, right, Code.Ins(opCode)))

    case ATerm.IfZ(t1, t2, t3) =>
      val test = emit(t1)
      // on inverse les branches then et else car par définition le if de wasm est faux si la dernière valeur est 0
      val elseBranch = emit(t2)
      val thenBranch = emit(t3)
      Code.Seq(List(test, Code.Ins("if (result i32)"), Code.Test(thenBranch, elseBranch), Code.Ins("end")))

    case ATerm.Var(id, idx) =>
      Code.Seq(List(Code.Ins(";; Var"),
        Search(idx)))

    case ATerm.Let(id, t1, t2) =>
      val value = emit(t1)
      val body = emit(t2)
      Code.Seq(List(Code.Ins(";; Let"), PushEnv, value, Extend, body, PopEnv))

    case ATerm.Fun(id, t) =>
      val body = emit(t)
      val clos = MkClos(idx)
      bodies = bodies :+ body
      idx += 1
      Code.Seq(List(Code.Ins(";; Fun"), clos))

    case ATerm.Fix(id, t) =>
      val idx = this.idx
      val c = emit(t)
      Code.Seq(List(Code.Ins(";; Fix"), MkClos(idx)))

    case ATerm.App(t1, t2) =>
      val fun = emit(t1)
      t2 match
        case ATerm.Cons(t1, t2) =>
          val head = emit(t1)
          val tail = emit(ATerm.App(t1, t2))
          val args = List(head, tail)
          val apps = args.map(arg => Code.Seq(List(Code.Ins(";; App"), PushEnv, arg, fun, Apply, PopEnv, Code.Ins(""))))
          Code.Seq(apps)
        case ATerm.TList(ts) =>
          val args = ts.map(emit)
          val apps = args.map(arg => Code.Seq(List(Code.Ins(";; App"), PushEnv, arg, fun, Apply, PopEnv, Code.Ins(""))))
          Code.Seq(apps)
        case _ =>
          val arg = emit(t2)
          Code.Seq(List(Code.Ins(";; App"), PushEnv, arg, fun, Apply, PopEnv))

    case ATerm.TNil() => Code.Ins("i32.const 0")

    case ATerm.TList(ts) =>
      val codes = ts.map(emit)
      if codes.isEmpty then
        Code.Ins("i32.const 0")
      else
        val init = Code.Ins("i32.const 0")
        val cons = Code.Ins("call $cons")
        val seq = codes.map(code => Code.Seq(List(code, cons))).prepended(init)
        Code.Seq(seq)

    case ATerm.Cons(t1, t2) =>
      val head = emit(t1)
      val tail = emit(t2)
      val cons = Code.Ins("call $cons")
      Code.Seq(List(head, tail, cons))
    case _ => throw new NotImplementedError(s"Code generation not implemented for $term")

  /** Text generation */

  private def spaces(depth: Int): String = (for i <- 0 until depth yield "  ").mkString

  private def format(d: Int, code: Code): String = code match
    case Code.Ins(s) => s"${spaces(d)}$s\n"
    case Code.Seq(seq) => seq.map(format(d, _)).mkString
    case Code.Test(code1, code2) =>
      s"${format(d + 1, code1)}${spaces(d)}else\n${format(d + 1, code2)}"

  private def prelude(): String =
    val source = Source.fromFile("pcf/prelude.wat")
    val contents = source.mkString
    source.close()
    contents

  // generate table of function references
  private def emitTable: String =
    val table = bodies.indices.map(functionName).mkString(" ")
    s"\n  (table funcref\n\t(elem\n\t  $table\n\t)\n  )\n"

  // generate functions for closure bodies
  private def emitFunctions: String =
    bodies.zipWithIndex.map((body, i) => emitFunction(i, body)).mkString

  private def emitFunction(i: Int, body: Code): String =
    val name = functionName(i)
    val code = format(2, body)
    s"\n  (func $name (result i32)\n" +
       s"$code" +
       s"\treturn\n  )".stripMargin

  private def functionName(i: Int) = "$closure" + i

  def gen(term: ATerm): String =
    val postlude = ")\n"
    idx = 0
    bodies = Nil
    val body =
      "(func (export \"main\") (result i32)\n" +
        format(2, emit(term)) +
        "\treturn\n  )"
    // return
    s"""${prelude()}$emitTable$emitFunctions
       |  $body
       |$postlude""".stripMargin