package common.ast.implementation

import common.ast.AST
import common.ast.node.Node
import common.token.Token


/**
 * Propósito: Esta clase se enfoca específicamente en la asignación de un valor a una variable ya existente.
 * No maneja la declaración de la variable, asumiendo que la variable ya ha sido declarada en algún lugar del programa.
 *
 * Estructura: Contiene dos nodos principales: identifierLeafNode, que representa el identificador de la variable a la que se le asignará un valor, y valueNode, que representa el valor que se asignará a la variable.
 *
 * Cuándo se usa: Se utiliza cuando se necesita representar y analizar asignaciones que actualizan el valor de una variable existente, como IDENTIFIER = (LITERAL / EXPRESSION / ID);.
 */
class AssignationAST(private val tokens: List<Token>) :AST {


    override fun getChildren(): List<Node> {
        TODO("Not yet implemented")
    }

    override fun getTokensInLine(): List<Token> {
        TODO("Not yet implemented")
    }
}