import Parser.AstNodes.AstProgramNode;
import Parser.Parser;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import Lexer.*;
import Visitor.InterpreterVisitor;
import Visitor.SemanticAnalyser;
import Visitor.XmlVisitor;
import Antlr.AntlrSmallLangV1.*;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Parser parser = new Parser();
        XmlVisitor xmlVisitor = new XmlVisitor();
        SemanticAnalyser semanticAnalyser = new SemanticAnalyser();
        InterpreterVisitor interpreter = new InterpreterVisitor();
        Scanner sc = new Scanner(System.in);

        System.out.println("********* SmallLang Compiler 2 *********");
        System.out.println("Enter Path to Program Text File:");
        String filePath = sc.nextLine();
        sc.close();

        // * USING ANTLR FOR SMALL LANG V1
        try {
            // use antlr's generated lexer and parser
            CharStream charStream = CharStreams.fromFileName(filePath);
            SmallLangV1Lexer lexer = new SmallLangV1Lexer(charStream);
            SmallLangV1Parser parserAntlr = new SmallLangV1Parser(new CommonTokenStream(lexer));

            // cast result to AstProgramNode
            AstProgramNode program = (AstProgramNode) new HybridParserVisitor().visit(parserAntlr.prog());

            System.out.println("********* XML Output *********");
            program.accept(xmlVisitor);

            // check semantics
            program.accept(semanticAnalyser);

            // interpret program
            System.out.println("********* Interpreter Output *********");
            program.accept(interpreter);

        } catch (IOException e) {
            System.out.println("Error Reading file");
            System.exit(1);
        }

        // * USING HAND_CRAFTED LEXER AND PARSER FOR SMALL LANG V2
        // Lexer.readInput(filePath);
        // AstProgramNode program = parser.parse();

        // produce xml ast
        // System.out.println("********* XML Output *********");
        // program.accept(xmlVisitor);

        // check semantics
        // program.accept(semanticAnalyser);

        // interpret program
        // System.out.println("********* Interpreter Output *********");
        // program.accept(interpreter);
    }
}
