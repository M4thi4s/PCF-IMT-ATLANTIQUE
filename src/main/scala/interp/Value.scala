package main.scala.interp

import Interp.Env
import main.scala.ast.Term

enum Value :
  case IntVal(i: Int)
  case Closure(x: String, t: Term, e: Env)
  case VNil()
  case VList(vs: List[Value])
  case VCons(v: Value, vs: Value)
  case BuiltIn(id: String)

  override def toString: String = this match
    case IntVal(i) => i.toString
    case Closure(x, t, e) => s"<closure $x -> $t>"
    case VNil() => "[]"
    case VList(vs) => s"[$vs]"
    case VCons(v, vs) => s"$v : $vs"
    case BuiltIn(id) => s"<built-in function $id>"

case class IceCube(x: String, t: Term, e: Env)
