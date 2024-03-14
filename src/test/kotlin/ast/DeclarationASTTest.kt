package ast

import common.ast.implementation.DeclarationAST
import common.ast.node.LeafNode
import common.token.Token
import common.token.TokenType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeclarationASTTest {

    @Test
    fun `test getChildren returns correct nodes`() {
        val tokens = listOf(
            Token(TokenType.LET, "let", 1, 0),
            Token(TokenType.IDENTIFIER, "x", 1, 4),
            Token(TokenType.COLON, ":", 1, 6),
            Token(TokenType.TYPE, "Int", 1, 8),
            Token(TokenType.SEMICOLON, ";", 1, 11)
        )

        val declarationAST = DeclarationAST(tokens)
        val children = declarationAST.getChildren()

        assertEquals(5, children.size)

        assertEquals(TokenType.LET, (children[0]as LeafNode).type)
        assertEquals("let", (children[0]as LeafNode).value)

        assertEquals(TokenType.IDENTIFIER, (children[1]as LeafNode).type)
        assertEquals("x", (children[1]as LeafNode).value)

        assertEquals(TokenType.COLON, (children[2] as LeafNode).type)
        assertEquals(":", (children[2] as LeafNode).value)

        assertEquals(TokenType.TYPE, (children[3] as LeafNode).type)
        assertEquals("Int", (children[3] as LeafNode).value)

        assertEquals(TokenType.SEMICOLON, (children[4] as LeafNode).type)
        assertEquals(";", (children[4] as LeafNode).value)
    }

    @Test
    fun `test getTokensInLine returns correct tokens`() {
        val tokens = listOf(
            Token(TokenType.LET, "let", 1, 0),
            Token(TokenType.IDENTIFIER, "x", 1, 4),
            Token(TokenType.COLON, ":", 1, 6),
            Token(TokenType.TYPE, "Int", 1, 8),
            Token(TokenType.SEMICOLON, ";", 1, 11)
        )

        val declarationAST = DeclarationAST(tokens)
        val returnedTokens = declarationAST.getTokensInLine()

        assertEquals(tokens, returnedTokens)
    }
}
