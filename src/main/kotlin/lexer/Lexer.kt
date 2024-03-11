package lexer

import common.token.Token
import common.token.TokenType
import java.util.*

class Lexer(private val input: String) {

    private var position: Int = 0; //posicion en el string
    private var lineNumber: Int = 1; //la linea, en general siempre hay una sola


    //TODO DIFERENCIAR ENTRE STRING_LITERAL Y IDENTIFIERSS
    //TODO TAMBIEN LAS KEYWORDS
    fun convertToToken(): List<Token>{
        val tokens = mutableListOf<Token>()

        while (position < input.length){
            val currentChar = input[position]

            when (currentChar){
                ' ', '\t', '\n', '\r'-> {
                    tokens.add(Token(TokenType.WHITESPACE, currentChar.toString(), lineNumber, position + 1))
                    position++
                }
                '+'-> {
                    tokens.add(Token(TokenType.PLUS, currentChar.toString(), lineNumber, position + 1))
                    position++
                }
                '-'-> {
                    tokens.add(Token(TokenType.MINUS, currentChar.toString(), lineNumber, position + 1))
                    position++
                }
                '*'-> {
                    tokens.add(Token(TokenType.TIMES, currentChar.toString(), lineNumber, position + 1))
                    position++
                }
                '/'-> {
                    tokens.add(Token(TokenType.DIVIDED_BY, currentChar.toString(), lineNumber, position + 1))
                    position++
                }
                '='-> {
                    tokens.add(Token(TokenType.EQUALS, currentChar.toString(), lineNumber, position + 1))
                    position++
                }
                ';'-> {
                    tokens.add(Token(TokenType.SEMICOLON, currentChar.toString(), lineNumber, position + 1))
                    position++
                }
                ':', ','-> {
                    tokens.add(Token(TokenType.COLON, currentChar.toString(), lineNumber, position + 1))
                    position++
                }
                '>'-> {
                    tokens.add(Token(TokenType.GREATER_THAN, currentChar.toString(), lineNumber, position + 1))
                    position++
                }
                '<'-> {
                    tokens.add(Token(TokenType.LESSER_THAN, currentChar.toString(), lineNumber, position + 1))
                    position++
                }
                '('-> {
                    tokens.add(Token(TokenType.OPEN_PARENTHESIS, currentChar.toString(), lineNumber, position + 1))
                    position++
                }
                ')' -> {
                    tokens.add(Token(TokenType.CLOSE_PARENTHESIS, currentChar.toString(), lineNumber, position + 1))
                    position++
                }
                else -> {
                    if (currentChar.isDigit()) {
                        val start = position
                        while (position < input.length && input[position].isDigit()) {
                            position++
                        }
                        tokens.add(Token(TokenType.NUMBER_TYPE, input.substring(start, position), lineNumber, start + 1))
                    } else if (currentChar.isLetter()) {
                        val start = position
                        while (position < input.length && input[position].isLetterOrDigit()) {
                            position++
                        }
                        tokens.add(Token(TokenType.IDENTIFIER, input.substring(start, position), lineNumber, start + 1))
                    }else {
                        tokens.add(Token(TokenType.UNKNOWN, currentChar.toString(), lineNumber, position + 1))
                        position++
                    }
                }
            }

        }
        return tokens
    }

}