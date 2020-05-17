package Parser.AstNodes;

import Visitor.Visitor;

public class AstCharLiteralNode extends AstExpressionNode {
    public char val;
    public int lineNo;

    public AstCharLiteralNode(char val, int lineNo) {
        this.val = val;
        this.lineNo = lineNo;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}