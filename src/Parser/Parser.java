package Parser;

import Parser.AstNodes.*;
import Lexer.*;
import Lexer.Token.tokenIdentifier;

import java.util.ArrayList;

public class Parser {
    private Token currentToken;
    private Token nextToken;
    private ArrayList<Token> tokens;

    /**
     * [parse gets the sequence of tokens from the lexer and parses them to return
     * an AstProgramNode]
     * 
     * @return AstProgramNode [returns the program node which includes a list of all
     *         the statements in the program]
     */
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

    /**
     * [changeCurrentToken changes the current token to be the next one in the
     * sequnce and the next token to be the following one]
     */
    private void changeCurrentToken() {
        try {
            currentToken = tokens.remove(0);
            try {
                nextToken = tokens.get(0);
            } catch (IndexOutOfBoundsException e) { // end of file reached
                nextToken.tokenIdentifier = tokenIdentifier.TOK_EOF;
            }
        } catch (Exception e) {
            System.out.println("Empty Program");
            System.exit(1);
        }
    }

    /**
     * [parseStatement calls the correct parse method based on the current token]
     */
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

    // 〈VariableDecl〉 ::= ‘let’ 〈Identifier 〉 ‘:’ ( 〈Type〉 | 〈Auto〉 ) ‘=’
    // 〈Expression〉
    private AstVarDeclNode parseVariableDecl() {

        changeCurrentToken();
        // check for identifier
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_IDENTIFIER) {
            System.out.println(
                    "Expected identifier, but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
            System.exit(1);
        }

        AstIdentifierNode identifier = parseIdentifier();
        boolean isArray = false;
        if (identifier.getClass() == AstArrayIdentifierNode.class) {
            isArray = true;
        }

        changeCurrentToken();
        // chcek for colon
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_COLON) {
            System.out.println(
                    "Expected ':', but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
            System.exit(1);
        }

        changeCurrentToken();
        AstNode.varType type = parseVarType();

        // check for equals
        if (nextToken.tokenIdentifier != tokenIdentifier.TOK_EQUALS && !isArray) {
            System.out.println("Expected '=', but got: '" + nextToken.lexeme + "' at line: " + currentToken.lineNumber);
            System.exit(1);
        } else if (nextToken.tokenIdentifier == tokenIdentifier.TOK_EQUALS) {
            changeCurrentToken();

            AstExpressionNode expr = parseExpr();

            checkForSemicolon();
            // return a new variable decleration node
            return new AstVarDeclNode(identifier, currentToken.lineNumber, type, expr);
        } else {
            checkForSemicolon();

            return new AstVarDeclNode(identifier, currentToken.lineNumber, type, null);
        }

        return null;
    }

    // 〈Assignment〉 ::= 〈Identifier 〉 ‘=’ 〈Expression〉
    private AstAssignNode parseAssignment(boolean forLoop) {
        AstIdentifierNode identifier = parseIdentifier();

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

    // 〈PrintStatement〉 ::= ‘print’ 〈Expression〉
    private AstPrintNode parsePrint() {
        AstExpressionNode expr = parseExpr();
        checkForSemicolon();
        return new AstPrintNode(expr, currentToken.lineNumber);
    }

    // 〈IfStatement〉 ::= ‘if’ ‘(’ 〈Expression〉 ‘)’ 〈Block〉 [ ‘else’ 〈Block〉 ]
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

    // 〈ForStatement〉 ::= ‘for’ ‘(’ [ 〈VariableDecl〉 ] ’;’ 〈Expression〉 ’;’ [
    // 〈Assignment〉 ] ‘)’ 〈Block〉
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

        return new AstForNode(varDecl, expr, varAssignment, forBlock, lineNo); // varDecl and varAssignment may be set
                                                                               // to null since they are optional
    }

    // 〈WhileStatement〉 ::= ‘while’ ‘(’ 〈Expression〉 ‘)’ 〈Block〉
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

    // 〈RtrnStatement〉 ::= ‘return’ 〈Expression〉
    private AstReturnNode parseReturn() {
        int lineNo = currentToken.lineNumber;
        AstExpressionNode expr = parseExpr();
        checkForSemicolon();
        return new AstReturnNode(expr, lineNo);
    }

    // 〈FunctionDecl〉 ::= ‘ff’ 〈Identifier 〉 ‘(’ [ 〈FormalParams〉 ] ‘)’ ‘:’ ( 〈Type〉
    // | 〈Auto〉 ) 〈Block〉
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

    // 〈FunctionCall〉 ::= 〈Identifier 〉 ‘(’ [ 〈ActualParams〉 ] ‘)’
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

    // 〈ActualParams〉 ::= 〈Expression〉 { ‘,’ 〈Expression〉 }
    private AstActualParam parseActualParam() {
        return new AstActualParam(parseExpr(), currentToken.lineNumber);
    }

