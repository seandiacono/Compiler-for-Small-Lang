package Visitor;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;

import Parser.AstNodes.*;
import Parser.AstNodes.AstNode.varType;
import javafx.util.Pair;

// keep track of functions to check return type
class functionsAssignReturn {
    String id;
    Scope scope;
    ArrayList<AstNode.varType> paramTypes;

    functionsAssignReturn(String id, Scope scope, ArrayList<AstNode.varType> paramTypes) {
        this.id = id;
        this.scope = scope;
        this.paramTypes = paramTypes;
    }
}

public class SemanticAnalyser implements Visitor {
    private Stack<Scope> scopes = new Stack<>();
    private Scope currentScope = new Scope();
    private AstNode.varType expressionType;
    private boolean ignoreBlockPush = false;
    private Stack<functionsAssignReturn> functionsStack = new Stack<>();

    // push global scope
    public SemanticAnalyser() {
        push();
    }

    /**
     * [push push a new scope to the stack]
     */
    private void push() {
        scopes.push(new Scope());
    }

    /**
     * [pop pop a scope from the stack]
     */
    private void pop() {
        scopes.pop();
    }

    @Override
    public void visit(AstProgramNode v) {
        // all statements in the program
        for (AstStatementNode statement : v.statements) {
            statement.accept(this);
        }
    }

    @Override
    public void visit(AstStatementNode v) {

    }

    @Override
    public void visit(AstExpressionNode v) {

    }

    @Override
    public void visit(AstBlockNode v) {
        if (!ignoreBlockPush) { // do not push a new scope if it has already been pushed
            push();
        } else {
            ignoreBlockPush = false;
        }
        for (AstStatementNode statement : v.statements) {
            statement.accept(this);
        }
        pop();
    }

    @Override
    public void visit(AstForNode v) {
        push();
        if (v.varDecl != null) {// check if for loop has var decl
            v.varDecl.accept(this);
        }

        v.expr.accept(this);
        if (expressionType != AstNode.varType.BOOL) {// make sure condition is of type BOOl
            System.out.println("Expected conditional expression in for loop at line: " + v.lineNo
                    + ", but got an expression of type: " + expressionType);
            System.exit(1);
        }

        if (v.assignNode != null) {// check if for loop has var assignment
            v.assignNode.accept(this);
        }

        ignoreBlockPush = true;
        v.block.accept(this);
    }

    @Override
    public void visit(AstReturnNode v) {
        v.expr.accept(this);
        setReturnType(); // check return type of function to see if they match
    }

    @Override
    public void visit(AstWhileNode v) {
        v.expr.accept(this);
        if (expressionType != AstNode.varType.BOOL) {
            System.out.println("Expected conditional expression in while loop at line: " + v.lineNo
                    + ", but got an expression of type: " + expressionType);
            System.exit(1);
        }
        v.block.accept(this);
    }

    @Override
    public void visit(AstFormalParamNode v) {

    }

    @Override
    public void visit(AstFuncDeclNode v) {
        currentScope = scopes.peek();
        HashMap<String, AstNode.varType> paramsMap = new HashMap<>();
        ArrayList<AstNode.varType> paramTypes = new ArrayList<>();
        // store parameters
        for (AstFormalParamNode param : v.params) {
            paramTypes.add(param.type);
            paramsMap.put(param.identifier.identifier, param.type);
        }

        String functionIdentifier = v.identifier.identifier;

        // check if function has already been declared
        if (currentScope.lookup(new Pair<>(functionIdentifier, paramTypes))) {
            System.out.println("Cannot declare function at line: " + v.lineNo
                    + " because a function with the same signature has already been declared.");
            System.exit(1);
        }

        // check if function has a return statement
        AstNode.varType returnType = v.returnType;
        boolean hasReturn = false;
        for (AstStatementNode statement : v.block.statements) {
            if (checkForReturn(statement)) {
                hasReturn = true;
                break;
            }
        }

        if (!hasReturn) {
            System.out.println("Function declared at line: " + v.lineNo + " has no return statement in the block.");
            System.exit(1);
        }
        Scope tempScope = currentScope;
        tempScope.insert(new Pair<>(functionIdentifier, paramTypes), returnType);
        // add function to stack to check if return type matches actual return
        // expression type
        functionsAssignReturn function = new functionsAssignReturn(functionIdentifier, tempScope, paramTypes);
        functionsStack.push(function);

        // push a new scope
        push();
        currentScope = scopes.peek();
        // add params to the new scope
        currentScope.varBindings = paramsMap;
        // ignore the block push since a new scope has already been pushed
        ignoreBlockPush = true;
        v.block.accept(this);
        functionsStack.pop();
    }

