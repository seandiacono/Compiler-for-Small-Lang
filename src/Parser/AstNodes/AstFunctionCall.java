package Parser.AstNodes;

import Visitor.Visitor;

import java.util.ArrayList;

public class AstFunctionCall extends AstExpressionNode {
    public AstIdentifierNode identifier;
    public ArrayList<AstActualParam> params;
    public int lineNo;

    public AstFunctionCall(AstIdentifierNode identifier, ArrayList<AstActualParam> params, int lineNo) {
        this.identifier = identifier;
        this.params = params;
        this.lineNo = lineNo;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
