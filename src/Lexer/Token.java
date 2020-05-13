package Lexer;

public class Token {
    // token type
    public enum tokenIdentifier {
        TOK_IDENTIFIER, TOK_INTEGER, TOK_FLOAT, TOK_ADDITIONOP, TOK_MULTIPLICATIONOP, TOK_BOOLEAN, TOK_EQUALS,
        TOK_FLOATTYPE, TOK_INTTYPE, TOK_BOOLTYPE, TOK_AUTOTYPE, TOK_NOT, TOK_LET, TOK_PRINT, TOK_RETURN, TOK_IF,
        TOK_ELSE, TOK_FOR, TOK_WHILE, TOK_FF, TOK_RELATIONALOP, TOK_LEFTBRACE, TOK_RIGHTBRACE, TOK_LEFTBRACKET,
        TOK_RIGHTBRACKET, TOK_COMMA, TOK_SEMICOLON, TOK_COLON, TOK_COMMENT, TOK_ERROR, TOK_EOF, TOK_CHAR, TOK_CHARTYPE
    }

    public tokenIdentifier tokenIdentifier;
    public String lexeme;
    public int lineNumber;
}
