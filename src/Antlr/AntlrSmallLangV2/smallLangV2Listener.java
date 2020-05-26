// Generated from smallLangV2.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link smallLangV2Parser}.
 */
public interface smallLangV2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(smallLangV2Parser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(smallLangV2Parser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(smallLangV2Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(smallLangV2Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#variabledecl}.
	 * @param ctx the parse tree
	 */
	void enterVariabledecl(smallLangV2Parser.VariabledeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#variabledecl}.
	 * @param ctx the parse tree
	 */
	void exitVariabledecl(smallLangV2Parser.VariabledeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(smallLangV2Parser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(smallLangV2Parser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#printStat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(smallLangV2Parser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#printStat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(smallLangV2Parser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(smallLangV2Parser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(smallLangV2Parser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#forStat}.
	 * @param ctx the parse tree
	 */
	void enterForStat(smallLangV2Parser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#forStat}.
	 * @param ctx the parse tree
	 */
	void exitForStat(smallLangV2Parser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#whileStat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(smallLangV2Parser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#whileStat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(smallLangV2Parser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#returnStat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(smallLangV2Parser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#returnStat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(smallLangV2Parser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void enterFuncDecl(smallLangV2Parser.FuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void exitFuncDecl(smallLangV2Parser.FuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#formalParams}.
	 * @param ctx the parse tree
	 */
	void enterFormalParams(smallLangV2Parser.FormalParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#formalParams}.
	 * @param ctx the parse tree
	 */
	void exitFormalParams(smallLangV2Parser.FormalParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#formalParam}.
	 * @param ctx the parse tree
	 */
	void enterFormalParam(smallLangV2Parser.FormalParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#formalParam}.
	 * @param ctx the parse tree
	 */
	void exitFormalParam(smallLangV2Parser.FormalParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(smallLangV2Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(smallLangV2Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(smallLangV2Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(smallLangV2Parser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpr(smallLangV2Parser.SimpleExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpr(smallLangV2Parser.SimpleExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(smallLangV2Parser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(smallLangV2Parser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(smallLangV2Parser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(smallLangV2Parser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(smallLangV2Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(smallLangV2Parser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(smallLangV2Parser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(smallLangV2Parser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#actualParams}.
	 * @param ctx the parse tree
	 */
	void enterActualParams(smallLangV2Parser.ActualParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#actualParams}.
	 * @param ctx the parse tree
	 */
	void exitActualParams(smallLangV2Parser.ActualParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#actualParam}.
	 * @param ctx the parse tree
	 */
	void enterActualParam(smallLangV2Parser.ActualParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#actualParam}.
	 * @param ctx the parse tree
	 */
	void exitActualParam(smallLangV2Parser.ActualParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(smallLangV2Parser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(smallLangV2Parser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#subExpr}.
	 * @param ctx the parse tree
	 */
	void enterSubExpr(smallLangV2Parser.SubExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#subExpr}.
	 * @param ctx the parse tree
	 */
	void exitSubExpr(smallLangV2Parser.SubExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(smallLangV2Parser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(smallLangV2Parser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(smallLangV2Parser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(smallLangV2Parser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#arrSize}.
	 * @param ctx the parse tree
	 */
	void enterArrSize(smallLangV2Parser.ArrSizeContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#arrSize}.
	 * @param ctx the parse tree
	 */
	void exitArrSize(smallLangV2Parser.ArrSizeContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(smallLangV2Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(smallLangV2Parser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#auto}.
	 * @param ctx the parse tree
	 */
	void enterAuto(smallLangV2Parser.AutoContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#auto}.
	 * @param ctx the parse tree
	 */
	void exitAuto(smallLangV2Parser.AutoContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#relOp}.
	 * @param ctx the parse tree
	 */
	void enterRelOp(smallLangV2Parser.RelOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#relOp}.
	 * @param ctx the parse tree
	 */
	void exitRelOp(smallLangV2Parser.RelOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#addOp}.
	 * @param ctx the parse tree
	 */
	void enterAddOp(smallLangV2Parser.AddOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#addOp}.
	 * @param ctx the parse tree
	 */
	void exitAddOp(smallLangV2Parser.AddOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#mulOp}.
	 * @param ctx the parse tree
	 */
	void enterMulOp(smallLangV2Parser.MulOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#mulOp}.
	 * @param ctx the parse tree
	 */
	void exitMulOp(smallLangV2Parser.MulOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link smallLangV2Parser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(smallLangV2Parser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link smallLangV2Parser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(smallLangV2Parser.BoolContext ctx);
}