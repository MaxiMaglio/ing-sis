package common.ast.implementation

import common.ast.AST
import common.ast.node.LeafNode
import common.ast.node.Node
import common.ast.node.TreeNode
import common.token.Token

/**
 * Propósito: Esta clase se enfoca específicamente en la asignación de un valor a una variable ya existente.
 * No maneja la declaración de la variable, asumiendo que la variable ya ha sido declarada en algún lugar del programa.
 *
 * Estructura: Contiene dos nodos principales: identifierLeafNode, que representa el identificador de la variable a la que se le asignará un valor, y valueNode, que representa el valor que se asignará a la variable.
 *
 * Cuándo se usa: Se utiliza cuando se necesita representar y analizar asignaciones que actualizan el valor de una variable existente, como IDENTIFIER = (LITERAL / EXPRESSION / ID);.
 *
 * Ejemplo: x = 5;
 */

class AssignationAST(private val tokens: List<Token>) :AST {

    override fun getChildren(): List<Node> {
        // Asumo que el primer token es el identifier y el ultimo el punto y coma
        val identifierToken = tokens.first()
        val valueTokens = tokens.drop(1).dropLast(2) // Todos los tokens menos el identificador, el velue y el punto y coma
        val valueToken = tokens.dropLast(1).last() // El último token antes del punto y coma va a ser el valor

        val identifierNode = LeafNode(identifierToken.type, identifierToken.value)
        val valueNode = TreeNode(valueToken.type, null, null, valueToken.value)


        return listOf(identifierNode, valueNode)
    }

    override fun getTokensInLine(): List<Token> {
        return tokens
    }
}