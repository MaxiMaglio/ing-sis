package common.ast.implementation

import common.ast.AST
import common.ast.node.Node
import common.token.Token

class EmptyAST : AST {
    override fun getChildren(): List<Node> =
        emptyList<Node>()

    override fun getTokensInLine(): List<Token> =
        emptyList<Token>()
}