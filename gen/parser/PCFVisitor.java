// Generated from /Users/mnocet/Documents/Education/IMT-Atlantique/S5/ingenierie-des-langages/PCF-V2/PCF/src/parser/PCF.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PCFParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PCFVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Par}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPar(PCFParser.ParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code App}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApp(PCFParser.AppContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BOp}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBOp(PCFParser.BOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Fix}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFix(PCFParser.FixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Lit}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLit(PCFParser.LitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(PCFParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Let}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(PCFParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfZ}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfZ(PCFParser.IfZContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Fun}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(PCFParser.FunContext ctx);
}