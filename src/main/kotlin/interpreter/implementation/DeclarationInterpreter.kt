package interpreter.implementation

import interpreter.`interface`.Interpreter

class DeclarationInterpreter(private val symbolTable: MutableMap<String, String?>) : Interpreter  {
    override fun interpret(ast: AST) {
        TODO("Not yet implemented")
    }

}
