package lexer

class LexerTest {
    //TODO (JUNIT?)
    @Test
    fun test001_LexerTest() {
        val lexer = SimpleLexer()
        val input = "Hello, world!"
        val expectedTokens = listOf("Hello,", "world!")
        val actualTokens = lexer.tokenize(input)
        assertEquals(expectedTokens, actualTokens)
    }
}