package Parser;

import Parser.AstNodes.*;
import Lexer.*;
import Lexer.Token.tokenIdentifier;

import java.util.ArrayList;

public class Parser {
    private Token currentToken;
    private Token nextToken;
    private ArrayList<Token> tokens;

    public AstProgramNode parse() {
        tokens = Lexer.getNextToken();
        ArrayList<AstStatementNode> statements = new ArrayList<>();
        changeCurrentToken();

        while (currentToken.tokenIdentifier != tokenIdentifier.TOK_EOF) {
            statements.add(parseStatement());
            changeCurrentToken();
        }
        AstProgramNode program = new AstProgramNode(statements);

        return program;
    }

    private void changeCurrentToken() {
        try {
            currentToken = tokens.remove(0);
            try {
                nextToken = tokens.get(0);
            } catch (IndexOutOfBoundsException e) {
                nextToken.tokenIdentifier = tokenIdentifier.TOK_EOF;
            }
        } catch (Exception e) {
            System.out.println("Empty Program");
            System.exit(1);
        }
    }

    private AstStatementNode parseStatement() {
        if (currentToken.tokenIdentifier == tokenIdentifier.TOK_LET) {
            return parseVariableDecl();
        } else if (currentToken.tokenIdentifier == tokenIdentifier.TOK_IDENTIFIER) {
            return parseAssignment(false);
        } else if (currentToken.tokenIdentifier == tokenIdentifier.TOK_PRINT) {
            return parsePrint();
        } else if (currentToken.tokenIdentifier == tokenIdentifier.TOK_IF) {
            return parseIf();
        } else if (currentToken.tokenIdentifier == tokenIdentifier.TOK_FOR) {
            return parseFor();
        } else if (currentToken.tokenIdentifier == tokenIdentifier.TOK_WHILE) {
            return parseWhile();
        } else if (currentToken.tokenIdentifier == tokenIdentifier.TOK_RETURN) {
            return parseReturn();
        } else if (currentToken.tokenIdentifier == tokenIdentifier.TOK_FF) {
            return parseFuncDecl();
        } else if (currentToken.tokenIdentifier == tokenIdentifier.TOK_LEFTBRACE) {
            return parseBlock();
        } else {
            System.out.println("Unexpected statement beginning with: '" + currentToken.lexeme + "' at line: "
                    + currentToken.lineNumber);
            System.exit(1);
        }
        return null;
    }

    private AstVarDeclNode parseVariableDecl() {

        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_IDENTIFIER) {
            System.out.println(
                    "Expected identifier, but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
            System.exit(1);
        }

        AstIdentifierNode identifier = new AstIdentifierNode(currentToken.lexeme, currentToken.lineNumber);

        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_COLON) {
            System.out.println(
                    "Expected ':', but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
            System.exit(1);
        }

        changeCurrentToken();
        AstNode.varType type = parseVarType();

        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_EQUALS) {
            System.out.println(
                    "Expected '=', but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
        }

        AstExpressionNode expr = parseExpr();

        checkForSemicolon();

        return new AstVarDeclNode(identifier, currentToken.lineNumber, type, expr);
    }

    private AstAssignNode parseAssignment(boolean forLoop) {
        AstIdentifierNode identifier = new AstIdentifierNode(currentToken.lexeme, currentToken.lineNumber);

        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_EQUALS) {
            System.out.println(
                    "Expected '=', but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
            System.exit(1);
        }

        AstExpressionNode expr = parseExpr();

        if (!forLoop) {
            checkForSemicolon();
        }

        return new AstAssignNode(identifier, expr, currentToken.lineNumber);
    }

    private AstPrintNode parsePrint() {
        AstExpressionNode expr = parseExpr();
        checkForSemicolon();
        return new AstPrintNode(expr, currentToken.lineNumber);
    }

    private AstIfNode parseIf() {
        int lineNo = currentToken.lineNumber;

        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_LEFTBRACKET) {
            System.out.println(
                    "Expected '(', but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
            System.exit(1);
        }

        AstExpressionNode conditionExpr = parseExpr();

        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_RIGHTBRACKET) {
            System.out.println(
                    "Expected ')', but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
            System.exit(1);
        }

        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_LEFTBRACE) {
            System.out.println(
                    "Expected '{', but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
            System.exit(1);
        }
        AstBlockNode ifBlock = parseBlock();

        if (nextToken.tokenIdentifier != tokenIdentifier.TOK_ELSE) {
            return new AstIfNode(conditionExpr, ifBlock, lineNo);
        }

        changeCurrentToken();
        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_LEFTBRACE) {
            System.out.println(
                    "Expected '{', but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
            System.exit(1);
        }
        AstBlockNode elseBlock = parseBlock();

        return new AstIfNode(conditionExpr, ifBlock, elseBlock, lineNo);
    }

    private AstForNode parseFor() {
        int lineNo = currentToken.lineNumber;
        AstVarDeclNode varDecl = null;
        AstAssignNode varAssignment = null;
        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_LEFTBRACKET) {
            System.out.println("Expected '(' but got: " + currentToken.lexeme + " at line: " + currentToken.lineNumber);
            System.exit(1);
        }

