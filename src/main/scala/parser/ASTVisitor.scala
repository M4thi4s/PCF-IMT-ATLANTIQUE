package main.scala.parser

import PCFParser.*
import main.scala.ast.{AST, Op, Term}
import main.scala.ast.Term.*

import java.util
import scala.jdk.CollectionConverters.*

class ASTVisitor[AST] extends PCFBaseVisitor[AST] :
  override def visitLit(ctx: LitContext): AST =
    Lit(ctx.getText.toInt).asInstanceOf[AST]

  override def visitBOp(ctx: BOpContext): AST =
    val s = ctx.getChild(1).getText
    val op = Op.parse(s)
    // ctx.term is a Java list, it is translated in a Scala list
    // (initially, to an instance of Buffer, using a collection
    // converter, as Java lists are mutable)
    val ANTLRTerms = ctx.term.asScala.toList
    val List(term1, term2) =
      for (ANTLRTerm <- ANTLRTerms) yield
        visit(ANTLRTerm).asInstanceOf[Term]
    BOp(op, term1, term2).asInstanceOf[AST]

  override def visitIfZ(ctx: IfZContext): AST =
    val ANTLRTerms = ctx.term.asScala.toList
    val List(term1, term2, term3) =
      for (ANTLRTerm <- ANTLRTerms) yield
        visit(ANTLRTerm).asInstanceOf[Term]
    IfZ(term1, term2, term3).asInstanceOf[AST]

  override def visitVar(ctx: VarContext): AST =
      Var(ctx.getText).asInstanceOf[AST]

  override def visitLet(ctx: LetContext): AST =
    val id = ctx.ID.getText
    val ANTLRTerms = ctx.term.asScala.toList
    val List(term1, term2) =
      for (ANTLRTerm <- ANTLRTerms) yield
        visit(ANTLRTerm).asInstanceOf[Term]
    Let(id, term1, term2).asInstanceOf[AST]

  override def visitFun(ctx: FunContext): AST =
    val id = ctx.ID.getText
    val ANTLRTerm = ctx.term
    val term =
        visit(ANTLRTerm).asInstanceOf[Term]
    Fun(id, term).asInstanceOf[AST]

  override def visitApp(ctx: AppContext): AST =
    val ANTLRTerms = ctx.term.asScala.toList
    val List(term1, term2) =
      for (ANTLRTerm <- ANTLRTerms) yield
        visit(ANTLRTerm).asInstanceOf[Term]
    App(term1, term2).asInstanceOf[AST]

  override def visitFix(ctx: FixContext): AST =
    val id = ctx.ID.getText
    val ANTLRTerm = ctx.term
    val term =
      visit(ANTLRTerm).asInstanceOf[Term]
    Fix(id, term).asInstanceOf[AST]

  override def visitPar(ctx: ParContext): AST =
    visit(ctx.term)

  override def visitNil(ctx: NilContext): AST =
    TNil().asInstanceOf[AST]

  override def visitList(ctx: ListContext): AST =
    var ANTLRTerms = ctx.term.asScala.toList
    val terms = for (ANTLRTerm <- ANTLRTerms) yield
      visit(ANTLRTerm).asInstanceOf[Term]
    TList(terms).asInstanceOf[AST]

  override def visitCons(ctx: ConsContext): AST =
    val term1 = visit(ctx.term(0)).asInstanceOf[Term]
    val term2 = visit(ctx.term(1)).asInstanceOf[Term]
    Cons(term1, term2).asInstanceOf[AST]
