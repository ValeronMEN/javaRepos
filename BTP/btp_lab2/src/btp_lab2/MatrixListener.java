package btp_lab2;
// Generated from Matrix.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MatrixParser}.
 */
public interface MatrixListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code MainRule}
	 * labeled alternative in {@link MatrixParser#root}.
	 * @param ctx the parse tree
	 */
	void enterMainRule(MatrixParser.MainRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MainRule}
	 * labeled alternative in {@link MatrixParser#root}.
	 * @param ctx the parse tree
	 */
	void exitMainRule(MatrixParser.MainRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GoToInitialize}
	 * labeled alternative in {@link MatrixParser#input}.
	 * @param ctx the parse tree
	 */
	void enterGoToInitialize(MatrixParser.GoToInitializeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GoToInitialize}
	 * labeled alternative in {@link MatrixParser#input}.
	 * @param ctx the parse tree
	 */
	void exitGoToInitialize(MatrixParser.GoToInitializeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GoToRank}
	 * labeled alternative in {@link MatrixParser#input}.
	 * @param ctx the parse tree
	 */
	void enterGoToRank(MatrixParser.GoToRankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GoToRank}
	 * labeled alternative in {@link MatrixParser#input}.
	 * @param ctx the parse tree
	 */
	void exitGoToRank(MatrixParser.GoToRankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GoToSum}
	 * labeled alternative in {@link MatrixParser#input}.
	 * @param ctx the parse tree
	 */
	void enterGoToSum(MatrixParser.GoToSumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GoToSum}
	 * labeled alternative in {@link MatrixParser#input}.
	 * @param ctx the parse tree
	 */
	void exitGoToSum(MatrixParser.GoToSumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Initialize}
	 * labeled alternative in {@link MatrixParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInitialize(MatrixParser.InitializeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Initialize}
	 * labeled alternative in {@link MatrixParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInitialize(MatrixParser.InitializeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RankRule}
	 * labeled alternative in {@link MatrixParser#rank}.
	 * @param ctx the parse tree
	 */
	void enterRankRule(MatrixParser.RankRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RankRule}
	 * labeled alternative in {@link MatrixParser#rank}.
	 * @param ctx the parse tree
	 */
	void exitRankRule(MatrixParser.RankRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultSumSumOp}
	 * labeled alternative in {@link MatrixParser#sum}.
	 * @param ctx the parse tree
	 */
	void enterMultSumSumOp(MatrixParser.MultSumSumOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultSumSumOp}
	 * labeled alternative in {@link MatrixParser#sum}.
	 * @param ctx the parse tree
	 */
	void exitMultSumSumOp(MatrixParser.MultSumSumOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultOp}
	 * labeled alternative in {@link MatrixParser#sum}.
	 * @param ctx the parse tree
	 */
	void enterMultOp(MatrixParser.MultOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultOp}
	 * labeled alternative in {@link MatrixParser#sum}.
	 * @param ctx the parse tree
	 */
	void exitMultOp(MatrixParser.MultOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InverMultMultOp}
	 * labeled alternative in {@link MatrixParser#mult}.
	 * @param ctx the parse tree
	 */
	void enterInverMultMultOp(MatrixParser.InverMultMultOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InverMultMultOp}
	 * labeled alternative in {@link MatrixParser#mult}.
	 * @param ctx the parse tree
	 */
	void exitInverMultMultOp(MatrixParser.InverMultMultOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InverOp}
	 * labeled alternative in {@link MatrixParser#mult}.
	 * @param ctx the parse tree
	 */
	void enterInverOp(MatrixParser.InverOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InverOp}
	 * labeled alternative in {@link MatrixParser#mult}.
	 * @param ctx the parse tree
	 */
	void exitInverOp(MatrixParser.InverOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Inversion}
	 * labeled alternative in {@link MatrixParser#inver}.
	 * @param ctx the parse tree
	 */
	void enterInversion(MatrixParser.InversionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Inversion}
	 * labeled alternative in {@link MatrixParser#inver}.
	 * @param ctx the parse tree
	 */
	void exitInversion(MatrixParser.InversionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GoToMatrix}
	 * labeled alternative in {@link MatrixParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterGoToMatrix(MatrixParser.GoToMatrixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GoToMatrix}
	 * labeled alternative in {@link MatrixParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitGoToMatrix(MatrixParser.GoToMatrixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link MatrixParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterVariable(MatrixParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link MatrixParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitVariable(MatrixParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GoToVect}
	 * labeled alternative in {@link MatrixParser#matr}.
	 * @param ctx the parse tree
	 */
	void enterGoToVect(MatrixParser.GoToVectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GoToVect}
	 * labeled alternative in {@link MatrixParser#matr}.
	 * @param ctx the parse tree
	 */
	void exitGoToVect(MatrixParser.GoToVectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GoToNumber}
	 * labeled alternative in {@link MatrixParser#vect}.
	 * @param ctx the parse tree
	 */
	void enterGoToNumber(MatrixParser.GoToNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GoToNumber}
	 * labeled alternative in {@link MatrixParser#vect}.
	 * @param ctx the parse tree
	 */
	void exitGoToNumber(MatrixParser.GoToNumberContext ctx);
}