import common.ast.*
import common.node.*
import common.token.*

class Parser(private val tokens: List<Token>) {
    private var currentTokenIndex = 0

    fun generateAST(): AST {
        var root: TreeNode? = null

        while (currentTokenIndex < tokens.size) {
            val currentToken = tokens[currentTokenIndex]

            when (currentToken.type) {
                TokenType.LET -> {
                    root = insertNode(root, parseDeclaration())
                }
                TokenType.PRINTLN -> {
                    root = insertNode(root, parsePrintlnStatement())
                }
                else -> {
                    throw RuntimeException("Token de tipo ${currentToken.type} inesperado en la línea $currentTokenIndex")
                }
            }
        }

        return AST(root)
    }

    private fun insertNode(
        root: TreeNode?,
        newNode: TreeNode,
    ): TreeNode {
        if (root == null) {
            return newNode
        }

        if (newNode < root) {
            root.left = insertNode(root.left, newNode)
        } else {
            root.right = insertNode(root.right, newNode)
        }

        return root
    }

    /** DECLARACION DE VARIABLES
     *  Variables con el keyword “let”
     *  Sin inferencia de tipos, es decir se debe aclarar el tipo de la variable (let <identifier> : <type> ; )
     *  Ejemplo: let x: number;
     *  Se puede declarar sólo una variable por sentencia.
     *  Se puede declarar y asignar un valor en una misma sentencia.
     */
    private fun parseDeclaration(): TreeNode {
        getTokenAndAdvance(TokenType.LET)
        val declarationType = TokenType.LET
        val declarationNode = TreeNode(declarationType, headValue = declarationType.toString())

        val identifierToken = getTokenAndAdvance(TokenType.IDENTIFIER)
        val identifierNode = TreeNode(identifierToken.type, headValue = identifierToken.value)
        declarationNode.left = identifierNode

        getTokenAndAdvance(TokenType.COLON)

        val typeToken =
            if (getCurrentToken().type == TokenType.NUMBER_TYPE) {
                getTokenAndAdvance(TokenType.NUMBER_TYPE)
            } else {
                getTokenAndAdvance(TokenType.STRING_TYPE)
            }
        val typeNode = TreeNode(typeToken.type, headValue = typeToken.value)
        declarationNode.right = typeNode

        getTokenAndAdvance(TokenType.SEMICOLON)

        return declarationNode
    }

    private fun parsePrintlnStatement(): TreeNode {
        getTokenAndAdvance(TokenType.PRINTLN)
        val statementType = TokenType.PRINTLN
        val statementNode = TreeNode(statementType, headValue = statementType.toString())
        getTokenAndAdvance(TokenType.OPEN_PARENTHESIS)
        val content = parseContent()
        getTokenAndAdvance(TokenType.CLOSE_PARENTHESIS)
        getTokenAndAdvance(TokenType.SEMICOLON)

        return statementNode
    }

    private fun parseContent(): TreeNode {
        val currentToken = getCurrentToken()
        currentTokenIndex++
        return when (currentToken.type) {
            TokenType.STRING_LITERAL -> {
                TreeNode(currentToken.type, headValue = currentToken.value)
            }
            TokenType.NUMERIC_LITERAL -> {
                TreeNode(currentToken.type, headValue = currentToken.value)
            }
            TokenType.IDENTIFIER -> {
                TreeNode(currentToken.type, headValue = currentToken.value)
            }
            else -> {
                throw RuntimeException("Token de tipo ${currentToken.type} inesperado en la línea $currentTokenIndex")
            }
        }
    }

    private fun getTokenAndAdvance(type: TokenType): Token {
        val currentToken = getCurrentToken()
        val currentTokenType = currentToken.type
        if (currentTokenType == type) {
            currentTokenIndex++
            return currentToken
        } else {
            throw RuntimeException("Se esperaba un token de tipo $type pero fue de tipo $currentTokenType en la línea $currentTokenIndex")
        }
    }

    private fun getCurrentToken(): Token {
        return tokens[currentTokenIndex]
    }
}
