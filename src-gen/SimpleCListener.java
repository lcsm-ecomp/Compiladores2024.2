// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleCParser}.
 */
public interface SimpleCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(SimpleCParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(SimpleCParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#com}.
	 * @param ctx the parse tree
	 */
	void enterCom(SimpleCParser.ComContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#com}.
	 * @param ctx the parse tree
	 */
	void exitCom(SimpleCParser.ComContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SimpleCParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SimpleCParser.ExprContext ctx);
}