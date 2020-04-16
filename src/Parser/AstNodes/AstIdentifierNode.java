package Parser.AstNodes;

import Visitor.Visitor;

public class AstIdentifierNode extends AstExpressionNode{
    public String identifier;
    public int lineNo;

    public AstIdentifierNode(String identifier, int lineNo) {
        this.identifier = identifier;
        this.lineNo = lineNo;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
