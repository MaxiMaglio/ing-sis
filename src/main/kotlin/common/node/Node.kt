package common.node

import common.ast.ASTNode
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
    val type: TokenType,
    var left: TreeNode? = null,
    var right: TreeNode? = null,
    private val headValue: String
) : Node, Comparable<TreeNode> {

    override fun getValue(): String {
        return headValue
    }

    override fun compareTo(other: TreeNode): Int {
        return headValue.compareTo(other.headValue)
    }
}


