package Parser.AstNodes;

import Visitor.Visitor;

import java.util.ArrayList;

public class AstFuncDeclNode extends AstStatementNode {
    public ArrayList<AstFormalParamNode> params;
    public AstIdentifierNode identifier;
    public AstBlockNode block;
    public varType returnType;
    public int lineNo;

    public AstFuncDeclNode(AstIdentifierNode identifier,ArrayList<AstFormalParamNode> params, AstBlockNode block, varType returnType, int lineNo) {
        this.params = params;
        this.block = block;
        this.returnType = returnType;
        this.lineNo = lineNo;
        this.identifier = identifier;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
