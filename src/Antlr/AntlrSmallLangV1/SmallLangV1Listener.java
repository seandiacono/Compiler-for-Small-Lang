package Antlr.AntlrSmallLangV1;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SmallLangV1Parser}.
 */
public interface SmallLangV1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(SmallLangV1Parser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(SmallLangV1Parser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SmallLangV1Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SmallLangV1Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#variabledecl}.
	 * @param ctx the parse tree
	 */
	void enterVariabledecl(SmallLangV1Parser.VariabledeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#variabledecl}.
	 * @param ctx the parse tree
	 */
	void exitVariabledecl(SmallLangV1Parser.VariabledeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SmallLangV1Parser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SmallLangV1Parser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#printStat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(SmallLangV1Parser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#printStat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(SmallLangV1Parser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(SmallLangV1Parser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(SmallLangV1Parser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#forStat}.
	 * @param ctx the parse tree
	 */
	void enterForStat(SmallLangV1Parser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#forStat}.
	 * @param ctx the parse tree
	 */
	void exitForStat(SmallLangV1Parser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#whileStat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(SmallLangV1Parser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#whileStat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(SmallLangV1Parser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#returnStat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(SmallLangV1Parser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#returnStat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(SmallLangV1Parser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void enterFuncDecl(SmallLangV1Parser.FuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void exitFuncDecl(SmallLangV1Parser.FuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#formalParams}.
	 * @param ctx the parse tree
	 */
	void enterFormalParams(SmallLangV1Parser.FormalParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#formalParams}.
	 * @param ctx the parse tree
	 */
	void exitFormalParams(SmallLangV1Parser.FormalParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#formalParam}.
	 * @param ctx the parse tree
	 */
	void enterFormalParam(SmallLangV1Parser.FormalParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#formalParam}.
	 * @param ctx the parse tree
	 */
	void exitFormalParam(SmallLangV1Parser.FormalParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SmallLangV1Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SmallLangV1Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SmallLangV1Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SmallLangV1Parser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpr(SmallLangV1Parser.SimpleExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpr(SmallLangV1Parser.SimpleExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(SmallLangV1Parser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(SmallLangV1Parser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(SmallLangV1Parser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(SmallLangV1Parser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SmallLangV1Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SmallLangV1Parser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(SmallLangV1Parser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(SmallLangV1Parser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#actualParams}.
	 * @param ctx the parse tree
	 */
	void enterActualParams(SmallLangV1Parser.ActualParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#actualParams}.
	 * @param ctx the parse tree
	 */
	void exitActualParams(SmallLangV1Parser.ActualParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#actualParam}.
	 * @param ctx the parse tree
	 */
	void enterActualParam(SmallLangV1Parser.ActualParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#actualParam}.
	 * @param ctx the parse tree
	 */
	void exitActualParam(SmallLangV1Parser.ActualParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#subExpr}.
	 * @param ctx the parse tree
	 */
	void enterSubExpr(SmallLangV1Parser.SubExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#subExpr}.
	 * @param ctx the parse tree
	 */
	void exitSubExpr(SmallLangV1Parser.SubExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(SmallLangV1Parser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(SmallLangV1Parser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(SmallLangV1Parser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(SmallLangV1Parser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SmallLangV1Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SmallLangV1Parser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#auto}.
	 * @param ctx the parse tree
	 */
	void enterAuto(SmallLangV1Parser.AutoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#auto}.
	 * @param ctx the parse tree
	 */
	void exitAuto(SmallLangV1Parser.AutoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#relOp}.
	 * @param ctx the parse tree
	 */
	void enterRelOp(SmallLangV1Parser.RelOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#relOp}.
	 * @param ctx the parse tree
	 */
	void exitRelOp(SmallLangV1Parser.RelOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#addOp}.
	 * @param ctx the parse tree
	 */
	void enterAddOp(SmallLangV1Parser.AddOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#addOp}.
	 * @param ctx the parse tree
	 */
	void exitAddOp(SmallLangV1Parser.AddOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#mulOp}.
	 * @param ctx the parse tree
	 */
	void enterMulOp(SmallLangV1Parser.MulOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#mulOp}.
	 * @param ctx the parse tree
	 */
	void exitMulOp(SmallLangV1Parser.MulOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmallLangV1Parser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(SmallLangV1Parser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmallLangV1Parser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(SmallLangV1Parser.BoolContext ctx);
}