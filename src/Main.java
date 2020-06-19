import Parser.AstNodes.AstProgramNode;
import Parser.Parser;
import Lexer.*;
import Visitor.InterpreterVisitor;
import Visitor.SemanticAnalyser;
import Visitor.XmlVisitor;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Parser parser = new Parser();
        XmlVisitor xmlVisitor = new XmlVisitor();
        SemanticAnalyser semanticAnalyser = new SemanticAnalyser();
        InterpreterVisitor interpreter = new InterpreterVisitor();
        Scanner sc = new Scanner(System.in);

        System.out.println("********* SmallLang Compiler *********");
        System.out.println("Enter Path to Program Text File:");
        String filePath = sc.nextLine();
        sc.close();

        Lexer.readInput(filePath);
        AstProgramNode program = parser.parse();

        // produce xml ast
        System.out.println("********* XML Output *********");
        program.accept(xmlVisitor);

        // check semantics
        program.accept(semanticAnalyser);

        // interpret program
        System.out.println("********* Interpreter Output *********");
        program.accept(interpreter);

    }
}
