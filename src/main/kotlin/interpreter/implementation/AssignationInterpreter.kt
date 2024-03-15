package interpreter.implementation

import common.ast.AST
import common.ast.node.TreeNode
import common.node.LeafNode
import common.node.TreeNode
import interpreter.`interface`.Interpreter

class AssignationInterpreter(private val symbolTable: MutableMap<String, String?>) : Interpreter {

    //tabla de valores para las asignaciones

    override fun interpret(ast: AST) {
        val children = ast.getChildren()
        val identifierNode = when (val node = children[0]) {
            is LeafNode -> node
            is TreeNode -> {
                throw IllegalArgumentException("Unexpected TreeNode in AST")
            }
            else -> throw IllegalArgumentException("Unexpected node type in AST")
        }

        val typeNode = children[1] as LeafNode
        val valueNode = children[2] as TreeNode

        // Interpretar el valor y asignarlo al identificador en el contexto
        val value = interpretValue(valueNode)
        symbolTable[identifierNode.getValue()] = value.toString()

        println("Asignación realizada: $identifierNode.value = $value")
    }

    private fun interpretValue(node: TreeNode): Any {
        return  node.getValue().toInt()
    }

}