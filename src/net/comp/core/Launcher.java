package net.comp.core;

import java.util.List;

import net.comp.scan.Lexer;
import net.comp.token.Token;

public class Launcher {
    public static void main(final String[] args) {
        final String input = "while int float void for 55 + 22 - 33";
        final Lexer lex = new Lexer();
        
        // Create tokens and print them
        final List<Token> tokens = lex.scan(input);
        for (final Token token : tokens) {
            System.out.println(token);
        }
    }
}
