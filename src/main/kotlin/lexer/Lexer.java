package lexer;

import common.token.Token;

import java.util.List;

/**
 * identifies the lexical elements of the language and converts them into tokens
*/

public interface Lexer {

    //deberia recibir lo que lee que tenga el codigo, un arhcivo?
    fun extractTokens(): List<Token>


}
