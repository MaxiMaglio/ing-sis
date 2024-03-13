import common.ast.implementation.AssignationAST
import common.token.Token
import common.token.TokenType
import lexer.implementation.Lexer

fun main() {

//    val lexer = Lexer("123 + 456 - 789")
//    val tokens = lexer.convertToToken()
//
//    tokens.forEach { token ->
//        println("Type: ${token.type}, Value: ${token.value}, Line: ${token.lineNumber}, Position: ${token.position}")
//    }

    val lexer2 = Lexer("let number: Int = 2")
    val tokens2 = lexer2.convertToToken()
    tokens2.forEach { token ->
        println("Type: ${token.type}, Value: ${token.value}, Line: ${token.lineNumber}, Position: ${token.position}")
    }

    val tokens = listOf(
        Token(TokenType.IDENTIFIER, "x", 0, 0),
        Token(TokenType.EQUALS, "=", 0, 1),
        Token(TokenType.NUMERIC_LITERAL, "5", 0, 2),
        Token(TokenType.SEMICOLON, ";", 0, 3)
    )

    val assignationAST = AssignationAST(tokens)

    val children = assignationAST.getChildren()
    println("Hijos del nodo de asignación:")
    children.forEach { println(it) }

    val tokensInLine = assignationAST.getTokensInLine()
    println("\nTokens en la línea:")
    tokensInLine.forEach { println(it) }
}