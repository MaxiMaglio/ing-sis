package interpreter.`interface`

import common.ast.AST

interface Interpreter {

    fun interpret(ast: AST)
}