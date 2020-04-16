package Parser.AstNodes;

import Visitor.Visitor;

public class AstPrintNode extends AstStatementNode {
    public AstExpressionNode expr;
    public int lineNo;

    public AstPrintNode(AstExpressionNode expr, int lineNo) {
        this.expr = expr;
        this.lineNo = lineNo;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
