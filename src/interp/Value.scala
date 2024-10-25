package interp

import interp.Interp.Env
import ast.Term

enum Value :
  case IntVal(i: Int)
  case Closure(x: String, t: Term, e: Env)
  case VNil
  case VCons(h: Value, t: Value)
  case BuiltIn(id: String)
  case VList(vs: List[Value])

  override def toString: String = this match
    case IntVal(i) => i.toString
    case Closure(x, t, e) => s"<closure $x -> $t>"
    case VNil => "[]"
    case VCons(h, t) => s"$h : $t"
    case BuiltIn(id) => s"<built-in function $id>"
    case VList(vs) => s"[$vs]"

case class IceCube(x: String, t: Term, e: Env)
