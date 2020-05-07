package Visitor;

import Parser.AstNodes.*;

public interface Visitor {
    void visit(AstProgramNode v);

    void visit(AstStatementNode v);

    void visit(AstExpressionNode v);

    void visit(AstBlockNode v);

    void visit(AstForNode v);

    void visit(AstReturnNode v);

    void visit(AstWhileNode v);

    void visit(AstFormalParamNode v);

    void visit(AstFuncDeclNode v);

    void visit(AstVarDeclNode v);

    void visit(AstIfNode v);

    void visit(AstPrintNode v);

    void visit(AstAssignNode v);

    void visit(AstUnaryNode v);

    void visit(AstIdentifierNode v);

    void visit(AstSumBoolExprNode v);

    void visit(AstFunctionCall v);

    void visit(AstActualParam v);

    void visit(AstFloatLiteralNode v);

    void visit(AstIntegerLiteralNode v);

    void visit(AstBoolLiteralNode v);
}
