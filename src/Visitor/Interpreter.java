package Visitor;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;

import Parser.AstNodes.*;
import Parser.AstNodes.AstNode.varType;
import javafx.util.Pair;

public class Interpreter implements Visitor {
    private Stack<SymbolTable> scopes = new Stack<>();
    private SymbolTable currentScope = new SymbolTable();
    private VarTypeVal expresssionValue;
    private boolean ignoreBlockPush = false;
    private boolean ignoreBlockPop = false;

    public Interpreter() {
        initialScope();
    }

    private void push() {
        scopes.push(new SymbolTable());
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
        if (!ignoreBlockPop) {
            pop();
        } else {
            ignoreBlockPop = false;
        }
    }

    @Override
    public void visit(AstForNode v) {
        push();
        if (v.varDecl != null) {
            v.varDecl.accept(this);
        }

        boolean condition;
        do {
            v.expr.accept(this);
            condition = (boolean) expresssionValue.value;
            if (condition) {
                ignoreBlockPush = true;
                ignoreBlockPop = true;
                v.block.accept(this);
                if (v.assignNode != null) {
                    v.assignNode.accept(this);
                }
            }
        } while (condition);
        pop();
    }

    @Override
    public void visit(AstReturnNode v) {
        v.expr.accept(this);
    }

    @Override
    public void visit(AstWhileNode v) {
        boolean condition;
        do {
            v.expr.accept(this);
            condition = (boolean) expresssionValue.value;
            if (condition) {
                v.block.accept(this);
            }
        } while (condition);
    }

    @Override
    public void visit(AstFormalParamNode v) {

    }

    @Override
    public void visit(AstFuncDeclNode v) {
        currentScope = scopes.peek();
        ArrayList<AstNode.varType> paramTypes = new ArrayList<>();
        for (AstFormalParamNode param : v.params) {
            paramTypes.add(param.type);
        }
        String functionIdentifier = v.identifier.identifier;

        currentScope.insert(new Pair<>(functionIdentifier, paramTypes), v);
    }

    @Override
    public void visit(AstVarDeclNode v) {
        currentScope = scopes.peek();
        String id = v.identifier.identifier;

        v.expr.accept(this);
        currentScope.insert(id, expresssionValue);
    }

    @Override
    public void visit(AstIfNode v) {
        v.expr.accept(this);

        if ((boolean) expresssionValue.value) {
            v.ifBlock.accept(this);
        } else {
            if (v.elseBlock != null) {
                v.elseBlock.accept(this);
            }
        }
    }

    @Override
    public void visit(AstPrintNode v) {
        v.expr.accept(this);
        System.out.println(expresssionValue.value);
    }

    @Override
    public void visit(AstAssignNode v) {
        currentScope = scopes.peek();
        String id = v.identifier.identifier;

        v.expr.accept(this);

        currentScope.varBindings.put(id, expresssionValue);
    }

    @Override
    public void visit(AstUnaryNode v) {
        v.expr.accept(this);
        switch (v.op) {
            case "-":
                if (expresssionValue.type == varType.INT) {
                    expresssionValue.value = -(int) expresssionValue.value;
                } else {
                    expresssionValue.value = -(float) expresssionValue.value;
                }
                break;
            case "not":
                expresssionValue.value = !(boolean) expresssionValue.value;
                break;
        }
    }

    private void getIdentfierValue(String id, int lineNo) {
        Stack<SymbolTable> tempStack = (Stack<SymbolTable>) scopes.clone();

        while (!tempStack.isEmpty()) {
            SymbolTable scope = tempStack.pop();
            expresssionValue = scope.varBindings.get(id);
            currentScope = scope;
            return;
        }
    }

    @Override
    public void visit(AstIdentifierNode v) {
        getIdentfierValue(v.identifier, v.lineNo);
    }

