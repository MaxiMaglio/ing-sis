package common.ast.node

import common.token.TokenType

data class LeafNode (
    val type: TokenType,
    val value: String )
    : Node {

    override fun getNodeValue(): String {
        return value
    }
}