import Parser.AstNodes.AstProgramNode;
import Parser.Parser;
import Lexer.*;
import Visitor.InterpreterVisitor;
import Visitor.SemanticAnalyser;
import Visitor.XmlVisitor;

public class Main {
    public static void main(String args[]) {
        Parser parser = new Parser();
        XmlVisitor xmlVisitor = new XmlVisitor();
        SemanticAnalyser semanticAnalyser = new SemanticAnalyser();
        InterpreterVisitor interpreter = new InterpreterVisitor();

        Lexer.readInput("C:/Users/seand/Documents/University/Compiler Theory/Compiler-for-Small-Lang/test.txt");
        AstProgramNode program = parser.parse();

        // produce xml ast
        program.accept(xmlVisitor);

        // check semantics
        program.accept(semanticAnalyser);

        // interpret program
        program.accept(interpreter);
    }
}
