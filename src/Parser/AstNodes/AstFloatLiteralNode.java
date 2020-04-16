package Parser.AstNodes;

import Visitor.Visitor;

public class AstFloatLiteralNode extends AstExpressionNode {
    public float val;
    public int lineNo;

    public AstFloatLiteralNode(float val, int lineNo) {
        this.val = val;
        this.lineNo = lineNo;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
