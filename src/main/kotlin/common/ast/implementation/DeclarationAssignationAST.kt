package common.ast.implementation

import common.ast.AST
import common.ast.node.Node
import common.token.Token

// para las asignaciones de variables
// LET ID : TYPE = (LITERAL / EXPRESSION / ID);

/**
 * Propósito: Esta clase se utiliza para representar una declaración de asignación que incluye tanto la declaración de una variable como su asignación inicial.
 * Es decir, maneja tanto la declaración de la variable (incluyendo su tipo de dato) como la asignación de un valor a esa variable.
 *
 * Estructura: La clase contiene dos partes principales: declarationAST, que representa la declaración de la variable, y assignationAST, que representa la asignación del valor a la variable.
 * Esto permite manejar declaraciones como LET ID : TYPE = (LITERAL / EXPRESSION / ID);.
 *
 * Cuándo se usa: Se utiliza cuando se necesita representar y analizar declaraciones que no solo asignan un valor a una variable existente, sino que también declaran la variable y su tipo de dato.
 */

class DeclarationAssignationAST (private val tokens: List<Token>) : AST {




    override fun getChildren(): List<Node> {
        TODO("Not yet implemented")
    }

    override fun getTokensInLine(): List<Token> {
        TODO("Not yet implemented")
    }
}