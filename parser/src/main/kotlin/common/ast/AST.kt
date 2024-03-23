package common.ast

import common.node.TreeNode

sealed interface ASTNode // Cuando el nodo puede representar declaraciones, expresiones, o instrucciones

sealed interface Assignation : ASTNode // Cuando el nodo representa asignaciones

sealed interface BinaryNode // Cuando el nodo puede representar operaciones binarias

data class Declaration(val identifier: String, val type: String) : ASTNode

data class DeclarationAssignation(val declaration: Declaration, val assignation: BinaryNode) : Assignation

data class SimpleAssignation(val identifier: String, val assignation: BinaryNode) : Assignation

data class Method(val identifier: String, val value: BinaryNode) : ASTNode

data class BinaryOperation(val left: BinaryNode, val symbol: String, val right: BinaryNode) : BinaryNode

data class StringOperator(val value: String) : BinaryNode

data class NumberOperator(val value: Double) : BinaryNode

data class IdentifierOperator(val identifier: String) : BinaryNode

class AST(private val root: TreeNode?) {
    fun getRootNode(): TreeNode? {
        return root
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is AST) return false

        return root == other.root
    }

    override fun hashCode(): Int {
        return root?.hashCode() ?: 0
    }
}