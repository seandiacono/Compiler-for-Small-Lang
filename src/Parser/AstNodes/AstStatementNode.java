package Parser.AstNodes;

import Visitor.Visitor;

public class AstStatementNode extends AstNode {
    public void accept(Visitor v){
        v.visit(this);
    }
}
