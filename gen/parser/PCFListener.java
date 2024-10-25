// Generated from /Users/mnocet/Documents/Education/IMT-Atlantique/S5/ingenierie-des-langages/PCF-V2/PCF/src/parser/PCF.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PCFParser}.
 */
public interface PCFListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Par}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void enterPar(PCFParser.ParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Par}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void exitPar(PCFParser.ParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code App}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void enterApp(PCFParser.AppContext ctx);
	/**
	 * Exit a parse tree produced by the {@code App}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void exitApp(PCFParser.AppContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BOp}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void enterBOp(PCFParser.BOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BOp}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void exitBOp(PCFParser.BOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Fix}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void enterFix(PCFParser.FixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Fix}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void exitFix(PCFParser.FixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lit}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void enterLit(PCFParser.LitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lit}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void exitLit(PCFParser.LitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void enterVar(PCFParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void exitVar(PCFParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Let}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void enterLet(PCFParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Let}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void exitLet(PCFParser.LetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfZ}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void enterIfZ(PCFParser.IfZContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfZ}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void exitIfZ(PCFParser.IfZContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Fun}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void enterFun(PCFParser.FunContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Fun}
	 * labeled alternative in {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void exitFun(PCFParser.FunContext ctx);
}