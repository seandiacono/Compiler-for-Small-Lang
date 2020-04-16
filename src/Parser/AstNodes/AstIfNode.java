package Parser.AstNodes;


import Visitor.Visitor;

public class AstIfNode extends AstStatementNode {
    public AstExpressionNode expr;
    public AstBlockNode ifBlock;
    public AstBlockNode elseBlock;
    public int lineNo;

    public AstIfNode(AstExpressionNode expr, AstBlockNode ifBlock, int lineNo) {
        this.expr = expr;
        this.ifBlock = ifBlock;
        this.lineNo = lineNo;
    }

    public AstIfNode(AstExpressionNode expr, AstBlockNode ifBlock, AstBlockNode elseBlock, int lineNo){
        this.expr = expr;
        this.ifBlock = ifBlock;
        this.elseBlock = elseBlock;
        this.lineNo = lineNo;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
