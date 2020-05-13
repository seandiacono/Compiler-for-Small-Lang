import Parser.AstNodes.AstProgramNode;
import Parser.Parser;

import java.util.ArrayList;

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
        ArrayList<Token> tokens = new ArrayList<>();

        Lexer.readInput("C:/Users/seand/OneDrive/Documents/University/Compiler Theory/Compiler-for-Small-Lang/test.txt");
        tokens = Lexer.getNextToken();
        for (Token token : tokens) {
            System.out.println(token.tokenIdentifier);
        }
        // AstProgramNode program = parser.parse();

        // // produce xml ast
        // program.accept(xmlVisitor);

        // // check semantics
        // program.accept(semanticAnalyser);

        // // interpret program
        // program.accept(interpreter);
    }
}
