package common.ast

enum class ASTType {
    DECLARATION,                // let a : Number
    ASSIGNATION,                // a = 4
    DECLARATION_ASSIGNATION,    // let a : Number = 4
    FUNCTION;                   // println (algo)
}