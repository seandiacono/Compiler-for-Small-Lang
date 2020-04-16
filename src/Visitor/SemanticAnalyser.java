package Visitor;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;

import Parser.AstNodes.*;
import javafx.util.Pair;

public class SemanticAnalyser implements Visitor {
    private Stack<Scope> scopes = new Stack<>();
    private Scope currentScope = new Scope();
    private AstNode.varType expressionType;
    private boolean ignoreBlockPush = false;
    private boolean hasReturn = false;

    public SemanticAnalyser() {
        initialScope();
    }

    private void push() {
        scopes.push(new Scope());
    }

    private void pop() {
        scopes.pop();
    }

    private void initialScope() {
        push();
    }

    @Override
    public void visit(AstProgramNode v) {
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
        if (!ignoreBlockPush) {
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
        if (v.varDecl != null) {
            v.varDecl.accept(this);
        }

        v.expr.accept(this);
        if (expressionType != AstNode.varType.BOOL) {
            System.out.println("Expected conditional expression in for loop at line: " + v.lineNo + ", but got an expression of type: " + expressionType);
            System.exit(1);
        }

        if (v.assignNode != null) {
            v.assignNode.accept(this);
        }

        ignoreBlockPush = true;
        v.block.accept(this);
    }

    @Override
    public void visit(AstReturnNode v) {
        v.expr.accept(this);
        hasReturn = true;
    }

    @Override
    public void visit(AstWhileNode v) {
        v.expr.accept(this);
        if (expressionType != AstNode.varType.BOOL) {
            System.out.println("Expected conditional expression in while loop at line: " + v.lineNo + ", but got an expression of type: " + expressionType);
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
        hasReturn = false;
        ArrayList<AstNode.varType> typeList = new ArrayList<>();
        HashMap<String, AstNode.varType> paramsMap = new HashMap<>();
        for (AstFormalParamNode param : v.params) {
            typeList.add(param.type);
            paramsMap.put(param.identifier.identifier, param.type);
        }

        String id = v.identifier.identifier;

        if (currentScope.lookupFunc(new Pair<>(id, typeList))) {
            System.out.println("Cannot declare function at line: " + v.lineNo + " because a function with the same signature has already been declared.");
            System.exit(1);
        }

        AstNode.varType returnType = v.returnType;
        Scope tempScope = currentScope;

        push();
        currentScope = scopes.peek();
        currentScope.varBindings = paramsMap;
        ignoreBlockPush = true;
        v.block.accept(this);

        if (hasReturn) {
            if (returnType == AstNode.varType.AUTO) {
                returnType = expressionType;
            } else if (expressionType != returnType) {
                System.out.println("Expected return of type: " + returnType + " but got an expression of type: " + expressionType + " in function declared at line: " + v.lineNo);
                System.exit(1);
            }
            tempScope.insert(new Pair<>(id, typeList), returnType);
        } else {
            System.out.println("Function declared at line: " + v.lineNo + " has no return statement in the block.");
            System.exit(1);
        }
    }

    @Override
    public void visit(AstVarDeclNode v) {
        currentScope = scopes.peek();
        String id = v.identifier.identifier;

        if (currentScope.lookup(id)) {
            System.out.println("Variable with identifier: \"" + v.identifier.identifier + "\"  at line: " + v.identifier.lineNo + " has already been declared.");
            System.exit(1);
        } else {

            v.expr.accept(this);
            if (v.type == AstNode.varType.AUTO) {
                v.type = expressionType;
            } else if (expressionType != v.type) {
                System.out.println("Incompatible types found at line: " + v.identifier.lineNo + ". Expected: " + v.type + " but got: " + expressionType);
                System.exit(1);
            }
            currentScope.insert(id, v.type);
        }

    }

    @Override
    public void visit(AstIfNode v) {
        v.expr.accept(this);
        if (expressionType != AstNode.varType.BOOL) {
            System.out.println("Expected conditional expression in if statement at line: " + v.lineNo + ", but got an expression of type: " + expressionType);
            System.exit(1);
        }

        v.ifBlock.accept(this);

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

        v.expr.accept(this);

        if (expressionType != currentScope.varBindings.get(id)) {
            System.out.println("Incompatible types found at line: " + v.identifier.lineNo + ". Expected: " + currentScope.varBindings.get(id) + " but got: " + expressionType);
            System.exit(1);
        }
    }

    @Override
    public void visit(AstUnaryNode v) {
        v.expr.accept(this);
        if (expressionType == AstNode.varType.BOOL && v.op.equals("-")) {
            System.out.println("\"" + v.op + "\" cannot be performed on expression of type: " + expressionType + ", on line: " + v.lineNo);
            System.exit(1);
        } else if (expressionType == AstNode.varType.INT && v.op.equals("not")) {
            System.out.println("\"" + v.op + "\" cannot be performed on expression of type: " + expressionType + ", on line: " + v.lineNo);
            System.exit(1);
        }
    }

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

        if (leftSideType != rightSideType) {
            System.out.println("Mismatched types in expression at line: " + v.lineNo + ". Cannot perform operation on: " + leftSideType + " and " + rightSideType);
            System.exit(1);
        } else if ((v.op.equals("+") || v.op.equals("-") || v.op.equals("*") || v.op.equals("/")) && leftSideType == AstNode.varType.BOOL) {
            System.out.println("\"" + v.op + "\" cannot be performed on expression of type: " + leftSideType + ", on line: " + v.lineNo);
            System.exit(1);
        } else if ((v.op.equals("and") || v.op.equals("or")) && (leftSideType == AstNode.varType.INT || leftSideType == AstNode.varType.FLOAT)) {
            System.out.println("\"" + v.op + "\" cannot be performed on expression of type: " + leftSideType + ", on line: " + v.lineNo);
            System.exit(1);
        } else if (v.op.equals("<") || v.op.equals(">") || v.op.equals("==") || v.op.equals("<>") || v.op.equals("<=") || v.op.equals(">=")) {
            expressionType = AstNode.varType.BOOL;
        }
    }

    @Override
    public void visit(AstFunctionCall v) {
        currentScope = scopes.peek();
        ArrayList<AstNode.varType> paramTypes = new ArrayList<>();
        String id = v.identifier.identifier;

        for(AstActualParam param: v.params){
            param.accept(this);
            paramTypes.add(expressionType);
        }

        if(currentScope.lookupFunc(new Pair<>(id, paramTypes))){
            expressionType = currentScope.funcBindings.get(new Pair<>(id, paramTypes));
        }else{
            System.out.print("No function with identifer: " + id + " and param types: ");
            for (AstNode.varType type: paramTypes) {
                System.out.print(", " + type);
            }
            System.out.println(" for function call at line: " + v.lineNo);
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
    HashMap<String, AstNode.varType> varBindings = new HashMap<>();
    HashMap<Pair<String, ArrayList<AstNode.varType>>, AstNode.varType> funcBindings = new HashMap<>();

    boolean lookup(String id) {
        return varBindings.containsKey(id);
    }

    void insert(String id, AstNode.varType type) {
        varBindings.put(id, type);
    }

    void insert(Pair<String, ArrayList<AstNode.varType>> signature, AstNode.varType returnType) {
        funcBindings.put(signature, returnType);
    }

    boolean lookupFunc(Pair<String, ArrayList<AstNode.varType>> signature) {
        return funcBindings.containsKey(signature);
    }
}
