import common.ast.AST
import common.node.TreeNode
import common.token.Token
import common.token.TokenType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
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

        // Verificar que el AST se haya generado correctamente
        val expectedAST = AST(TreeNode(TokenType.LET, null, null, "LET"))
        val rootNode = expectedAST.getRootNode()
        rootNode?.left = TreeNode(TokenType.IDENTIFIER, null, null, "x")
        rootNode?.right = TreeNode(TokenType.NUMBER_TYPE, null, null, "number")

        assertEquals(expectedAST, ast, "El AST generado no es el esperado")
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
        assertEquals(true, exceptionThrown, "Se esperaba una excepción al encontrar un token inválido")
    }
}
