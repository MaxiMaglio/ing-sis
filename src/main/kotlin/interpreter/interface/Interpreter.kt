package interpreter.`interface`

import common.ast.AST

interface Interpreter {

    /**
     * Interpreta al AST que recibe
     */
    fun interpret(ast: AST)
}