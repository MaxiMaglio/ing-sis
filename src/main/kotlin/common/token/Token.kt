package common.token

data class Token(
    val type : TokenType,
    val value : String,
    val lineNumber : Int, // seria la linea del codigo
    val position : Int // seria el caracter donde esta
)