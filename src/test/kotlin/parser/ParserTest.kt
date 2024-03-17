import common.ast.AST
import common.node.TreeNode
import common.token.Token
import common.token.TokenType
import org.junit.jupiter.api.Assertions.assertTrue
import org.testng.annotations.Test
import parser.Parser

class ParserTest {

    @Test
    fun testGenerateAST() {
        val tokens = listOf(
            Token(TokenType.LET, "let", 1),
            Token(TokenType.IDENTIFIER, "x", 2),
            Token(TokenType.COLON, ":", 3),
            Token(TokenType.NUMBER_TYPE, "number", 4),
            Token(TokenType.SEMICOLON, ";", 5)
        )

        val parser = Parser(tokens)
        val ast = parser.generateAST()

        // Aquí puedes realizar las aserciones necesarias para verificar si el AST se genera correctamente
        // Por ejemplo, verificar el tipo y el valor de los nodos en el AST.
    }

    @Test
    fun testInvalidToken() {
        val tokens = listOf(
            Token(TokenType.LET, "let", 1),
            Token(TokenType.IDENTIFIER, "x", 2),
            Token(TokenType.COLON, ":", 3),
            Token(TokenType.NUMBER_TYPE, "number", 4),
            Token(TokenType.EQUALS, "=", 5),
            Token(TokenType.INVALID, "$$$", 6) // Token inválido
        )

        // Verificar que el parser arroje una excepción cuando se encuentra con un token inválido
        val parser = Parser(tokens)
        var exceptionThrown = false
        try {
            parser.generateAST()
        } catch (e: RuntimeException) {
            exceptionThrown = true
        }
        assertTrue(exceptionThrown, "Se esperaba una excepción al encontrar un token inválido")
    }
}
