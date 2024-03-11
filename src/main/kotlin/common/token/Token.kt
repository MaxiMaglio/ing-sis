package common.token

data class Token(
    val tokenType : TokenType,
    val value : String,
    val lineNumber : Int,
    val position : Int
)