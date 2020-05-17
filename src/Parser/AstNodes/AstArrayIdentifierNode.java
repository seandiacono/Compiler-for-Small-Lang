package Parser.AstNodes;

import Visitor.Visitor;

public class AstArrayIdentifierNode extends AstIdentifierNode{
    int arrSize;

    public AstArrayIdentifierNode(String identifier, int lineNo,int arrSize) {
        super(identifier, lineNo);
        this.arrSize = arrSize;
    }
    
    public void accept(Visitor v){
        v.visit(this);
    }
}