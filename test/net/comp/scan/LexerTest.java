package net.comp.scan;

import java.util.Arrays;
import java.util.List;

import net.comp.token.Token;
import net.comp.token.TokenType;

import org.junit.Assert;
import org.junit.Test;

/**
 * This test assumes all whitespace has already been stripped.
 */
public class LexerTest {
    private static final Lexer LEXER = new Lexer();
    
    private static final Token WHITESPACE = new Token(TokenType.WHITESPACE, " ");
    private static final Token OPEN_BRACE = new Token(TokenType.OPENBRACE, "{");
    private static final Token CLOSE_BRACE = new Token(TokenType.CLOSEBRACE, "}");
    
    @Test public void testBaseCase() {
        final String input = "class A {}";
        final List<Token> output = LexerTest.LEXER.scan(input);
        final Token[] outputArray = new Token[output.size()];
        output.toArray(outputArray);
        final Token[] expectedArray = new Token[] {
            new Token(TokenType.CLASS, "class"),
            LexerTest.WHITESPACE,
            new Token(TokenType.IDENTIFIER, "A"),
            LexerTest.WHITESPACE,
            LexerTest.OPEN_BRACE,
            LexerTest.CLOSE_BRACE };
        
        Assert.assertArrayEquals("Found: " + Arrays.toString(outputArray) + "\nExpected: " + Arrays.toString(expectedArray), expectedArray, outputArray);
    }
    
    @Test public void testBasicClass() {
        final String input = "public class B {}";
        final List<Token> output = LexerTest.LEXER.scan(input);
        final Token[] outputArray = new Token[output.size()];
        output.toArray(outputArray);
        final Token[] expectedArray = new Token[] {
            new Token(TokenType.PUBLIC, "public"),
            LexerTest.WHITESPACE,
            new Token(TokenType.CLASS, "class"),
            LexerTest.WHITESPACE,
            new Token(TokenType.IDENTIFIER, "B"),
            LexerTest.WHITESPACE,
            LexerTest.OPEN_BRACE,
            LexerTest.CLOSE_BRACE };
        
        Assert.assertArrayEquals("Found: " + Arrays.toString(outputArray) + "\nExpected: " + Arrays.toString(expectedArray), expectedArray, outputArray);
    }
    
    @Test public void testBasicComment() {
        final String input = "// My Comment\npublic class B {}";
        final List<Token> output = LexerTest.LEXER.scan(input);
        final Token[] outputArray = new Token[output.size()];
        output.toArray(outputArray);
        final Token[] expectedArray = new Token[] {
            new Token(TokenType.COMMENT, "// My Comment\n"),
            new Token(TokenType.PUBLIC, "public"),
            LexerTest.WHITESPACE,
            new Token(TokenType.CLASS, "class"),
            LexerTest.WHITESPACE,
            new Token(TokenType.IDENTIFIER, "B"),
            LexerTest.WHITESPACE,
            LexerTest.OPEN_BRACE,
            LexerTest.CLOSE_BRACE };
        
        Assert.assertArrayEquals("Found: " + Arrays.toString(outputArray) + "\nExpected: " + Arrays.toString(expectedArray), expectedArray, outputArray);
    }
    
    @Test public void testMultilineComment() {
        final String input = "/* My Comment\n This should all be ignored*/public class B {}";
        final List<Token> output = LexerTest.LEXER.scan(input);
        final Token[] outputArray = new Token[output.size()];
        output.toArray(outputArray);
        final Token[] expectedArray = new Token[] {
            new Token(TokenType.COMMENT, "/* My Comment\n This should all be ignored*/"),
            new Token(TokenType.PUBLIC, "public"),
            LexerTest.WHITESPACE,
            new Token(TokenType.CLASS, "class"),
            LexerTest.WHITESPACE,
            new Token(TokenType.IDENTIFIER, "B"),
            LexerTest.WHITESPACE,
            LexerTest.OPEN_BRACE,
            LexerTest.CLOSE_BRACE };
        
        Assert.assertArrayEquals("Found: " + Arrays.toString(outputArray) + "\nExpected: " + Arrays.toString(expectedArray), expectedArray, outputArray);
    }
}
