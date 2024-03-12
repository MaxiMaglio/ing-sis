package common.ast.implementation

import common.ast.AST
import common.ast.node.Node
import common.token.Token

class FunctionAST(private val tokens: List<Token>) : AST {


    /**
     * TOKEN TYPES
     *     OPERATOR,
     *     OPEN_PARENTHESIS,
     *     CLOSE_PARENTHESIS,
     *     IDENTIFIER,
     *     NUMERIC_LITERAL,
     *     STRING_LITERAL
     */

    override fun getChildren(): List<Node> {
        TODO("Not yet implemented")
    }

    override fun getTokensInLine(): List<Token> {
        TODO("Not yet implemented")
    }
}