package common.ast.implementation

import common.ast.AST
import common.ast.node.LeafNode
import common.ast.node.Node
import common.token.Token
import common.token.TokenType

/**
 * DeclarationAST se enfoca exclusivamente en la declaración de una variable, sin asignarle un valor inicial.
 * Es útil para contextos donde solo se necesita declarar una variable y su tipo de dato, sin asignarle un valor.
 * representar una declaración de variable en un lenguaje de programación. Esta clase se utiliza para analizar y representar declaraciones como LET ID : TYPE;, donde LET es la palabra clave para declarar una variable, ID es el identificador de la variable, y TYPE es el tipo de dato de la variable.
 *
 * Ejemplo: let x: int;
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
        val children = mutableListOf<Node>()

        val letToken = tokens.firstOrNull { it.type == TokenType.LET }
        val identifierToken = tokens.firstOrNull { it.type == TokenType.IDENTIFIER }
        val colonToken = tokens.firstOrNull { it.type == TokenType.COLON }
        val semicolonToken = tokens.firstOrNull { it.type == TokenType.SEMICOLON }

        if (letToken != null)
            children.add(LeafNode(TokenType.LET, letToken.value))
        if (identifierToken != null)
            children.add(LeafNode(TokenType.IDENTIFIER, identifierToken.value))
        if (colonToken != null)
            children.add(LeafNode(TokenType.COLON, colonToken.value))
        if (semicolonToken != null)
            children.add(LeafNode(TokenType.SEMICOLON, semicolonToken.value))

        return children
    }


    override fun getTokensInLine(): List<Token> {
        return tokens
    }
}