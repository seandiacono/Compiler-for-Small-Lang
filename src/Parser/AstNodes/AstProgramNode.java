package Parser.AstNodes;

import Visitor.Visitor;

import java.util.ArrayList;

public class AstProgramNode extends AstNode {
    public ArrayList<AstStatementNode> statements;

    public AstProgramNode(ArrayList<AstStatementNode> statementsIn){
        statements = statementsIn;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
