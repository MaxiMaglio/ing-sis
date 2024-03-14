import common.ast.AST
import common.ast.implementation.AssignationAST
import common.ast.implementation.DeclarationAST
import common.ast.implementation.DeclarationAssignationAST
import common.ast.implementation.FunctionAST
import interpreter.implementation.AssignationInterpreter
import interpreter.implementation.DeclarationInterpreter
import interpreter.implementation.FunctionInterpreter
import interpreter.`interface`.Interpreter

class Interpreter : Interpreter {

    private val symbolTable = mutableMapOf<String, String?>()

    override fun interpret(ast: AST) {
        return when (ast) {
            is DeclarationAST -> {
                DeclarationInterpreter(symbolTable).interpret(ast)
            }

            is DeclarationAssignationAST -> {
                DeclarationInterpreter(symbolTable).interpret(ast)
                AssignationInterpreter(symbolTable).interpret(ast)
            }

            is AssignationAST -> {
                AssignationInterpreter(symbolTable).interpret(ast)
            }

            is FunctionAST -> {
                FunctionInterpreter(symbolTable).interpret(ast)
            }

            else -> {
                throw Exception("Invalid AST")
            }
        }
    }
    fun getSymbolTable(): MutableMap<String, String?> {
        return this.symbolTable
    }
}
