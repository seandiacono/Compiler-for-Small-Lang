package Antlr.AntlrSmallLangV1;

import java.util.ArrayList;

import Parser.AstNodes.*;

import Parser.AstNodes.AstNode;

public class HybridParserVisitor extends SmallLangV1BaseVisitor<AstNode> {

    public AstProgramNode visitProg(SmallLangV1Parser.ProgContext ctx) {
        ArrayList<AstStatementNode> statements = new ArrayList<>();
        for (SmallLangV1Parser.StatementContext stat : ctx.statement()) {
            statements.add(visitStatement(stat));
        }
        return new AstProgramNode(statements);
    }

    public AstStatementNode visitStatement(SmallLangV1Parser.StatementContext ctx) {
        if (ctx.variabledecl() != null) {
            return visitVarDeclNode(ctx.variabledecl());
        } else if (ctx.assignment() != null) {
            return visitAssignment(ctx.assignment());
        } else if (ctx.printStat() != null) {
            return visitPrint(ctx.printStat());
        } else if (ctx.ifStat() != null) {
            return visitIfStat(ctx.ifStat());
        } else if (ctx.forStat() != null) {
            return visitForStat(ctx.forStat());
        } else if (ctx.whileStat() != null) {
            return visitWhileStat(ctx.whileStat());
        } else if (ctx.returnStat() != null) {
            return visitReturn(ctx.returnStat());
        } else if (ctx.funcDecl() != null) {
            return visitFuncDecl(ctx.funcDecl());
        }
        return null;
    }

    public AstFuncDeclNode visitFuncDecl(SmallLangV1Parser.FuncDeclContext ctx) {
        int lineNo = ctx.start.getLine();
        AstIdentifierNode identifier = new AstIdentifierNode(ctx.ID().getText(), lineNo);
        ArrayList<AstFormalParamNode> params = new ArrayList<>();

        if (ctx.formalParams() != null) {
            for (SmallLangV1Parser.FormalParamContext param : ctx.formalParams().formalParam()) {
                params.add(visitFormalParam(param));
            }
        }

        String type;
        if (ctx.type() != null) {
            type = ctx.type().getText();
        } else {
            type = ctx.auto().getText();
        }

        AstNode.varType returnType = visitType(type);

        AstBlockNode block = visitBlock(ctx.block());

        return new AstFuncDeclNode(identifier, params, block, returnType, lineNo);
    }

    public AstFormalParamNode visitFormalParam(SmallLangV1Parser.FormalParamContext ctx) {
        int lineNo = ctx.start.getLine();
        AstIdentifierNode identifier = new AstIdentifierNode(ctx.ID().getText(), lineNo);
        String type = ctx.type().getText();
        AstNode.varType vType = visitType(type);

        return new AstFormalParamNode(identifier, vType, lineNo);
    }

    public AstReturnNode visitReturn(SmallLangV1Parser.ReturnStatContext ctx) {
        int lineNo = ctx.start.getLine();
        AstExpressionNode expr = visitExpr(ctx.expr());

        return new AstReturnNode(expr, lineNo);
    }

    public AstWhileNode visitWhileStat(SmallLangV1Parser.WhileStatContext ctx) {
        int lineNo = ctx.start.getLine();
        AstExpressionNode expr = visitExpr(ctx.expr());
        AstBlockNode block = visitBlock(ctx.block());

        return new AstWhileNode(expr, block, lineNo);
    }

    public AstForNode visitForStat(SmallLangV1Parser.ForStatContext ctx) {
        int lineNo = ctx.start.getLine();
        AstVarDeclNode varDecl = null;
        AstAssignNode assignNode = null;

        if (ctx.variabledecl() != null) {
            varDecl = visitVarDeclNode(ctx.variabledecl());
        }

        AstExpressionNode expr = visitExpr(ctx.expr());

        if (ctx.assignment() != null) {
            assignNode = visitAssignment(ctx.assignment());
        }

        AstBlockNode block = visitBlock(ctx.block());

        return new AstForNode(varDecl, expr, assignNode, block, lineNo);
    }

    public AstBlockNode visitBlock(SmallLangV1Parser.BlockContext ctx) {
        ArrayList<AstStatementNode> statements = new ArrayList<>();
        int lineNo = ctx.start.getLine();
        for (SmallLangV1Parser.StatementContext stat : ctx.statement()) {
            statements.add(visitStatement(stat));
        }

        return new AstBlockNode(statements, lineNo);
    }

    public AstIfNode visitIfStat(SmallLangV1Parser.IfStatContext ctx) {
        int lineNo = ctx.start.getLine();
        AstExpressionNode expr = visitExpr(ctx.expr());
        AstBlockNode ifBlock = null;
        AstBlockNode elseBlock = null;

        if (ctx.block().size() > 1) {
            ifBlock = visitBlock(ctx.block().get(0));
            elseBlock = visitBlock(ctx.block().get(1));
        } else {
            ifBlock = visitBlock(ctx.block().get(0));
        }

        return new AstIfNode(expr, ifBlock, elseBlock, lineNo);
    }

