package Visitor;

import Parser.AstNodes.*;

public class XmlVisitor implements Visitor {

    int indentLevel = 0;

    /**
     * [incrementIndent adds a new indent level and prints them]
     */
    void incrementIndent() {
        indentLevel++;
        printIndents();
    }

    /**
     * [decrementIndent decreases an indent level and prints them]
     */
    void decrementIndent() {
        indentLevel--;
        printIndents();
    }

    /**
     * [printIndents prints the indents depending on the indent level]
     */
    void printIndents() {
        for (int i = 0; i < indentLevel; i++) {
            System.out.print("\t");
        }
    }

    @Override
    public void visit(AstProgramNode v) {
        System.out.println("<Program>");
        indentLevel++;
        for (AstStatementNode statement : v.statements) {
            printIndents();
            statement.accept(this);
        }
        System.out.println("</Program>");
        indentLevel--;
    }

    @Override
    public void visit(AstStatementNode v) {
    }

    @Override
    public void visit(AstExpressionNode v) {

    }

    @Override
    public void visit(AstBlockNode v) {
        System.out.println("<Block>");
        indentLevel++;
        for (AstStatementNode statement : v.statements) {
            printIndents();
            statement.accept(this);
        }
        decrementIndent();
        System.out.println("</Block>");
    }

    @Override
    public void visit(AstForNode v) {
        System.out.println("<For>");
        incrementIndent();

        if (v.varDecl != null) {
            v.varDecl.accept(this);
        }

        printIndents();
        v.expr.accept(this);

        printIndents();
        if (v.assignNode != null) {
            v.assignNode.accept(this);
        }

        printIndents();
        v.block.accept(this);

        decrementIndent();
        System.out.println("</For>");
    }

    @Override
    public void visit(AstReturnNode v) {
        System.out.println("<Return>");
        incrementIndent();

        v.expr.accept(this);

        decrementIndent();
        System.out.println("</Return>");
    }

    @Override
    public void visit(AstWhileNode v) {
        System.out.println("<While>");
        incrementIndent();

        System.out.println("<Condition>");

        incrementIndent();
        v.expr.accept(this);
        decrementIndent();

        System.out.println("</Condition>");

        printIndents();
        v.block.accept(this);

        decrementIndent();
        System.out.println("</While>");
    }

    @Override
    public void visit(AstFormalParamNode v) {
        System.out.println("<FormalParam Type=\"" + v.type + ">");
        incrementIndent();

        v.identifier.accept(this);

        decrementIndent();
        System.out.println("</FormalParam>");
    }

    @Override
    public void visit(AstFuncDeclNode v) {
        System.out.println("<FuncDecl ReturnType=\"" + v.returnType + "\">");
        incrementIndent();

        v.identifier.accept(this);

        printIndents();
        System.out.println("<FormalParams>");
        indentLevel++;
        for (AstFormalParamNode param : v.params) {
            printIndents();
            param.accept(this);
        }
        decrementIndent();
        System.out.println("</FormalParams>");

        printIndents();
        v.block.accept(this);

        decrementIndent();
        System.out.println("</FuncDecl>");
    }

    @Override
    public void visit(AstFloatLiteralNode v) {
        System.out.println("<FloatLiteral>" + v.val + "</FloatLiteral>");
    }

    @Override
    public void visit(AstIntegerLiteralNode v) {
        System.out.println("<IntegerLiteral>" + v.val + "</IntegerLiteral>");
    }

    @Override
    public void visit(AstBoolLiteralNode v) {
        System.out.println("<BoolLiteral>" + v.val + "</BoolLiteral>");
    }

    @Override
    public void visit(AstVarDeclNode v) {
        System.out.println("<VarDecl>");
        incrementIndent();
        System.out.println("<Var Type=\"" + v.type + "\">");
        incrementIndent();
        v.identifier.accept(this);
        decrementIndent();
        System.out.println("</Var>");
        printIndents();
        v.expr.accept(this);
        decrementIndent();
        System.out.println("</VarDecl>");
    }

    @Override
    public void visit(AstAssignNode v) {
        System.out.println("<VarAssign>");
        incrementIndent();
        v.identifier.accept(this);
        printIndents();
        v.expr.accept(this);
        decrementIndent();
        System.out.println("</VarAssign>");
    }

    @Override
    public void visit(AstIfNode v) {
        System.out.println("<IfStatement>");
        incrementIndent();
        System.out.println("<Condition>");
        incrementIndent();
        v.expr.accept(this);
        decrementIndent();
        System.out.println("</Condition>");

        printIndents();
        System.out.println("<IfBlock>");
        incrementIndent();
        v.ifBlock.accept(this);
        decrementIndent();
        System.out.println("</IfBlock>");

        if (v.elseBlock != null) {
            printIndents();
            System.out.println("<ElseBlock>");
            incrementIndent();
            v.elseBlock.accept(this);
            decrementIndent();
            System.out.println("</ElseBlock>");
        }

        decrementIndent();
        System.out.println("</IfStatement>");
    }

    @Override
    public void visit(AstPrintNode v) {
        System.out.println("<Print>");
        incrementIndent();
        v.expr.accept(this);
        decrementIndent();
        System.out.println("</Print>");
    }

    @Override
    public void visit(AstUnaryNode v) {
        System.out.println("<UnaryExpr Op=\"" + v.op + "\">");
        incrementIndent();

        v.expr.accept(this);

        decrementIndent();
        System.out.println("</UnaryExpr>");
    }

    @Override
    public void visit(AstIdentifierNode v) {
        System.out.println("<Id>" + v.identifier + "</Id>");
    }

    @Override
    public void visit(AstSumBoolExprNode v) {
        System.out.println("<BinExpr Op=\"" + v.op + "\">");
        incrementIndent();
        v.leftSide.accept(this);
        printIndents();
        v.rightSide.accept(this);
        decrementIndent();
        System.out.println("</BinExpr>");
    }

    @Override
    public void visit(AstFunctionCall v) {
        System.out.println("<FunctionCall>");
        incrementIndent();

        v.identifier.accept(this);

        printIndents();
        System.out.println("<ActualParams>");
        indentLevel++;
        for (AstActualParam param : v.params) {
            printIndents();
            param.accept(this);
        }
        decrementIndent();
        System.out.println("</ActualParams>");

        decrementIndent();
        System.out.println("</FunctionCall>");
    }

    @Override
    public void visit(AstActualParam v) {
        System.out.println("<ActualParam>");
        incrementIndent();

        v.param.accept(this);

        decrementIndent();
        System.out.println("</ActualParam>");
    }
}
