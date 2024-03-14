package common.token

enum class TokenType {

    IDENTIFIER, //variable name

    //keywords
    LET,
    PRINTLN,
    IF,
    ELSE,
    WHILE,
    RETURN,
    FINAL,
    PUBLIC,
    PRIVATE,
    PROTECTED,

    //types
    STRING_TYPE,
    NUMBER_TYPE,

    //declarations (values)
    NUMERIC_LITERAL,
    STRING_LITERAL,

    //operators
    EQUALS,
    PLUS,
    MINUS,
    TIMES,
    DIVIDED_BY,
    GREATER_THAN,
    LESSER_THAN,

    //symbols
    OPEN_PARENTHESIS,
    CLOSE_PARENTHESIS,
    SEMICOLON,
    COLON,
    WHITESPACE,
    ASSIGN,
    LITERAL;


}