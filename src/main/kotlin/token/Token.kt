package token

data class Token<T>(val type : TokenType, val position: Position, val value : T)