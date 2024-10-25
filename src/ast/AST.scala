package ast

trait AST

import ast.Op.{DIVIDE, MINUS, PLUS, TIMES}

enum Term extends AST :
  case Lit(n: Int)
  case BOp(op: Op, t1: Term, t2: Term)
  case IfZ(t1: Term, t2: Term, t3: Term)
  case Var(id: String)
  case Let(id: String, t1: Term, t2: Term)
  case Fun(id: String, t: Term)
  case App(t1: Term, t2: Term)
  case Fix(id: String, t: Term)
  case TNil()
  case TList(ts: List[Term])
  case Cons(t: Term, ts: Term)

enum Op :
  case PLUS, MINUS, TIMES, DIVIDE

object Op :
  def parse(s: String): Op = s match
    case "+" => PLUS
    case "-" => MINUS
    case "*" => TIMES
    case "/" => DIVIDE
    case _ => ??? // should never happen



