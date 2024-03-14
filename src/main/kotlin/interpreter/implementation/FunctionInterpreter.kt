package interpreter.implementation

import common.ast.AST
import interpreter.`interface`.Interpreter

class FunctionInterpreter(private val symbolTable: MutableMap<String, String?>)  : Interpreter {

    override fun interpret(ast: AST) {
        TODO("Not yet implemented")
    }

}
