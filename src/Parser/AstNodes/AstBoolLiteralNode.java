package Parser.AstNodes;

import Visitor.Visitor;

public class AstBoolLiteralNode extends AstExpressionNode {
    public boolean val;
    public int lineNo;

    public AstBoolLiteralNode(boolean val, int lineNo) {
        this.val = val;
        this.lineNo = lineNo;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
