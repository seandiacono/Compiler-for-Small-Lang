package Parser.AstNodes;

import Visitor.Visitor;

public class AstIntegerLiteralNode extends AstExpressionNode {
    public int val;
    public int lineNo;

    public AstIntegerLiteralNode(int val, int lineNo) {
        this.val = val;
        this.lineNo = lineNo;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
