package Parser.AstNodes;

import Visitor.Visitor;

public class AstWhileNode extends AstStatementNode {
    public AstExpressionNode expr;
    public AstBlockNode block;
    public int lineNo;

    public AstWhileNode(AstExpressionNode expr, AstBlockNode block, int lineNo) {
        this.expr = expr;
        this.block = block;
        this.lineNo = lineNo;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
