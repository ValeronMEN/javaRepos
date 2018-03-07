// Generated from Matrix.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MatrixParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MatrixVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code MainRule}
	 * labeled alternative in {@link MatrixParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainRule(MatrixParser.MainRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GoToInitialize}
	 * labeled alternative in {@link MatrixParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoToInitialize(MatrixParser.GoToInitializeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GoToRank}
	 * labeled alternative in {@link MatrixParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoToRank(MatrixParser.GoToRankContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Initialize}
	 * labeled alternative in {@link MatrixParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialize(MatrixParser.InitializeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RankRule}
	 * labeled alternative in {@link MatrixParser#rank}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRankRule(MatrixParser.RankRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultSumSumOp}
	 * labeled alternative in {@link MatrixParser#sum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultSumSumOp(MatrixParser.MultSumSumOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultOp}
	 * labeled alternative in {@link MatrixParser#sum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultOp(MatrixParser.MultOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InverMultMultOp}
	 * labeled alternative in {@link MatrixParser#mult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInverMultMultOp(MatrixParser.InverMultMultOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InverOp}
	 * labeled alternative in {@link MatrixParser#mult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInverOp(MatrixParser.InverOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Inversion}
	 * labeled alternative in {@link MatrixParser#inver}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInversion(MatrixParser.InversionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GoToMatrix}
	 * labeled alternative in {@link MatrixParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoToMatrix(MatrixParser.GoToMatrixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link MatrixParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(MatrixParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GoToVect}
	 * labeled alternative in {@link MatrixParser#matr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoToVect(MatrixParser.GoToVectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GoToNumber}
	 * labeled alternative in {@link MatrixParser#vect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoToNumber(MatrixParser.GoToNumberContext ctx);
}