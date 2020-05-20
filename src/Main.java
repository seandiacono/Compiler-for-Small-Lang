import Parser.AstNodes.AstProgramNode;
import Parser.Parser;

import java.io.IOException;
import java.util.ArrayList;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import Lexer.*;
import Visitor.InterpreterVisitor;
import Visitor.SemanticAnalyser;
import Visitor.XmlVisitor;
import Antlr.AntlrSmallLangV1.*;

public class Main {
    public static void main(String args[]) {
        Parser parser = new Parser();
        XmlVisitor xmlVisitor = new XmlVisitor();
        SemanticAnalyser semanticAnalyser = new SemanticAnalyser();
        InterpreterVisitor interpreter = new InterpreterVisitor();
        ArrayList<Token> tokens = new ArrayList<>();

        try {
            CharStream charStream = CharStreams.fromFileName(
                    "C:/Users/seand/OneDrive/Documents/University/Compiler Theory/Compiler-for-Small-Lang/test.txt");
            SmallLangV1Lexer lexer = new SmallLangV1Lexer(charStream);
            SmallLangV1Parser parserAntlr = new SmallLangV1Parser(new CommonTokenStream(lexer));

            AstProgramNode program = (AstProgramNode) new HybridParserVisitor().visit(parserAntlr.prog());

            program.accept(xmlVisitor);

            // check semantics
            program.accept(semanticAnalyser);

            // interpret program
            program.accept(interpreter);

        } catch (IOException e) {
            System.out.println("Error Reading file");
            System.exit(1);
        }

        // Lexer.readInput(
        // "C:/Users/seand/OneDrive/Documents/University/Compiler
        // Theory/Compiler-for-Small-Lang/test.txt");
        // tokens = Lexer.getNextToken();
        // for (Token token : tokens) {
        // System.out.println(token.lexeme+" : "+token.tokenIdentifier);
        // }
        // AstProgramNode program = parser.parse();

        // // produce xml ast
        // program.accept(xmlVisitor);

        // // check semantics
        // program.accept(semanticAnalyser);

        // // interpret program
        // program.accept(interpreter);
    }
}
