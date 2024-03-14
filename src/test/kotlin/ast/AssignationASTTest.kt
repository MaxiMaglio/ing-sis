package ast

import common.ast.implementation.AssignationAST
import common.ast.node.LeafNode
import common.ast.node.TreeNode
import common.token.Token
import common.token.TokenType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AssignationASTTest {

    @Test
    fun `test getChildren returns correct nodes`() {
        val tokens = listOf(
            Token(TokenType.IDENTIFIER, "x", 1, 0),
            Token(TokenType.EQUALS, "=", 1, 1),
            Token(TokenType.NUMERIC_LITERAL, "5", 1, 2),
            Token(TokenType.SEMICOLON, ";", 1, 2)
        )

        val assignationAST = AssignationAST(tokens)

        val children = assignationAST.getChildren()
        assertEquals(2, children.size)
        assertEquals("x", (children[0] as LeafNode).getValue())
        assertEquals("5", (children[1] as TreeNode).getValue())
    }

    @Test
    fun `test getTokensInLine returns correct tokens`() {
        val tokens = listOf(
            Token(TokenType.IDENTIFIER, "x", 1, 0),
            Token(TokenType.EQUALS, "=", 1, 1),
            Token(TokenType.NUMERIC_LITERAL, "5", 1, 2),
            Token(TokenType.SEMICOLON, ";", 1, 2)
        )

        val assignationAST = AssignationAST(tokens)

        val returnedTokens = assignationAST.getTokensInLine()
        assertEquals(tokens, returnedTokens)
    }
}
