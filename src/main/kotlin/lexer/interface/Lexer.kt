package lexer.`interface`

import common.token.Token

interface Lexer {

    fun extractTokens(): List<Token>
}