package Parser.AstNodes;

import Visitor.Visitor;

public class AstUnaryNode extends AstExpressionNode {
    public String op;
    public AstExpressionNode expr;
    public int lineNo;

    public AstUnaryNode(String op, AstExpressionNode expr, int lineNo) {
        this.op = op;
        this.expr = expr;
        this.lineNo = lineNo;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