    // 〈FormalParam〉 ::= 〈Identifier 〉 ‘:’ 〈Type〉
    private AstFormalParamNode parseFormalParam() {
        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_IDENTIFIER) {
            System.out.println("Expected an Identfier, but got: '" + currentToken.lexeme + "' at line: "
                    + currentToken.lineNumber);
            System.exit(1);
        }
        AstIdentifierNode identifier = parseIdentifier();

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

    // 〈Block〉 ::= ‘{’ { 〈Statement〉 } ‘}’
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

    /**
     * [checkForSemicolon checks that the current token is a semicolon]
     */
    private void checkForSemicolon() {
        changeCurrentToken();
        if (currentToken.tokenIdentifier != tokenIdentifier.TOK_SEMICOLON) {
            System.out.println(
                    "Expected ';', but got: '" + currentToken.lexeme + "' at line: " + currentToken.lineNumber);
            System.exit(1);
        }
    }

    /**
     * [parseVarType returns the correct variable type based on the token type]
     * 
     * @return AstNode.varType [the variable type]
     */
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
            case TOK_CHARTYPE:
                return AstNode.varType.CHAR;
            default:
                System.out.println("Expected type for variable, but got: '" + currentToken.lexeme + "' at line: "
                        + currentToken.lineNumber);
                System.exit(1);
                break;
        }
        return null;
    }

    // 〈Expression〉 ::= 〈SimpleExpression〉 { 〈RelationalOp〉 〈SimpleExpression〉 }
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

    // 〈SimpleExpression〉 ::= 〈Term〉 { 〈AdditiveOp〉 〈Term〉 }
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

    // 〈Term〉 ::= 〈Factor 〉 { 〈MultiplicativeOp〉 〈Factor 〉 }
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

    /*
     * 〈Factor 〉 ::= 〈Literal〉 | 〈Identifier 〉 | 〈FunctionCall〉 | 〈SubExpression〉 |
     * 〈Unary〉|〈Array〉
     */
    private AstExpressionNode parseFactor() {
        changeCurrentToken();
        switch (currentToken.tokenIdentifier) {
            case TOK_FLOAT:
                return new AstFloatLiteralNode(Float.parseFloat(currentToken.lexeme), currentToken.lineNumber);
            case TOK_INTEGER:
                return new AstIntegerLiteralNode(Integer.parseInt(currentToken.lexeme), currentToken.lineNumber);
            case TOK_BOOLEAN:
                return new AstBoolLiteralNode(Boolean.parseBoolean(currentToken.lexeme), currentToken.lineNumber);
            case TOK_CHAR:
                char c = currentToken.lexeme.charAt(1);
                return new AstCharLiteralNode(c, currentToken.lineNumber);
            case TOK_IDENTIFIER:
                if (nextToken.tokenIdentifier == tokenIdentifier.TOK_LEFTBRACKET) {
                    return parseFuncCall();
                }
                return parseIdentifier();
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
            case TOK_LEFTBRACE:
                return parseArray();
            default:
                System.out.println("Unexpected Expression beginning with: '" + currentToken.lexeme + "' at line: "
                        + currentToken.lineNumber);
                System.exit(1);
        }
        return null;
    }

    // 〈Array〉 ∶≔ '{' {Expression} '}'
    private AstArrayNode parseArray() {
        ArrayList<AstExpressionNode> values = new ArrayList<>();

        while (currentToken.tokenIdentifier != tokenIdentifier.TOK_RIGHTBRACE) {
            values.add(parseExpr());

            changeCurrentToken();
            if (currentToken.tokenIdentifier == tokenIdentifier.TOK_RIGHTBRACE) {
                break;
            } else if (currentToken.tokenIdentifier != tokenIdentifier.TOK_COMMA) {
                System.out.println(
                        "Expected ',' but got: " + currentToken.lexeme + " at line: " + currentToken.lineNumber);
                System.exit(1);
            }
        }

        return new AstArrayNode(values, currentToken.lineNumber);
    }

    // 〈Identifier〉 ∷= ( ‘ ’ │〈Letter 〉) { ‘ ’ |〈Letter 〉|〈Digit〉} [〈ArraySize〉]
    private AstIdentifierNode parseIdentifier() {
        String id = currentToken.lexeme;
        int lineNo = currentToken.lineNumber;

        if (nextToken.tokenIdentifier == tokenIdentifier.TOK_LEFTSQUARE) {
            changeCurrentToken();

            AstExpressionNode arrIndex = null;
            if (nextToken.tokenIdentifier != tokenIdentifier.TOK_RIGHTSQUARE) {
                arrIndex = parseExpr();
            }

            changeCurrentToken();
            if (currentToken.tokenIdentifier != tokenIdentifier.TOK_RIGHTSQUARE) {
                System.out.println(
                        "Expected ']' but got: " + currentToken.lexeme + " at line: " + currentToken.lineNumber);
                System.exit(1);
            }

            return new AstArrayIdentifierNode(id, lineNo, arrIndex);
        }

        return new AstIdentifierNode(id, lineNo);
    }
}
