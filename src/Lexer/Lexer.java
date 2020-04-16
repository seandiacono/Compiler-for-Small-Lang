package Lexer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.File;

public class Lexer {
    private static ArrayList<Character> inputChar = new ArrayList<>();

    private static int charCounter = 0;
    private static int lineCounter = 1;

    private static int[][] transitionTable = {
            {1, 2, -1, 5, 6, 7, 10, 11, 17, -1, -1},
            {1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, 9, 8, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, 8, -1, -1, -1, -1},
            {-1, -1, -1, 14, -1, -1, -1, 12, -1, -1, -1},
            {12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {14, 14, 14, 15, 14, 14, 14, 14, 14, 14, 14},
            {14, 14, 14, 15, 14, 14, 14, 16, 14, 14, 14},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
    };


    private static Set<String> keywords = new HashSet<>(Arrays.asList("float", "int", "bool", "auto", "true", "false", "and", "or", "not", "let", "print", "return", "if", "else", "for", "while", "ff"));
    private static Set<Integer> finalStates = new HashSet<>(Arrays.asList(1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 13, 16, 17));

    public static void readInput(String filename) {
        try {
            File f = new File("test.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int c = 0;
            while ((c = br.read()) != -1){
                inputChar.add((char) c);
            }
        } catch (Exception e) {
            System.out.println("An error occured when reading file.");
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private static Token getNextLexeme() {
        int currentState = 0;

        String lexeme = "";

        Stack<Integer> visitedStates = new Stack<>();

        // bad state
        visitedStates.push(-1);

        char currentChar;

        while (charCounter < inputChar.size() && (inputChar.get(charCounter) == ' ' || inputChar.get(charCounter) == '\t')){
            charCounter++;
        }


        do {
            currentChar = inputChar.get(charCounter);
            charCounter++;

            if(currentChar == 32 && (currentState != 14 && currentState != 15 && currentState != 12)){
                break;
            } else if ((currentChar == '\n' || currentChar == 13) && currentState != 12) {
                charCounter++;
                lineCounter++;
                continue;
            } else if ((currentChar == '\n' || currentChar == 13)){
                lineCounter++;
            } else if(currentChar == 32 || currentChar == '\t'){
                continue;
            }

            lexeme = lexeme + currentChar;
            currentState = getState(currentState, currentChar);

            if (finalStates.contains(currentState)) {
                while (!visitedStates.empty()) {
                    visitedStates.pop();
                }
            }

            visitedStates.push(currentState);
        } while (currentState != -1 && charCounter < inputChar.size());

        while (!finalStates.contains(currentState) && !visitedStates.empty()) {
            visitedStates.pop();
            try {
                lexeme = lexeme.substring(0, lexeme.length() - 1);
            } catch (StringIndexOutOfBoundsException e){
            }
            charCounter--;
            try {
                currentState = visitedStates.peek();
            } catch (EmptyStackException e){
                currentState = 0;
            }
        }

        if (finalStates.contains(currentState)) {
            Token token = new Token();
            token.lexeme = lexeme;
            switch (currentState) {
                case 1:

                    if(keywords.contains(lexeme)) {
                        switch (lexeme) {
                            case "and":
                                token.tokenIdentifier = token.tokenIdentifier.TOK_MULTIPLICATIONOP;
                                break;
                            case "or":
                                token.tokenIdentifier = token.tokenIdentifier.TOK_ADDITIONOP;
                                break;
                            case "true":
                            case "false":
                                token.tokenIdentifier = token.tokenIdentifier.TOK_BOOLEAN;
                                break;
                            case "float":
                                token.tokenIdentifier = token.tokenIdentifier.TOK_FLOATTYPE;
                                break;
                            case "int":
                                token.tokenIdentifier = token.tokenIdentifier.TOK_INTTYPE;
                                break;
                            case "bool":
                                token.tokenIdentifier = token.tokenIdentifier.TOK_BOOLTYPE;
                                break;
                            case "auto":
                                token.tokenIdentifier = token.tokenIdentifier.TOK_AUTOTYPE;
                                break;
                            case "not":
                                token.tokenIdentifier = token.tokenIdentifier.TOK_NOT;
                                break;
                            case "let":
                                token.tokenIdentifier = token.tokenIdentifier.TOK_LET;
                                break;
                            case "print":
                                token.tokenIdentifier = token.tokenIdentifier.TOK_PRINT;
                                break;
                            case "return":
                                token.tokenIdentifier = token.tokenIdentifier.TOK_RETURN;
                                break;
                            case "if":
                                token.tokenIdentifier = token.tokenIdentifier.TOK_IF;
                                break;
                            case "else":
                                token.tokenIdentifier = token.tokenIdentifier.TOK_ELSE;
                                break;
                            case "for":
                                token.tokenIdentifier = token.tokenIdentifier.TOK_FOR;
                                break;
                            case "while":
                                token.tokenIdentifier = token.tokenIdentifier.TOK_WHILE;
                                break;
                            case "ff":
                                token.tokenIdentifier = token.tokenIdentifier.TOK_FF;
                                break;
                        }
                    }else {
                        token.tokenIdentifier = token.tokenIdentifier.TOK_IDENTIFIER;
                    }
                    break;
                case 2:
                    token.tokenIdentifier = token.tokenIdentifier.TOK_INTEGER;
                    break;
                case 4:
                    token.tokenIdentifier = token.tokenIdentifier.TOK_FLOAT;
                    break;
                case 5:
                    token.tokenIdentifier = token.tokenIdentifier.TOK_MULTIPLICATIONOP;
                    break;
                case 6:
                    token.tokenIdentifier = token.tokenIdentifier.TOK_ADDITIONOP;
                    break;
                case 7:
                case 8:
                case 9:
                    token.tokenIdentifier = token.tokenIdentifier.TOK_RELATIONALOP;
                    break;
                case 10:
                    token.tokenIdentifier = token.tokenIdentifier.TOK_EQUALS;
                    break;
                case 11:
                    token.tokenIdentifier = token.tokenIdentifier.TOK_MULTIPLICATIONOP;
                    break;
                case 13:
                case 16:
                    token.tokenIdentifier = token.tokenIdentifier.TOK_COMMENT;
                case 17:
                    switch (lexeme){
                        case "{":
                            token.tokenIdentifier = token.tokenIdentifier.TOK_LEFTBRACE;
                            break;
                        case "}":
                            token.tokenIdentifier = token.tokenIdentifier.TOK_RIGHTBRACE;
                            break;
                        case "(":
                            token.tokenIdentifier = token.tokenIdentifier.TOK_LEFTBRACKET;
                            break;
                        case ")":
                            token.tokenIdentifier = token.tokenIdentifier.TOK_RIGHTBRACKET;
                            break;
                        case ":":
                            token.tokenIdentifier = token.tokenIdentifier.TOK_COLON;
                            break;
                        case ";":
                            token.tokenIdentifier = token.tokenIdentifier.TOK_SEMICOLON;
                            break;
                        case ",":
                            token.tokenIdentifier = token.tokenIdentifier.TOK_COMMA;
                            break;
                    }
                    break;
                default:
                    token.tokenIdentifier = token.tokenIdentifier.TOK_ERROR;
                    break;
            }
            token.lineNumber = lineCounter;
            return token;
        } else {
            System.out.println("Lexer found error at line: " + lineCounter);
            System.exit(1);
        }

        return null;
    }

    public static ArrayList<Token> getNextToken(){
        ArrayList<Token> tokens = new ArrayList<>();
        while (true) {
            Token token;
            try {
                token = getNextLexeme();
                if(token.tokenIdentifier != token.tokenIdentifier.TOK_COMMENT) {
                    tokens.add(token);
                }
            } catch (Exception e){
                token = new Token();
                token.tokenIdentifier = token.tokenIdentifier.TOK_EOF;
                tokens.add(token);
                break;
            }
        }
        return tokens;
    }

    private static int getState(int currentState, char currentChar) {
        return transitionTable[currentState][charToIndex(currentChar)];
    }

    private static int charToIndex(char currentChar) {
        if (Character.isDigit(currentChar)) return 1;
        else if (Character.isLetter(currentChar) || currentChar == '_') return 0;
        else if (currentChar == '.') return 2;
        else if (currentChar == '*') return 3;
        else if (currentChar == '+' || currentChar == '-') return 4;
        else if (currentChar == '<' || currentChar == '>') return 5;
        else if (currentChar == '=') return 6;
        else if (currentChar == '/') return 7;
        else if (currentChar == '(' || currentChar == ')' || currentChar == ':' || currentChar == ',' || currentChar == ';' || currentChar == '{' || currentChar == '}' )
            return 8;
        else if (currentChar == '\n' || currentChar == 13) return 10;
        else if (currentChar > 32 && currentChar < 126) return 9;
        else return -1;
    }
}
