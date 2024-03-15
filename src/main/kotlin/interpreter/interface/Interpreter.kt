package interpreter.`interface`

interface Interpreter {

    /**
     * Interpreta al AST que recibe
     */
    fun interpret(ast: AST)
}