    @Override
    public void visit(AstSumBoolExprNode v) {
        VarTypeVal<?> leftSideValue;
        VarTypeVal<?> rightSideValue;
        v.leftSide.accept(this);
        leftSideValue = expresssionValue;
        v.rightSide.accept(this);
        rightSideValue = expresssionValue;
        boolean operationValRel;

        switch (v.op) {
            case "+":
                if (leftSideValue.type == varType.INT) {
                    int operationVal = (int) leftSideValue.value + (int) rightSideValue.value;
                    expresssionValue = new VarTypeVal<Integer>(varType.INT, operationVal);
                } else {
                    float operationVal = (float) leftSideValue.value + (float) rightSideValue.value;
                    expresssionValue = new VarTypeVal<Float>(varType.FLOAT, operationVal);
                }
                break;
            case "-":
                if (leftSideValue.type == varType.INT) {
                    int operationVal = (int) leftSideValue.value - (int) rightSideValue.value;
                    expresssionValue = new VarTypeVal<Integer>(varType.INT, operationVal);
                } else {
                    float operationVal = (float) leftSideValue.value - (float) rightSideValue.value;
                    expresssionValue = new VarTypeVal<Float>(varType.FLOAT, operationVal);
                }
                break;
            case "*":
                if (leftSideValue.type == varType.INT) {
                    int operationVal = (int) leftSideValue.value * (int) rightSideValue.value;
                    expresssionValue = new VarTypeVal<Integer>(varType.INT, operationVal);
                } else {
                    float operationVal = (float) leftSideValue.value * (float) rightSideValue.value;
                    expresssionValue = new VarTypeVal<Float>(varType.FLOAT, operationVal);
                }
                break;
            case "/":
                if (leftSideValue.type == varType.INT) {
                    int operationVal = (int) leftSideValue.value / (int) rightSideValue.value;
                    expresssionValue = new VarTypeVal<Integer>(varType.INT, operationVal);
                } else {
                    float operationVal = (float) leftSideValue.value / (float) rightSideValue.value;
                    expresssionValue = new VarTypeVal<Float>(varType.FLOAT, operationVal);
                }
                break;
            case "and":
                boolean operationVal = (boolean) leftSideValue.value && (boolean) rightSideValue.value;
                expresssionValue = new VarTypeVal<Boolean>(varType.BOOL, operationVal);
                break;
            case "or":
                boolean operationValOr = (boolean) leftSideValue.value || (boolean) rightSideValue.value;
                expresssionValue = new VarTypeVal<Boolean>(varType.BOOL, operationValOr);
                break;
            case "<":
                if (leftSideValue.type == varType.INT) {
                    operationValRel = (int) leftSideValue.value < (int) rightSideValue.value;
                } else {
                    operationValRel = (float) leftSideValue.value < (float) rightSideValue.value;
                }
                expresssionValue = new VarTypeVal<Boolean>(varType.BOOL, operationValRel);
                break;
            case ">":
                if (leftSideValue.type == varType.INT) {
                    operationValRel = (int) leftSideValue.value > (int) rightSideValue.value;
                } else {
                    operationValRel = (float) leftSideValue.value > (float) rightSideValue.value;
                }
                expresssionValue = new VarTypeVal<Boolean>(varType.BOOL, operationValRel);
                break;
            case "==":
                if (leftSideValue.type == varType.INT) {
                    operationValRel = (int) leftSideValue.value == (int) rightSideValue.value;
                } else {
                    operationValRel = (float) leftSideValue.value == (float) rightSideValue.value;
                }
                expresssionValue = new VarTypeVal<Boolean>(varType.BOOL, operationValRel);
                break;
            case "<>":
                if (leftSideValue.type == varType.INT) {
                    operationValRel = (int) leftSideValue.value != (int) rightSideValue.value;
                } else {
                    operationValRel = (float) leftSideValue.value != (float) rightSideValue.value;
                }
                expresssionValue = new VarTypeVal<Boolean>(varType.BOOL, operationValRel);
                break;
            case "<=":
                if (leftSideValue.type == varType.INT) {
                    operationValRel = (int) leftSideValue.value <= (int) rightSideValue.value;
                } else {
                    operationValRel = (float) leftSideValue.value <= (float) rightSideValue.value;
                }
                expresssionValue = new VarTypeVal<Boolean>(varType.BOOL, operationValRel);
                break;
            case ">=":
                if (leftSideValue.type == varType.INT) {
                    operationValRel = (int) leftSideValue.value >= (int) rightSideValue.value;
                } else {
                    operationValRel = (float) leftSideValue.value >= (float) rightSideValue.value;
                }
                expresssionValue = new VarTypeVal<Boolean>(varType.BOOL, operationValRel);
                break;

        }
    }

    @Override
    public void visit(AstFunctionCall v) {
        ArrayList<VarTypeVal> params = new ArrayList<>();
        ArrayList<AstNode.varType> paramTypes = new ArrayList<>();
        String id = v.identifier.identifier;

        for (AstActualParam param : v.params) {
            param.accept(this);
            params.add(expresssionValue);
            paramTypes.add(expresssionValue.type);
        }

        currentScope = scopes.peek();

        AstFuncDeclNode function = currentScope.funcBindings
                .get(new Pair<String, ArrayList<AstNode.varType>>(id, paramTypes));

        push();
        currentScope = scopes.peek();
        for (AstFormalParamNode param : function.params) {
            currentScope.insert(param.identifier.identifier, params.remove(0));
        }
        ignoreBlockPush = true;
        function.block.accept(this);
    }

    @Override
    public void visit(AstActualParam v) {
        v.param.accept(this);
    }

    @Override
    public void visit(AstFloatLiteralNode v) {
        expresssionValue = new VarTypeVal<Float>(varType.FLOAT, v.val);
    }

    @Override
    public void visit(AstIntegerLiteralNode v) {
        expresssionValue = new VarTypeVal<Integer>(AstNode.varType.INT, v.val);
    }

    @Override
    public void visit(AstBoolLiteralNode v) {
        expresssionValue = new VarTypeVal<Boolean>(AstNode.varType.BOOL, v.val);
    }
}

class VarTypeVal<T> {
    AstNode.varType type;
    T value;

    public VarTypeVal(AstNode.varType type, T value) {
        this.type = type;
        this.value = value;
    }
}

class SymbolTable {
    HashMap<String, VarTypeVal> varBindings = new HashMap<>();
    HashMap<Pair<String, ArrayList<AstNode.varType>>, AstFuncDeclNode> funcBindings = new HashMap<>();

    void insert(String id, VarTypeVal value) {
        varBindings.put(id, value);
    }

    void insert(Pair<String, ArrayList<AstNode.varType>> signature, AstFuncDeclNode function) {
        funcBindings.put(signature, function);
    }
}
