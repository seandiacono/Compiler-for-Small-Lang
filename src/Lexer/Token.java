package Lexer;

public class Token {
    public enum  tokenIdentifier {
        TOK_IDENTIFIER, //S1
        TOK_INTEGER, //S2
        TOK_FLOAT, //S4
        TOK_ADDITIONOP, //S6
        TOK_MULTIPLICATIONOP, //S5
        TOK_BOOLEAN,
        TOK_EQUALS,
        TOK_FLOATTYPE,
        TOK_INTTYPE,
        TOK_BOOLTYPE,
        TOK_AUTOTYPE,
        TOK_NOT,
        TOK_LET,
        TOK_PRINT,
        TOK_RETURN,
        TOK_IF,
        TOK_ELSE,
        TOK_FOR,
        TOK_WHILE,
        TOK_FF,
        TOK_RELATIONALOP,
        TOK_LEFTBRACE,
        TOK_RIGHTBRACE,
        TOK_LEFTBRACKET,
        TOK_RIGHTBRACKET,
        TOK_COMMA,
        TOK_SEMICOLON,
        TOK_COLON,
        TOK_COMMENT,
        TOK_ERROR,
        TOK_EOF
    }

    public tokenIdentifier tokenIdentifier;
    public String lexeme;
    public int lineNumber;
}
