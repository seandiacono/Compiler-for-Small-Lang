package Parser.AstNodes;

import Visitor.Visitor;

public class AstSumBoolExprNode extends AstExpressionNode {
    public String op;
    public AstExpressionNode leftSide;
    public AstExpressionNode rightSide;
    public int lineNo;

    public AstSumBoolExprNode(String op, AstExpressionNode leftSide, AstExpressionNode rightSide, int lineNo) {
        this.op = op;
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        this.lineNo = lineNo;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
