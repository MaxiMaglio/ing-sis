package parser

import common.ast.*
import common.token.Token
import common.token.TokenType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ParserTest {

    @Test
    fun testGenerateAST() {
        // Definir los tokens de prueba
        val tokens = listOf(
            Token(TokenType.LET, "let", 1),
            Token(TokenType.IDENTIFIER, "x", 1),
            Token(TokenType.COLON, ":", 1),
            Token(TokenType.NUMBER_TYPE, "number", 1),
            Token(TokenType.EQUALS, "=", 1),
            Token(TokenType.NUMERIC_LITERAL, "10", 1),
            Token(TokenType.SEMICOLON, ";", 1),
            Token(TokenType.PRINTLN, "println", 2),
            Token(TokenType.OPEN_PARENTHESIS, "(", 2),
            Token(TokenType.STRING_LITERAL, "Hello, world!", 2),
            Token(TokenType.CLOSE_PARENTHESIS, ")", 2),
            Token(TokenType.SEMICOLON, ";", 2)
        )

        val parser = Parser(tokens)

        val astNodes = parser.generateAST()

        // Verificar el AST generado
        assertEquals(2, astNodes.size)

        // Verifico la declaration
        val declarationAssignation = astNodes[0] as DeclarationAssignation
        assertEquals("x", declarationAssignation.declaration.identifier)
        assertEquals("number", declarationAssignation.declaration.type)
        assertEquals(NumberOperator(10.0), declarationAssignation.assignation)

        // Verifico el print
        val printlnStatement = astNodes[1] as Method
        assertEquals("println", printlnStatement.identifier)
        assertEquals(StringOperator("Hello, world!"), printlnStatement.value)
    }
}
