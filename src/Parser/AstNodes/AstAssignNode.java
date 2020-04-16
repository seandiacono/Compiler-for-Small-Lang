package Parser.AstNodes;

import Visitor.Visitor;

public class AstAssignNode extends AstStatementNode {
    public AstIdentifierNode identifier;
    public AstExpressionNode expr;
    public int lineNo;

    public AstAssignNode(AstIdentifierNode identifier, AstExpressionNode expr, int lineNo){
        this.identifier = identifier;
        this.expr = expr;
        this.lineNo = lineNo;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
