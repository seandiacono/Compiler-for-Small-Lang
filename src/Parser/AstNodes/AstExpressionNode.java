package Parser.AstNodes;

import Visitor.Visitor;

public class AstExpressionNode extends AstNode {
    public void accept(Visitor v){
        v.visit(this);
    }
}
