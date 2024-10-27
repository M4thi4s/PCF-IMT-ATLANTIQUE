package interp

import ast.Term
import Term.*
import ast.Op.*
import Value.*

import scala.language.implicitConversions

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
    case App(t1, t2) =>
      val v1 = interp(t1, e)
      v1 match
        case Closure(id, t0, e0) =>
          val v2 = interp(t2, e)
          interp(t0, e0 + (id -> v2))
        case _ => throw new InterpError(s"unexpected function $v1 in $t")
    case Fix(x, t) =>
      interp(t, e + (x -> IceCube(x, t, e)))

    case TNil() => VNil()
    case TList(ts) => VList(ts.map(t => interp(t, e)))
    case Cons(t, ts) =>
      val v = interp(t, e)
      val vs = interp(ts, e)
      vs match
        case VNil() => VList(List(v))
        case VList(vs) => VList(v :: vs)
        case _ => throw new InterpError(s"unexpected value $vs in $t")

    case TList(ts) =>
      VList(ts.map(t => interp(t, e)))

    case Cons(t1, t2) =>
      val v = interp(t1, e)
      val VList(vs) = interp(t2, e) // interpreter t1 doit rendre une liste de valeurs
      VList(v :: vs)

  // ATerm part (TP 2)
  enum Code:
    case Ins(ins: String)
    case Seq(seq: List[Code])
    case Test(code1: Code, code2: Code)

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
      val thenBranch = emit(t2)
      val elseBranch = emit(t3)
      Code.Seq(List(test, Code.Ins("if (result i32)"), Code.Test(thenBranch, elseBranch), Code.Ins("end")))
    case _ => throw new NotImplementedError(s"Code generation not implemented for $term")

  private def spaces(depth: Int): String = (for i <- 0 until depth yield "  ").mkString

  private def format(d: Int, code: Code): String = code match
    case Code.Ins(s) => s"${spaces(d)}$s\n"
    case Code.Seq(seq) => seq.map(format(d, _)).mkString
    case Code.Test(code1, code2) =>
      s"${spaces(d)}then\n${format(d + 1, code1)}${spaces(d)}else\n${format(d + 1, code2)}"

  def prelude(): String =
    val source = Source.fromFile("pcf/prelude.wat")
    val contents = source.mkString
    source.close()
    contents

  def gen(t: ATerm): String =
    val preludeContent = prelude()
    s"""$preludeContent
       |(func (export "main") (result i32)
       |  ${format(2, emit(t))}
       |  return))""".stripMargin