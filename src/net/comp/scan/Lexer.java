package net.comp.scan;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.comp.token.Token;
import net.comp.token.TokenType;

public class Lexer {
    public List<Token> scan(final String input) {
        // The tokens to return
        final List<Token> tokens = new LinkedList<Token>();
        
        // Lexer logic begins here
        final StringBuffer tokenPatternsBuffer = new StringBuffer();
        for (final TokenType tokenType : TokenType.values()) {
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
        }
        
        final Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));
        
        final EnumSet<TokenType> nonWhitespace = EnumSet.allOf(TokenType.class);
        nonWhitespace.remove(TokenType.WHITESPACE);
        
        // Begin matching tokens
        final Matcher matcher = tokenPatterns.matcher(input);
        while (matcher.find()) {
            if (matcher.group(TokenType.WHITESPACE.name()) != null) {
                ;
            } else {
                for (final TokenType type : nonWhitespace) {
                    if (matcher.group(type.name()) != null) {
                        tokens.add(new Token(type, matcher.group(type.name())));
                        break;
                    }
                }
            }
        }
        
        return tokens;
    }
}
