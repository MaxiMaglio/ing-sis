package interpreter

import common.ast.implementation.AssignationAST
import common.token.Token
import common.token.TokenType
import interpreter.implementation.AssignationInterpreter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AssignationInterpreterTest {
    /*
    @Test
    fun testInterpretation() {
        // Tokens para la asignación: x = 10;
        val tokens = listOf(
            Token(TokenType.IDENTIFIER, "x"),
            Token(TokenType.ASSIGN, "="),
            Token(TokenType.LITERAL, "10"),
            Token(TokenType.SEMICOLON, ";")
        )

        val ast = AssignationAST(tokens)

        val interpreter = AssignationInterpreter()
        interpreter.interpret(ast)

        assertEquals(10, interpreter.variables["x"])
    }

 */

}