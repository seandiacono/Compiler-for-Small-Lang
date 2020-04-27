import Parser.AstNodes.AstProgramNode;
import Parser.Parser;
import Lexer.*;
import Visitor.Interpreter;
import Visitor.SemanticAnalyser;
//import Visitor.XmlVisitor;

public class Main {
    public static void main(String args[]) {
        Parser parser = new Parser();
        // XmlVisitor xmlVisitor = new XmlVisitor();
        SemanticAnalyser semanticAnalyser = new SemanticAnalyser();
        Interpreter interpreter = new Interpreter();

        Lexer.readInput("C:/Users/seand/Documents/University/Compiler Theory/Compiler-for-Small-Lang/test.txt");
        AstProgramNode program = parser.parse();
        // for (AstNode statement : program.statements) {
        // System.out.println(statement.toString());
        // }

        // program.accept(xmlVisitor);

        program.accept(semanticAnalyser);

        program.accept(interpreter);
    }
}
