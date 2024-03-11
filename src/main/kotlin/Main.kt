import lexer.Lexer

fun main() {

    val lexer = Lexer("123 + 456 - 789")
    val tokens = lexer.convertToToken()

    tokens.forEach { token ->
        println("Type: ${token.type}, Value: ${token.value}, Line: ${token.lineNumber}, Position: ${token.position}")
    }

    val lexer2 = Lexer("name = 'John'")
    val tokens2 = lexer2.convertToToken()
    tokens2.forEach { token ->
        println("Type: ${token.type}, Value: ${token.value}, Line: ${token.lineNumber}, Position: ${token.position}")
    }
}