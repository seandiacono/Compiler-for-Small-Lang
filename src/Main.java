import Parser.AstNodes.AstNode;
import Parser.AstNodes.AstProgramNode;
import Parser.Parser;
import Lexer.*;
import Visitor.SemanticAnalyser;
import Visitor.XmlVisitor;

public class Main {
    public static void main(String args[]){
        Parser parser = new Parser();
        Lexer lexer = new Lexer();
        XmlVisitor xmlVisitor = new XmlVisitor();
        SemanticAnalyser semanticAnalyser = new SemanticAnalyser();

        lexer.readInput("test.txt");
        AstProgramNode program = parser.parse();
//        for (AstNode statement: program.statements) {
//            System.out.println(statement.toString());
//        }

        //program.accept(xmlVisitor);

        program.accept(semanticAnalyser);
    }
}