    private void setReturnType() {
        functionsAssignReturn function = functionsStack.peek();
        // set the return type to the type of the return expression if the return type was auto or else check that the return type matches the one stored
        if (function.scope.funcBindings.get(new Pair<>(function.id, function.paramTypes)) == AstNode.varType.AUTO) { 
            function.scope.funcBindings.put(new Pair<>(function.id, function.paramTypes), expressionType);
        } else if (expressionType != function.scope.funcBindings.get(new Pair<>(function.id, function.paramTypes))) { 
            System.out.println("Expected return of type: "
                    + function.scope.funcBindings.get(new Pair<>(function.id, function.paramTypes))
                    + " but got an expression of type: " + expressionType);
            System.exit(1);
        }
    }

    /**
     * [checkForReturn recursively checks that a statement contains or is a return
     * statemen]
     *
     * @return boolean [true if a return statement was found and false if one wasn't
     *         found]
     */
    private boolean checkForReturn(AstStatementNode statement) {
        if (statement == null) {
            return false;
        }
        if (statement.getClass() == AstReturnNode.class) {
            return true;
        }

        if (statement.getClass() == AstBlockNode.class) {
            AstBlockNode block = (AstBlockNode) statement;
            for (AstStatementNode statementPar : block.statements) {
                if (checkForReturn(statementPar)) {
                    return true;
                }
            }
        }

        if (statement.getClass() == AstIfNode.class) {
            AstIfNode ifStatement = (AstIfNode) statement;
            AstBlockNode ifBlock = ifStatement.ifBlock;
            AstBlockNode elseBlock = ifStatement.elseBlock;
            if (checkForReturn(ifBlock) && checkForReturn(elseBlock)) {
                return true;
            }
        }

        if (statement.getClass() == AstForNode.class) {
            AstForNode forStatement = (AstForNode) statement;
            if (checkForReturn(forStatement.block)) {
                return true;
            }
        }

        if (statement.getClass() == AstWhileNode.class) {
            AstWhileNode whileStatement = (AstWhileNode) statement;
            if (checkForReturn(whileStatement.block)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void visit(AstVarDeclNode v) {
        currentScope = scopes.peek();
        String id = v.identifier.identifier;

        if (currentScope.lookup(id)) {
            System.out.println("Variable with identifier: \"" + v.identifier.identifier + "\"  at line: "
                    + v.identifier.lineNo + " has already been declared.");
            System.exit(1);
        } else {

            v.expr.accept(this);
            if (v.type == AstNode.varType.AUTO) {
                v.type = expressionType;
            } else if (expressionType != v.type) {
                System.out.println("Incompatible types found at line: " + v.identifier.lineNo + ". Expected: " + v.type
                        + " but got: " + expressionType);
                System.exit(1);
            }
            currentScope.insert(id, v.type);
        }

    }

    @Override
    public void visit(AstIfNode v) {
        v.expr.accept(this);
        if (expressionType != AstNode.varType.BOOL) {
            System.out.println("Expected conditional expression in if statement at line: " + v.lineNo
                    + ", but got an expression of type: " + expressionType);
            System.exit(1);
        }

        v.ifBlock.accept(this);

        // check if if statement has an else block
        if (v.elseBlock != null) {
            v.elseBlock.accept(this);
        }
    }

    @Override
    public void visit(AstPrintNode v) {
        v.expr.accept(this);
    }

    @Override
    public void visit(AstAssignNode v) {
        currentScope = scopes.peek();
        String id = v.identifier.identifier;

        v.identifier.accept(this);
        AstNode.varType identifierType = expressionType;

        v.expr.accept(this);

        if (expressionType != identifierType) {
            System.out.println("Incompatible types found at line: " + v.identifier.lineNo + ". Expected: "
                    + currentScope.varBindings.get(id) + " but got: " + expressionType);
            System.exit(1);
        }
    }

    @Override
    public void visit(AstUnaryNode v) {
        v.expr.accept(this);
        // check if operator matches variable type
        if (expressionType == AstNode.varType.BOOL && v.op.equals("-")) {
            System.out.println("\"" + v.op + "\" cannot be performed on expression of type: " + expressionType
                    + ", on line: " + v.lineNo);
            System.exit(1);
        } else if (expressionType == AstNode.varType.INT && v.op.equals("not")) {
            System.out.println("\"" + v.op + "\" cannot be performed on expression of type: " + expressionType
                    + ", on line: " + v.lineNo);
            System.exit(1);
        }
    }

    /**
     * [getIdentfierType searches for the identifer in current scope and scopes
     * above it and sets the expression type to the type of the identifier found]
     *
     * @param int lineNo [lineNo the lineNo the identifier was referred to at]
     */
    private void getIdentfierType(String id, int lineNo) {
        Stack<Scope> tempStack = (Stack<Scope>) scopes.clone();

        while (!tempStack.isEmpty()) {
            Scope scope = tempStack.pop();
            if (scope.lookup(id)) {
                expressionType = scope.varBindings.get(id);
                currentScope = scope;
                return;
            }
        }
        System.out.println("Identifier: \"" + id + "\" at line: " + lineNo + ", was never declared.");
        System.exit(1);
    }

    @Override
    public void visit(AstIdentifierNode v) {
        getIdentfierType(v.identifier, v.lineNo);
    }

    @Override
    public void visit(AstSumBoolExprNode v) {
        AstNode.varType leftSideType;
        AstNode.varType rightSideType;
        v.leftSide.accept(this);
        leftSideType = expressionType;
        v.rightSide.accept(this);
        rightSideType = expressionType;

        // check that left side and right side match and that the operator works with
        // the expression types
        if (leftSideType != rightSideType) {
            System.out.println("Mismatched types in expression at line: " + v.lineNo + ". Cannot perform operation on: "
                    + leftSideType + " and " + rightSideType);
            System.exit(1);
        } else if ((v.op.equals("+") || v.op.equals("-") || v.op.equals("*") || v.op.equals("/"))
                && leftSideType == AstNode.varType.BOOL) {
            System.out.println("\"" + v.op + "\" cannot be performed on expression of type: " + leftSideType
                    + ", on line: " + v.lineNo);
            System.exit(1);
        } else if ((v.op.equals("and") || v.op.equals("or"))
                && (leftSideType == AstNode.varType.INT || leftSideType == AstNode.varType.FLOAT)) {
            System.out.println("\"" + v.op + "\" cannot be performed on expression of type: " + leftSideType
                    + ", on line: " + v.lineNo);
            System.exit(1);
        } else if (v.op.equals("<") || v.op.equals(">") || v.op.equals("==") || v.op.equals("<>") || v.op.equals("<=")
                || v.op.equals(">=")) {
            if (leftSideType != varType.BOOL) {
                expressionType = AstNode.varType.BOOL;
            } else {
                System.out.println("\"" + v.op + "\" cannot be performed on expression of type: " + leftSideType
                        + ", on line: " + v.lineNo);
                System.exit(1);
            }
        }
    }

    @Override
    public void visit(AstFunctionCall v) {
        ArrayList<AstNode.varType> paramTypes = new ArrayList<>();
        String id = v.identifier.identifier;

        for (AstActualParam param : v.params) {
            param.accept(this);
            paramTypes.add(expressionType);
        }

        // search for the function called
        Stack<Scope> tempStack = (Stack<Scope>) scopes.clone();
        boolean found = false;

        while (!tempStack.isEmpty()) {
            Scope scope = tempStack.pop();
            if (scope.lookup(new Pair<>(id, paramTypes))) {
                expressionType = scope.funcBindings.get(new Pair<>(id, paramTypes));
                currentScope = scope;
                found = true;
                break;
            }
        }

        // if the function wasn't found raise an error
        if (!found) {
            System.out.print("No function with identifer: " + id + " and param types: ");
            for (AstNode.varType type : paramTypes) {
                System.out.print(type + ", ");
            }
            System.out.println("for function call at line: " + v.lineNo);
            System.exit(1);
        }
    }

    @Override
    public void visit(AstActualParam v) {
        v.param.accept(this);
    }

    @Override
    public void visit(AstFloatLiteralNode v) {
        expressionType = AstNode.varType.FLOAT;
    }

    @Override
    public void visit(AstIntegerLiteralNode v) {
        expressionType = AstNode.varType.INT;
    }

    @Override
    public void visit(AstBoolLiteralNode v) {
        expressionType = AstNode.varType.BOOL;
    }
}

class Scope {
    // stores variable ids and types
    HashMap<String, AstNode.varType> varBindings = new HashMap<>();

    // stores function ids, param types and return types
    HashMap<Pair<String, ArrayList<AstNode.varType>>, AstNode.varType> funcBindings = new HashMap<>();

    // lookup variable
    boolean lookup(String id) {
        return varBindings.containsKey(id);
    }

    // insert variable
    void insert(String id, AstNode.varType type) {
        varBindings.put(id, type);
    }

    // insert function
    void insert(Pair<String, ArrayList<AstNode.varType>> signature, AstNode.varType returnType) {
        funcBindings.put(signature, returnType);
    }

    // lookup function
    boolean lookup(Pair<String, ArrayList<AstNode.varType>> signature) {
        return funcBindings.containsKey(signature);
    }
}
