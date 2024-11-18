package main.scala.typer

import main.scala.ast.Term
import Term.*
import unify.TVar

object Typer :
  type Env = Map[String, Type]

  val env0: Env =
    val a1 = TVar()
    val a2 = TVar()
    val a3 = TVar()
    Map[String, Type](
      "head" -> FUNCTION(LIST(a1), a1),
      "tail" -> FUNCTION(LIST(a2), LIST(a2)),
      "is_empty" -> FUNCTION(LIST(a3), INT),
    )

  def typer(t: Term, e: Env): Type = t match
    case Lit(_) => INT
    case BOp(op, t1, t2) =>
      val a = typer(t1, e)
      val b = typer(t2, e)
      if a === INT && b === INT then INT
      else throw new TypeError(s"term $t with environment $e")

    case IfZ(test, t1, t2) =>
      val a = typer(test, e)
      val b = typer(t1, e)
      val c = typer(t2, e)
      if a === INT && b === c then b
      else throw new TypeError(s"term $t with environment $e")

    case Var(x) =>
      e.get(x) match
        case Some(a: Type) => a
        case None => throw new TypeError(s"undefined variable $x in $e")

    case Let(x, t1, t2) =>
      val A = typer(t1, e)
      val e1 = e + (x -> A)
      typer(t2, e1)

    case Fun(x, t) =>
      val X = TVar()
      val e1 = e + (x -> X)
      val A = typer(t, e1)
      FUNCTION(X, A)

    case Fix(x, t) =>
      val X = TVar()
      val e1 = e + (x -> X)
      val A = typer(t, e1)
      if X === A then A
      else throw new TypeError(s"term $t with environment $e")

    case App(t1, t2) =>
      val A = typer(t2, e)
      val B = typer(t1, e)
      val X = TVar()
      val Y = TVar()
      if B === FUNCTION(A, Y) then Y
      else if A === LIST(X) && B === FUNCTION(X, Y) then LIST(Y)
      else throw new TypeError(s"term $t with environment $e")

    case TNil() => LIST(TVar())

    case TList(ts) =>
      val As = ts.map(t => typer(t, e))
      val A = As.head
      if As.forall(a => a === A || a === typer(TNil(), e)) then LIST(A)
      else throw new TypeError(s"term $t with environment $e")

    case Cons(t, ts) =>
      val A = typer(t, e)
      val L = typer(ts, e)
      if L === typer(TNil(), e) then LIST(A) else
      if L === LIST(A) then L
      else throw new TypeError(s"term $t with environment $e")