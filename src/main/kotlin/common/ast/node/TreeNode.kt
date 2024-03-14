package common.ast.node

import common.token.TokenType

data class TreeNode(
    val type: TokenType,
    val left: TreeNode? = null,
    val right: TreeNode? = null,
    val headValue: String
)  : Node{

    override fun getNodeValue(): String {
        return headValue;
    }
}