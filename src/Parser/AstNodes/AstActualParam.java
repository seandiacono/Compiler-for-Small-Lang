package Parser.AstNodes;

import Visitor.Visitor;

public class AstActualParam extends AstStatementNode {
    public AstExpressionNode param;
    public int lineNo;

    public AstActualParam(AstExpressionNode param, int lineNo) {
        this.param = param;
        this.lineNo = lineNo;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
