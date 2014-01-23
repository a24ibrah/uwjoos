package net.comp.scan;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.comp.token.Token;
import net.comp.token.TokenType;

public class Lexer {
    private final Pattern tokenPatterns;
    
    public Lexer() {
        final StringBuilder tokenPatternsBuffer = new StringBuilder();
        for (final TokenType tokenType : EnumSet.allOf(TokenType.class)) {
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
        }
        
        this.tokenPatterns = Pattern.compile(tokenPatternsBuffer.substring(1));
    }
    
    public List<Token> scan(final String input) {
        // The tokens to return
        final List<Token> tokens = new LinkedList<Token>();
        
        // Lexer logic begins here
        
        // Begin matching tokens
        final Matcher matcher = this.tokenPatterns.matcher(input);
        while (matcher.find()) {
            for (final TokenType type : EnumSet.allOf(TokenType.class)) {
                if (matcher.group(type.name()) != null) {
                    tokens.add(new Token(type, matcher.group(type.name())));
                    break;
                }
            }
        }
        
        return tokens;
    }
}
