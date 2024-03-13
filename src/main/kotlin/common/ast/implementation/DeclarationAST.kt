package common.ast.implementation

import common.ast.AST
import common.ast.node.LeafNode
import common.ast.node.Node
import common.token.Token

/**
 * DeclarationAST se enfoca exclusivamente en la declaración de una variable, sin asignarle un valor inicial.
 * Es útil para contextos donde solo se necesita declarar una variable y su tipo de dato, sin asignarle un valor.
 * representar una declaración de variable en un lenguaje de programación. Esta clase se utiliza para analizar y representar declaraciones como LET ID : TYPE;, donde LET es la palabra clave para declarar una variable, ID es el identificador de la variable, y TYPE es el tipo de dato de la variable.
 */
class DeclarationAST(private val tokens: List<Token>) :AST {

    /**
     * TOKEN TYPES
     *    LET,
     *    IDENTIFIER,
     *    COLON,
     *    TYPE,
     *    SEMICOLON
     */

    override fun getChildren(): List<Node> {
        val letToken = tokens[0]
        val identifierToken = tokens[1]
        val typeToken = tokens[3]

        val letNode = LeafNode(letToken.type, letToken.value)
        val identifierNode = LeafNode(identifierToken.type, identifierToken.value)
        val typeNode = LeafNode(typeToken.type, typeToken.value)

        return listOf(letNode, identifierNode, typeNode)
    }

    override fun getTokensInLine(): List<Token> {
        return tokens
    }
}