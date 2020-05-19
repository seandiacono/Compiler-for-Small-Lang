package Lexer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

import Lexer.Token.tokenIdentifier;

import java.io.File;

public class Lexer {
    // list of characters in the program
    private static ArrayList<Character> inputChar = new ArrayList<>();

    // character counter
    private static int charCounter = 0;
    // line number counter
    private static int lineCounter = 1;

    // state transition table
    private static int[][] transitionTable = { 
            { 1, 2, -1, 5, 6, 7, 10, 11, 17, -1, -1, 18},
            { 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            { -1, 2, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            { -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            { -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            { -1, -1, -1, -1, -1, 9, 8, -1, -1, -1, -1, -1},
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            { -1, -1, -1, -1, -1, -1, 8, -1, -1, -1, -1, -1},
            { -1, -1, -1, 14, -1, -1, -1, 12, -1, -1, -1, -1},
            { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, -1},
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            { 14, 14, 14, 15, 14, 14, 14, 14, 14, 14, 14, -1},
            { 14, 14, 14, 15, 14, 14, 14, 16, 14, 14, 14, -1},
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,},
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,},
            { -1, 18, -1, -1, -1, -1, -1, -1, -1, 18, -1, 19,},
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,},};

    // set of keywords in small lang
    private static Set<String> keywords = new HashSet<>(Arrays.asList("float", "int", "bool", "auto", "true", "false",
            "and", "or", "not", "let", "print", "return", "if", "else", "for", "while", "ff", "char"));
    // list of end states
    private static Set<Integer> finalStates = new HashSet<>(
            Arrays.asList(1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 13, 16, 17, 19, 21));

    /**
     * [readInput reads the content of a text file and adds all the characters to
     * the char array]
     */
    public static void readInput(String filename) {
        try {
            File f = new File(filename);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int c = 0;
            while ((c = br.read()) != -1) {
                inputChar.add((char) c);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("An error occured when reading file.");
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    /**
     * [tokenize goes through the char array and returns the next token found]
     * 
     * @return Token [this is the token found during tokenization]
     */
    private static Token tokenize() {
        int currentState = 0;

        String lexeme = "";

        Stack<Integer> visitedStates = new Stack<>();

        visitedStates.push(-1);

        char currentChar;
        // ignore all trailing white spaces
        while (charCounter < inputChar.size()
                && (inputChar.get(charCounter) == ' ' || inputChar.get(charCounter) == '\t')) {
            charCounter++;
        }

        // do until an erro state is reached or until the whole program has been read
        do {
            currentChar = inputChar.get(charCounter);
            charCounter++;

            // ignore white spaces and count new lines.
            // TODO: fix inline comment on last line bug
            if (currentChar == 32 && (currentState != 14 && currentState != 15 && currentState != 12)) {
                break;
            } else if ((currentChar == '\n' || currentChar == 13) && currentState != 12) {
                lineCounter++;
                continue;
            } else if ((currentChar == '\n' || currentChar == 13)) {
                lineCounter++;
            } else if (currentChar == 32 || currentChar == '\t') {
                continue;
            }

            lexeme = lexeme + currentChar;
            currentState = getState(currentState, currentChar);

            // empty visited states stack if the current state is a final state
            if (finalStates.contains(currentState)) {
                while (!visitedStates.empty()) {
                    visitedStates.pop();
                }
            }
            // push current state to the stack
            visitedStates.push(currentState);
        } while (currentState != -1 && charCounter < inputChar.size());

        // rollback loop until a final state is reached or until the visited states
        // stack is empty
        while (!finalStates.contains(currentState) && !visitedStates.empty()) {
            visitedStates.pop();
            // truncate lexeme
            try {
                lexeme = lexeme.substring(0, lexeme.length() - 1);
            } catch (StringIndexOutOfBoundsException e) {
            }
            charCounter--;
            try {
                currentState = visitedStates.peek();
            } catch (EmptyStackException e) {
                currentState = 0;
            }
        }

        // return correct token
        if (finalStates.contains(currentState)) {
            Token token = new Token();
            token.lexeme = lexeme;
            switch (currentState) {
                case 1:
                    // if the lexeme is a keyword return the associated token or else return the
                    // identifier token
                    if (keywords.contains(lexeme)) {
                        switch (lexeme) {
                            case "and":
                                token.tokenIdentifier = tokenIdentifier.TOK_MULTIPLICATIONOP;
                                break;
                            case "or":
                                token.tokenIdentifier = tokenIdentifier.TOK_ADDITIONOP;
                                break;
                            case "true":
                            case "false":
                                token.tokenIdentifier = tokenIdentifier.TOK_BOOLEAN;
                                break;
                            case "float":
                                token.tokenIdentifier = tokenIdentifier.TOK_FLOATTYPE;
                                break;
                            case "int":
                                token.tokenIdentifier = tokenIdentifier.TOK_INTTYPE;
                                break;
                            case "bool":
                                token.tokenIdentifier = tokenIdentifier.TOK_BOOLTYPE;
                                break;
                            case "char":
                                token.tokenIdentifier = tokenIdentifier.TOK_CHARTYPE;
                                break;
                            case "auto":
                                token.tokenIdentifier = tokenIdentifier.TOK_AUTOTYPE;
                                break;
                            case "not":
                                token.tokenIdentifier = tokenIdentifier.TOK_NOT;
                                break;
                            case "let":
                                token.tokenIdentifier = tokenIdentifier.TOK_LET;
                                break;
                            case "print":
                                token.tokenIdentifier = tokenIdentifier.TOK_PRINT;
                                break;
                            case "return":
                                token.tokenIdentifier = tokenIdentifier.TOK_RETURN;
                                break;
                            case "if":
                                token.tokenIdentifier = tokenIdentifier.TOK_IF;
                                break;
                            case "else":
                                token.tokenIdentifier = tokenIdentifier.TOK_ELSE;
                                break;
                            case "for":
                                token.tokenIdentifier = tokenIdentifier.TOK_FOR;
                                break;
                            case "while":
                                token.tokenIdentifier = tokenIdentifier.TOK_WHILE;
                                break;
                            case "ff":
                                token.tokenIdentifier = tokenIdentifier.TOK_FF;
                                break;
                        }
                    } else {
                        token.tokenIdentifier = tokenIdentifier.TOK_IDENTIFIER;
                    }
                    break;
                case 2:
                    token.tokenIdentifier = tokenIdentifier.TOK_INTEGER;
                    break;
                case 4:
                    token.tokenIdentifier = tokenIdentifier.TOK_FLOAT;
                    break;
                case 5:
                    token.tokenIdentifier = tokenIdentifier.TOK_MULTIPLICATIONOP;
                    break;
                case 6:
                    token.tokenIdentifier = tokenIdentifier.TOK_ADDITIONOP;
                    break;
                case 7:
                case 8:
                case 9:
                    token.tokenIdentifier = tokenIdentifier.TOK_RELATIONALOP;
                    break;
                case 10:
                    token.tokenIdentifier = tokenIdentifier.TOK_EQUALS;
                    break;
                case 11:
                    token.tokenIdentifier = tokenIdentifier.TOK_MULTIPLICATIONOP;
                    break;
                case 13:
                case 16:
                    token.tokenIdentifier = tokenIdentifier.TOK_COMMENT;
                case 17:
                    switch (lexeme) {
                        case "{":
                            token.tokenIdentifier = tokenIdentifier.TOK_LEFTBRACE;
                            break;
                        case "}":
                            token.tokenIdentifier = tokenIdentifier.TOK_RIGHTBRACE;
                            break;
                        case "(":
                            token.tokenIdentifier = tokenIdentifier.TOK_LEFTBRACKET;
                            break;
                        case ")":
                            token.tokenIdentifier = tokenIdentifier.TOK_RIGHTBRACKET;
                            break;
                        case ":":
                            token.tokenIdentifier = tokenIdentifier.TOK_COLON;
                            break;
                        case ";":
                            token.tokenIdentifier = tokenIdentifier.TOK_SEMICOLON;
                            break;
                        case ",":
                            token.tokenIdentifier = tokenIdentifier.TOK_COMMA;
                            break;
                        case "[":
                            token.tokenIdentifier = tokenIdentifier.TOK_LEFTSQUARE;
                            break;
                        case "]":
                            token.tokenIdentifier = tokenIdentifier.TOK_RIGHTSQUARE;
                            break;
                    }
                    break;
                case 19:
                    token.tokenIdentifier = tokenIdentifier.TOK_CHAR;
                    break;
                default:
                    token.tokenIdentifier = tokenIdentifier.TOK_ERROR;
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

    /**
     * [getNextToken is used by the parser to return the sequence of all the tokens
     * in the program]
     * 
     * @return ArrayList<Token> [this is the sequence of all the tokens in the
     *         program]
     */
    public static ArrayList<Token> getNextToken() {
        ArrayList<Token> tokens = new ArrayList<>();
        while (true) {
            Token token;
            try {
                token = tokenize();
                if (token.tokenIdentifier != tokenIdentifier.TOK_COMMENT) {
                    tokens.add(token);
                }
            } catch (Exception e) {
                token = new Token();
                token.tokenIdentifier = tokenIdentifier.TOK_EOF;
                tokens.add(token);
                break;
            }
        }
        return tokens;
    }

    /**
     * [getState takes a state and character and returns the next state]
     *
     * @param int  currentState [currentState is the state the lexer is currently
     *             at]
     * @param char currentChar [currentChar is the new character read by the lexer]
     *
     * @return int [returns the state from the state transition table]
     */
    private static int getState(int currentState, char currentChar) {
        return transitionTable[currentState][charToIndex(currentState, currentChar)];
    }

    /**
     * [charToIndex takes a character and returns the column index of that character
     * in the transition table]
     *
     * @param char currentChar [currentChar is the new character read by the lexer]
     *
     * @return int [returns the column index in the transition table]
     */
    private static int charToIndex(int currentState, char currentChar) {
        if (Character.isDigit(currentChar))
            return 1;
        else if (Character.isLetter(currentChar) || currentChar == '_') {
            if (currentState == 18) {
                return 9;
            }
            return 0;
        } else if (currentChar == '.')
            return 2;
        else if (currentChar == '*')
            return 3;
        else if (currentChar == '+' || currentChar == '-')
            return 4;
        else if (currentChar == '<' || currentChar == '>')
            return 5;
        else if (currentChar == '=')
            return 6;
        else if (currentChar == '/')
            return 7;
        else if (currentChar == '(' || currentChar == ')' || currentChar == ':' || currentChar == ','
                || currentChar == ';' || currentChar == '{' || currentChar == '}' || currentChar == '[' || currentChar == ']')
            return 8;
        else if (currentChar == '\'')
            return 11;
        else if (currentChar == '\n' || currentChar == 13)
            return 10;
        else if (currentChar > 32 && currentChar < 126) {
            // all printable ASCII characters
            return 9;
        } else
            return -1;
    }
}
