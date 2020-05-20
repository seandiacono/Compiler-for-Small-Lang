// Generated from SmallLangV1.g4 by ANTLR 4.8
package Antlr.AntlrSmallLangV1;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SmallLangV1Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface SmallLangV1Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#prog}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(SmallLangV1Parser.ProgContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#statement}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SmallLangV1Parser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#variabledecl}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariabledecl(SmallLangV1Parser.VariabledeclContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#assignment}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SmallLangV1Parser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#printStat}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStat(SmallLangV1Parser.PrintStatContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#ifStat}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(SmallLangV1Parser.IfStatContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#forStat}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStat(SmallLangV1Parser.ForStatContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#whileStat}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(SmallLangV1Parser.WhileStatContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#returnStat}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(SmallLangV1Parser.ReturnStatContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#funcDecl}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDecl(SmallLangV1Parser.FuncDeclContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#formalParams}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParams(SmallLangV1Parser.FormalParamsContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#formalParam}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParam(SmallLangV1Parser.FormalParamContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#block}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SmallLangV1Parser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#expr}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SmallLangV1Parser.ExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#simpleExpr}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpr(SmallLangV1Parser.SimpleExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#term}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(SmallLangV1Parser.TermContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#factor}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(SmallLangV1Parser.FactorContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#literal}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(SmallLangV1Parser.LiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#funcCall}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(SmallLangV1Parser.FuncCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#actualParams}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParams(SmallLangV1Parser.ActualParamsContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#actualParam}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParam(SmallLangV1Parser.ActualParamContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#subExpr}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpr(SmallLangV1Parser.SubExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#unary}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(SmallLangV1Parser.UnaryContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#unaryOp}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(SmallLangV1Parser.UnaryOpContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#type}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SmallLangV1Parser.TypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#auto}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuto(SmallLangV1Parser.AutoContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#relOp}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelOp(SmallLangV1Parser.RelOpContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#addOp}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOp(SmallLangV1Parser.AddOpContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#mulOp}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulOp(SmallLangV1Parser.MulOpContext ctx);

	/**
	 * Visit a parse tree produced by {@link SmallLangV1Parser#bool}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(SmallLangV1Parser.BoolContext ctx);
}