        if (nextToken.tokenIdentifier == tokenIdentifier.TOK_LET) {
            changeCurrentToken();
            varDecl = parseVariableDecl();
        } else {
            checkForSemicolon();
        }

        AstExpressionNode expr = parseExpr();

        checkForSemicolon();

        if (nextToken.tokenIdentifier == tokenIdentifier.TOK_IDENTIFIER) {
            changeCurrentToken();
            varAssignment = parseAssignment(true);
        }

        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_RIGHTBRACKET) {
            System.out.println("Expected ')' but got: " + currentToken.lexeme + " at line: " + currentToken.lineNumber);
            System.exit(1);
        }

        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_LEFTBRACE) {
            System.out.println(
                    "Expected '{', but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
            System.exit(1);
        }
        AstBlockNode forBlock = parseBlock();

        return new AstForNode(varDecl, expr, varAssignment, forBlock, lineNo);
    }

    private AstWhileNode parseWhile() {
        int lineNo = currentToken.lineNumber;
        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_LEFTBRACKET) {
            System.out.println("Expected '(' but got: " + currentToken.lexeme + " at line: " + currentToken.lineNumber);
            System.exit(1);
        }

        AstExpressionNode expr = parseExpr();

        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_RIGHTBRACKET) {
            System.out.println("Expected ')' but got: " + currentToken.lexeme + " at line: " + currentToken.lineNumber);
            System.exit(1);
        }

        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_LEFTBRACE) {
            System.out.println(
                    "Expected '{', but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
            System.exit(1);
        }

        AstBlockNode block = parseBlock();

        return new AstWhileNode(expr, block, lineNo);
    }

    private AstReturnNode parseReturn() {
        int lineNo = currentToken.lineNumber;
        AstExpressionNode expr = parseExpr();
        checkForSemicolon();
        return new AstReturnNode(expr, lineNo);
    }

    private AstFuncDeclNode parseFuncDecl() {
        int lineNo = currentToken.lineNumber;

        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_IDENTIFIER) {
            System.out.println("Expected an Identfier, but got: '" + currentToken.lexeme + "' at line: "
                    + currentToken.lineNumber);
            System.exit(1);
        }

        AstIdentifierNode identifier = new AstIdentifierNode(currentToken.lexeme, currentToken.lineNumber);

        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_LEFTBRACKET) {
            System.out.println(
                    "Expected '(', but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
            System.exit(1);
        }

        ArrayList<AstFormalParamNode> params = new ArrayList<>();
        if (nextToken.tokenIdentifier != tokenIdentifier.TOK_RIGHTBRACKET) {
            params.add(parseFormalParam());

            changeCurrentToken();
            while (currentToken.tokenIdentifier == tokenIdentifier.TOK_COMMA) {
                params.add(parseFormalParam());
                changeCurrentToken();
            }

            if (currentToken.tokenIdentifier != tokenIdentifier.TOK_RIGHTBRACKET) {
                System.out.println(
                        "Expected a ')', but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
                System.exit(1);
            }
        } else {
            changeCurrentToken();
        }
        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_COLON) {
            System.out.println(
                    "Expected a ':', but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
            System.exit(1);
        }
        changeCurrentToken();
        AstNode.varType type = parseVarType();

        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_LEFTBRACE) {
            System.out.println(
                    "Expected '{', but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
            System.exit(1);
        }
        AstBlockNode block = parseBlock();

        return new AstFuncDeclNode(identifier, params, block, type, lineNo);
    }

    private AstFunctionCall parseFuncCall() {
        AstIdentifierNode identifier = new AstIdentifierNode(currentToken.lexeme, currentToken.lineNumber);
        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_LEFTBRACKET) {
            System.out.println("Expected '(' but got: " + currentToken.lexeme + " at line: " + currentToken.lineNumber);
            System.exit(1);
        }

        ArrayList<AstActualParam> params = new ArrayList<>();
        if (nextToken.tokenIdentifier != tokenIdentifier.TOK_RIGHTBRACKET) {
            params.add(parseActualParam());

            changeCurrentToken();
            while (currentToken.tokenIdentifier == tokenIdentifier.TOK_COMMA) {
                params.add(parseActualParam());
                changeCurrentToken();
            }

            if (currentToken.tokenIdentifier != tokenIdentifier.TOK_RIGHTBRACKET) {
                System.out.println(
                        "Expected a ')', but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
                System.exit(1);
            }
        } else {
            changeCurrentToken();
        }
        return new AstFunctionCall(identifier, params, currentToken.lineNumber);
    }

    private AstActualParam parseActualParam() {
        return new AstActualParam(parseExpr(), currentToken.lineNumber);
    }

    private AstFormalParamNode parseFormalParam() {
        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_IDENTIFIER) {
            System.out.println("Expected an Identfier, but got: '" + currentToken.lexeme + "' at line: "
                    + currentToken.lineNumber);
            System.exit(1);
        }
        AstIdentifierNode identifier = new AstIdentifierNode(currentToken.lexeme, currentToken.lineNumber);

        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_COLON) {
            System.out.println(
                    "Expected a ':', but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
            System.exit(1);
        }

        changeCurrentToken();
        AstNode.varType type = parseVarType();
        if (type == AstNode.varType.AUTO) {
            System.out.println("Formal parameter can not take type of AUTO at line: " + currentToken.lineNumber);
            System.exit(1);
        }

        return new AstFormalParamNode(identifier, type, currentToken.lineNumber);
    }

    private AstBlockNode parseBlock() {
        int lineNo = currentToken.lineNumber;

        ArrayList<AstStatementNode> statements = new ArrayList<>();
        changeCurrentToken();
        while (currentToken.tokenIdentifier != tokenIdentifier.TOK_RIGHTBRACE
                && currentToken.tokenIdentifier != tokenIdentifier.TOK_EOF) {
            statements.add(parseStatement());
            changeCurrentToken();
        }

        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_RIGHTBRACE) {
            System.out.println("Block which started at line: " + lineNo + " was never closed with a '}'");
            System.exit(1);
        }

        return new AstBlockNode(statements, lineNo);
    }

    private void checkForSemicolon() {
        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_SEMICOLON) {
            System.out.println(
                    "Expected ';', but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
            System.exit(1);
        }
    }

    private AstNode.varType parseVarType() {
        switch (currentToken.tokenIdentifier) {
            case TOK_FLOATTYPE:
                return AstNode.varType.FLOAT;
            case TOK_INTTYPE:
                return AstNode.varType.INT;
            case TOK_BOOLTYPE:
                return AstNode.varType.BOOL;
            case TOK_AUTOTYPE:
                return AstNode.varType.AUTO;
            default:
                System.out.println("Expected type for variable, but got: '" + currentToken.lexeme + "' at line: "
                        + currentToken.lineNumber);
                System.exit(1);
                break;
        }
        return null;
    }

    private AstExpressionNode parseExpr() {
        AstExpressionNode simpleExpression = parseSimpleExpr();
        if (nextToken.tokenIdentifier == tokenIdentifier.TOK_RELATIONALOP) {
            changeCurrentToken();
            String op = currentToken.lexeme;
            AstExpressionNode expr = parseExpr();
            return new AstSumBoolExprNode(op, simpleExpression, expr, currentToken.lineNumber);
        }

        return simpleExpression;
    }

    private AstExpressionNode parseSimpleExpr() {
        AstExpressionNode term = parseTerm();
        if (nextToken.tokenIdentifier == tokenIdentifier.TOK_ADDITIONOP) {
            changeCurrentToken();
            String op = currentToken.lexeme;
            AstExpressionNode simpleExpr = parseSimpleExpr();
            return new AstSumBoolExprNode(op, term, simpleExpr, currentToken.lineNumber);
        }

        return term;
    }

    private AstExpressionNode parseTerm() {
        AstExpressionNode factor = parseFactor();
        if (nextToken.tokenIdentifier == tokenIdentifier.TOK_MULTIPLICATIONOP) {
            changeCurrentToken();
            String op = currentToken.lexeme;
            AstExpressionNode term = parseTerm();
            return new AstSumBoolExprNode(op, factor, term, currentToken.lineNumber);
        }

        return factor;
    }

    private AstExpressionNode parseFactor() {
        changeCurrentToken();
        switch (currentToken.tokenIdentifier) {
            case TOK_FLOAT:
                return new AstFloatLiteralNode(Float.parseFloat(currentToken.lexeme), currentToken.lineNumber);
            case TOK_INTEGER:
                return new AstIntegerLiteralNode(Integer.parseInt(currentToken.lexeme), currentToken.lineNumber);
            case TOK_BOOLEAN:
                return new AstBoolLiteralNode(Boolean.parseBoolean(currentToken.lexeme), currentToken.lineNumber);
            case TOK_IDENTIFIER:
                if (nextToken.tokenIdentifier == tokenIdentifier.TOK_LEFTBRACKET) {
                    return parseFuncCall();
                }
                return new AstIdentifierNode(currentToken.lexeme, currentToken.lineNumber);
            case TOK_LEFTBRACKET:
                AstExpressionNode expr = parseExpr();
                changeCurrentToken();
                if (currentToken.tokenIdentifier != tokenIdentifier.TOK_RIGHTBRACKET) {
                    System.out.println(
                            "Expected ')' but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
                    System.exit(1);
                }
                return expr;
            case TOK_ADDITIONOP:
            case TOK_NOT:
                String op = currentToken.lexeme;
                AstExpressionNode exprToPass = parseExpr();
                return new AstUnaryNode(op, exprToPass, currentToken.lineNumber);
            default:
                System.out.println("Unexpected Expression beginning with: '" + currentToken.lexeme + "' at line: "
                        + currentToken.lineNumber);
                System.exit(1);
        }
        return null;
    }
}
