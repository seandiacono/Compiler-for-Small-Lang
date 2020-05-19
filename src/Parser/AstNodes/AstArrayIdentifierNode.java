package Parser.AstNodes;

import Visitor.Visitor;

public class AstArrayIdentifierNode extends AstIdentifierNode{
    AstExpressionNode arrIndex;

    public AstArrayIdentifierNode(String identifier, int lineNo,AstExpressionNode arrIndex) {
        super(identifier, lineNo);
        this.arrIndex = arrIndex;
    }
    
    public void accept(Visitor v){
        v.visit(this);
    }
}