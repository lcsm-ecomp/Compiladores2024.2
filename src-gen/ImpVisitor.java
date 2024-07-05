// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ImpParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ImpVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ImpParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ImpParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link ImpParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(ImpParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Atrib}
	 * labeled alternative in {@link ImpParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtrib(ImpParser.AtribContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Block}
	 * labeled alternative in {@link ImpParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ImpParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code If}
	 * labeled alternative in {@link ImpParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(ImpParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code While}
	 * labeled alternative in {@link ImpParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(ImpParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Dec}
	 * labeled alternative in {@link ImpParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec(ImpParser.DecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Group}
	 * labeled alternative in {@link ImpParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(ImpParser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Op}
	 * labeled alternative in {@link ImpParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(ImpParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link ImpParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(ImpParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Const}
	 * labeled alternative in {@link ImpParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst(ImpParser.ConstContext ctx);
}