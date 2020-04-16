package Parser.AstNodes;

import Visitor.Visitor;

public class AstFormalParamNode extends AstStatementNode {
    public AstIdentifierNode identifier;
    public varType type;
    public int lineNo;

    public AstFormalParamNode(AstIdentifierNode identifier, AstNode.varType type, int lineNo) {
        this.identifier = identifier;
        this.type = type;
        this.lineNo = lineNo;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
