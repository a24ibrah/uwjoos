package net.comp.core;

import java.util.List;

import net.comp.scan.Lexer;
import net.comp.scan.WhitespaceStripper;
import net.comp.token.Token;

public class Launcher {
    public static void main(final String[] args) {
        final String input = "while interface int float void for 55 + 22 - 33";
        final WhitespaceStripper stripper = new WhitespaceStripper();
        final Lexer lex = new Lexer();
        
        // Create tokens and print them
        final String sanitizedInput = stripper.strip(input);
        final List<Token> tokens = lex.scan(sanitizedInput);
        for (final Token token : tokens) {
            System.out.println(token);
        }
    }
}
