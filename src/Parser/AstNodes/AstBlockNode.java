package Parser.AstNodes;

import Visitor.Visitor;

import java.util.ArrayList;

public class AstBlockNode extends AstStatementNode{
    public ArrayList<AstStatementNode> statements;
    public int lineNo;

    public AstBlockNode(ArrayList<AstStatementNode> statements, int lineNo) {
        this.statements = statements;
        this.lineNo = lineNo;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
