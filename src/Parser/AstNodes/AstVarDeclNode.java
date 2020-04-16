package Parser.AstNodes;

import Visitor.Visitor;

public class AstVarDeclNode extends AstStatementNode {
    public AstIdentifierNode identifier;
    public int lineNo;
    public varType type;
    public AstExpressionNode expr;

    public AstVarDeclNode(AstIdentifierNode identifierIn, int lineNoIn, varType typeIn, AstExpressionNode exprIn){
        identifier = identifierIn;
        lineNo = lineNoIn;
        type = typeIn;
        expr = exprIn;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