    public AstPrintNode visitPrint(SmallLangV1Parser.PrintStatContext ctx) {
        int lineNo = ctx.start.getLine();
        AstExpressionNode expr = visitExpr(ctx.expr());

        return new AstPrintNode(expr, lineNo);
    }

    public AstAssignNode visitAssignment(SmallLangV1Parser.AssignmentContext ctx) {
        int lineNo = ctx.start.getLine();
        AstIdentifierNode id = new AstIdentifierNode(ctx.ID().getText(), lineNo);
        AstExpressionNode expr = visitExpr(ctx.expr());

        return new AstAssignNode(id, expr, lineNo);
    }

    public AstVarDeclNode visitVarDeclNode(SmallLangV1Parser.VariabledeclContext ctx) {
        String id = ctx.ID().getText();
        int lineNo = ctx.start.getLine();
        String type;
        if (ctx.type() != null) {
            type = ctx.type().getText();
        } else {
            type = ctx.auto().getText();
        }

        AstNode.varType vType = visitType(type);

        AstExpressionNode expr = visitExpr(ctx.expr());

        return new AstVarDeclNode(new AstIdentifierNode(id, lineNo), lineNo, vType, expr);
    }

    public AstNode.varType visitType(String type) {
        switch (type) {
            case "int":
                return AstNode.varType.INT;
            case "float":
                return AstNode.varType.FLOAT;
            case "bool":
                return AstNode.varType.BOOL;
            case "auto":
                return AstNode.varType.AUTO;
        }

        return null;
    }

    public AstExpressionNode visitExpr(SmallLangV1Parser.ExprContext ctx) {
        if (ctx.simpleExpr().size() > 1) {
            String op = ctx.relOp().getText();
            int lineNo = ctx.start.getLine();
            AstExpressionNode leftSide = visitSimpleExpr(ctx.simpleExpr().get(0));
            AstExpressionNode rightSide = visitSimpleExpr(ctx.simpleExpr().get(1));

            return new AstSumBoolExprNode(op, leftSide, rightSide, lineNo);
        }

        return visitSimpleExpr(ctx.simpleExpr().get(0));
    }

    public AstExpressionNode visitSimpleExpr(SmallLangV1Parser.SimpleExprContext ctx) {
        if (ctx.term().size() > 1) {
            String op = ctx.addOp().getText();
            int lineNo = ctx.start.getLine();
            AstExpressionNode leftSide = visitTerm(ctx.term().get(0));
            AstExpressionNode rightSide = visitTerm(ctx.term().get(1));

            return new AstSumBoolExprNode(op, leftSide, rightSide, lineNo);
        }

        return visitTerm(ctx.term().get(0));
    }

    public AstExpressionNode visitTerm(SmallLangV1Parser.TermContext ctx) {
        if (ctx.factor().size() > 1) {
            String op = ctx.mulOp().getText();
            int lineNo = ctx.start.getLine();
            AstExpressionNode leftSide = visitFactor(ctx.factor().get(0));
            AstExpressionNode rightSide = visitFactor(ctx.factor().get(1));

            return new AstSumBoolExprNode(op, leftSide, rightSide, lineNo);
        }

        return visitFactor(ctx.factor().get(0));
    }

    public AstExpressionNode visitFactor(SmallLangV1Parser.FactorContext ctx) {
        int lineNo = ctx.start.getLine();
        if (ctx.literal() != null) {
            return visitLiteral(ctx.literal());
        } else if (ctx.ID() != null) {
            return new AstIdentifierNode(ctx.ID().getText(), lineNo);
        } else if (ctx.funcCall() != null) {
            return visitFuncCall(ctx.funcCall());
        } else if (ctx.subExpr() != null) {
            return visitExpr(ctx.subExpr().expr());
        } else {
            return new AstUnaryNode(ctx.unary().unaryOp().getText(), visitExpr(ctx.unary().expr()), lineNo);
        }
    }

    public AstExpressionNode visitLiteral(SmallLangV1Parser.LiteralContext ctx) {
        int lineNo = ctx.start.getLine();
        if (ctx.bool() != null) {
            return new AstBoolLiteralNode(Boolean.parseBoolean(ctx.bool().getText()), lineNo);
        } else if (ctx.INT() != null) {
            return new AstIntegerLiteralNode(Integer.parseInt(ctx.INT().getText()), lineNo);
        } else {
            return new AstFloatLiteralNode(Float.parseFloat(ctx.FLOAT().getText()), lineNo);
        }
    }

    public AstExpressionNode visitFuncCall(SmallLangV1Parser.FuncCallContext ctx) {
        String id = ctx.ID().getText();
        int lineNo = ctx.start.getLine();

        ArrayList<AstActualParam> params = new ArrayList<>();
        if (ctx.actualParams() != null) {
            for (SmallLangV1Parser.ActualParamContext param : ctx.actualParams().actualParam()) {
                params.add(visitActualParam(param));
            }
        }

        return new AstFunctionCall(new AstIdentifierNode(id, lineNo), params, lineNo);
    }

    public AstActualParam visitActualParam(SmallLangV1Parser.ActualParamContext ctx) {
        return new AstActualParam(visitExpr(ctx.expr()), ctx.start.getLine());
    }
}