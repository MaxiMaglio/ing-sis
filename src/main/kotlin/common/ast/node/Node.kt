package common.ast.node

import common.token.TokenType

interface Node {
    fun getValue(): String
}

data class LeafNode (val type: TokenType, private val value: String )  : Node {
    override fun getValue(): String {
        return value
    }
}

data class TreeNode(
    val type: TokenType, val left: TreeNode? = null, val right: TreeNode? = null, private val headValue: String)  : Node{
    override fun getValue(): String {
        return headValue;
    }
}