package Parser.AstNodes;

import java.util.ArrayList;

import Visitor.Visitor;

public class AstArrayNode extends AstExpressionNode {
    public ArrayList<AstExpressionNode> array;
    public int lineNo;

    public AstArrayNode(ArrayList<AstExpressionNode> array, int lineNo) {
        this.array = array;
        this.lineNo = lineNo;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}