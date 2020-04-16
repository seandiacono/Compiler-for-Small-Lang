package Parser.AstNodes;

import Visitor.Visitor;

public class AstForNode extends AstStatementNode {
    public AstVarDeclNode varDecl;
    public AstExpressionNode expr;
    public AstAssignNode assignNode;
    public AstBlockNode block;
    public int lineNo;

    public AstForNode(AstVarDeclNode varDecl, AstExpressionNode expr, AstAssignNode assignNode, AstBlockNode block, int lineNo) {
        this.varDecl = varDecl;
        this.expr = expr;
        this.assignNode = assignNode;
        this.block = block;
        this.lineNo = lineNo;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
