/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class lexer 
{
    public static enum TokenType
    {
        // Token types cannot have underscores
        ABSTRACT("abstract"),
        BYTE("byte"),BREAK("break"),BOLLEAN("bollean"),
        CONTINUE("continue"),CONST("const"),CLASS("class"),CHAR("char"),CATCH("catch"),CASE("case"),
        DOUBLE("double"),DEFAULT("default"),
        EXTENDS("extends"),ELSE("else"),
        FALSE("false"),FLOAT("float"),FINAL("final"),FINALLY("finally"),FOR("for|FOR"), 
        GOTO("Goto"),
        IF("if"),IMPLEMENTS("implements"),INTERFACE("INTERFACE"),
        LONG("long"),
        NATIVE("native"),NULL("null"),NEW("new"),
        PACKAGE("package"),PRIVATE("private"),PROTECTED("protected"),PUBLIC("public"),
        RETURN("return"),
        SHORT("short"),SYNCHRONIZED("synchronize"),SWITCH("switch"),SUPER("super"),STATIC("static"),STRICTFP("strictfp"),
        THIS("this"),THROWS("throws"),TRUE("true"),TRANSIENT("transient"),TRY("try"),
        VOID("void"),VOLATILE("volatile"),
        WHILE("while"),
        
        NUMBER("-?[0-9]+"), BINARYOP("[*|/|+|-]"), 
        WHITESPACE("[ \t\f\r\n]+");
        
        

        public final String pattern;

        private TokenType(String pattern)
        {
            this.pattern = pattern;
        }
    }

    public static class Token 
    {
        public TokenType type;
        public String data;

        public Token(TokenType type, String data) 
        {
            this.type = type;
            this.data = data;
        }

        @Override
        public String toString() 
        {
            return String.format("(%s %s)", type.name(), data);
        }
    }

    public static ArrayList<Token> lex(String input) 
    {
        // The tokens to return
        ArrayList<Token> tokens = new ArrayList<Token>();

        // Lexer logic begins here
        StringBuffer tokenPatternsBuffer = new StringBuffer();
        for (TokenType tokenType : TokenType.values())
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
        
        Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));

        // Begin matching tokens
        Matcher matcher = tokenPatterns.matcher(input);
        while (matcher.find()) 
        {
            if (matcher.group(TokenType.NUMBER.name()) != null) 
            {
                tokens.add(new Token(TokenType.NUMBER, matcher.group(TokenType.NUMBER.name())));
                
            } 
            else if (matcher.group(TokenType.BOLLEAN.name()) != null) 
            {
                tokens.add(new Token(TokenType.BOLLEAN, matcher.group(TokenType.BOLLEAN.name())));
                
            }
            else if (matcher.group(TokenType.BREAK.name()) != null) 
            {
                tokens.add(new Token(TokenType.BREAK, matcher.group(TokenType.BREAK.name())));
                
            }
            else if (matcher.group(TokenType.BYTE.name()) != null) 
            {
                tokens.add(new Token(TokenType.BYTE, matcher.group(TokenType.BYTE.name())));
                
            }
            else if (matcher.group(TokenType.CASE.name()) != null) 
            {
                tokens.add(new Token(TokenType.CASE, matcher.group(TokenType.CASE.name())));
                
            }
            else if (matcher.group(TokenType.CATCH.name()) != null) 
            {
                tokens.add(new Token(TokenType.CATCH, matcher.group(TokenType.CATCH.name())));
                
            }
            else if (matcher.group(TokenType.CHAR.name()) != null) 
            {
                tokens.add(new Token(TokenType.CHAR, matcher.group(TokenType.CHAR.name())));
                
            }
            else if (matcher.group(TokenType.CLASS.name()) != null) 
            {
                tokens.add(new Token(TokenType.CLASS, matcher.group(TokenType.CLASS.name())));
                
            }
            else if (matcher.group(TokenType.CONST.name()) != null) 
            {
                tokens.add(new Token(TokenType.CONST, matcher.group(TokenType.CONST.name())));
                
            }
            else if (matcher.group(TokenType.CONTINUE.name()) != null) 
            {
                tokens.add(new Token(TokenType.CONTINUE, matcher.group(TokenType.CONTINUE.name())));
                
            }
            else if (matcher.group(TokenType.DEFAULT.name()) != null) 
            {
                tokens.add(new Token(TokenType.DEFAULT, matcher.group(TokenType.DEFAULT.name())));
                
            }
            else if (matcher.group(TokenType.DOUBLE.name()) != null) 
            {
                tokens.add(new Token(TokenType.DOUBLE, matcher.group(TokenType.DOUBLE.name())));
                
            }
            else if (matcher.group(TokenType.ELSE.name()) != null) 
            {
                tokens.add(new Token(TokenType.ELSE, matcher.group(TokenType.ELSE.name())));
                
            }
            else if (matcher.group(TokenType.EXTENDS.name()) != null) 
            {
                tokens.add(new Token(TokenType.EXTENDS, matcher.group(TokenType.EXTENDS.name())));
                
            }
            else if (matcher.group(TokenType.FALSE.name()) != null) 
            {
                tokens.add(new Token(TokenType.FALSE, matcher.group(TokenType.FALSE.name())));
                
            }
            else if (matcher.group(TokenType.FINAL.name()) != null) 
            {
                tokens.add(new Token(TokenType.FINAL, matcher.group(TokenType.FINAL.name())));
                
            }
            else if (matcher.group(TokenType.FINALLY.name()) != null) 
            {
                tokens.add(new Token(TokenType.FINALLY, matcher.group(TokenType.FINALLY.name())));
                
            }
            else if (matcher.group(TokenType.FLOAT.name()) != null) 
            {
                tokens.add(new Token(TokenType.FLOAT, matcher.group(TokenType.FLOAT.name())));
                
            }
            else if (matcher.group(TokenType.FOR.name()) != null) 
            {
                tokens.add(new Token(TokenType.FOR, matcher.group(TokenType.FOR.name())));
                
            }
            else if (matcher.group(TokenType.GOTO.name()) != null) 
            {
                tokens.add(new Token(TokenType.GOTO, matcher.group(TokenType.GOTO.name())));
                
            }
            else if (matcher.group(TokenType.IF.name()) != null) 
            {
                tokens.add(new Token(TokenType.IF, matcher.group(TokenType.IF.name())));
                
            }
            else if (matcher.group(TokenType.IMPLEMENTS.name()) != null) 
            {
                tokens.add(new Token(TokenType.IMPLEMENTS, matcher.group(TokenType.IMPLEMENTS.name())));
                
            }
            else if (matcher.group(TokenType.INTERFACE.name()) != null) 
            {
                tokens.add(new Token(TokenType.INTERFACE, matcher.group(TokenType.INTERFACE.name())));
                
            }
            else if (matcher.group(TokenType.LONG.name()) != null) 
            {
                tokens.add(new Token(TokenType.LONG, matcher.group(TokenType.LONG.name())));
                
            }
            else if (matcher.group(TokenType.NATIVE.name()) != null) 
            {
                tokens.add(new Token(TokenType.NATIVE, matcher.group(TokenType.NATIVE.name())));
                
            }
            else if (matcher.group(TokenType.NEW.name()) != null) 
            {
                tokens.add(new Token(TokenType.NEW, matcher.group(TokenType.NEW.name())));
                
            }
            else if (matcher.group(TokenType.NULL.name()) != null) 
            {
                tokens.add(new Token(TokenType.NULL, matcher.group(TokenType.NULL.name())));
                
            }
            else if (matcher.group(TokenType.NEW.name()) != null) 
            {
                tokens.add(new Token(TokenType.NEW, matcher.group(TokenType.NEW.name())));
                
            }
            else if (matcher.group(TokenType.PACKAGE.name()) != null) 
            {
                tokens.add(new Token(TokenType.PACKAGE, matcher.group(TokenType.PACKAGE.name())));
                
            }
            else if (matcher.group(TokenType.PRIVATE.name()) != null) 
            {
                tokens.add(new Token(TokenType.PRIVATE, matcher.group(TokenType.PRIVATE.name())));
                
            }
            else if (matcher.group(TokenType.PROTECTED.name()) != null) 
            {
                tokens.add(new Token(TokenType.PROTECTED, matcher.group(TokenType.PROTECTED.name())));
                
            }
            else if (matcher.group(TokenType.PUBLIC.name()) != null) 
            {
                tokens.add(new Token(TokenType.PUBLIC, matcher.group(TokenType.PUBLIC.name())));
                
            }
            else if (matcher.group(TokenType.RETURN.name()) != null) 
            {
                tokens.add(new Token(TokenType.RETURN, matcher.group(TokenType.RETURN.name())));
                
            }
            else if (matcher.group(TokenType.SHORT.name()) != null) 
            {
                tokens.add(new Token(TokenType.SHORT, matcher.group(TokenType.SHORT.name())));
                
            }
            else if (matcher.group(TokenType.STATIC.name()) != null) 
            {
                tokens.add(new Token(TokenType.STATIC, matcher.group(TokenType.STATIC.name())));
                
            }
            else if (matcher.group(TokenType.STRICTFP.name()) != null) 
            {
                tokens.add(new Token(TokenType.STRICTFP, matcher.group(TokenType.STRICTFP.name())));
                
            }
            else if (matcher.group(TokenType.SUPER.name()) != null) 
            {
                tokens.add(new Token(TokenType.SUPER, matcher.group(TokenType.SUPER.name())));
                
            }
            else if (matcher.group(TokenType.SWITCH.name()) != null) 
            {
                tokens.add(new Token(TokenType.SWITCH, matcher.group(TokenType.SWITCH.name())));
                
            }
            else if (matcher.group(TokenType.SYNCHRONIZED.name()) != null) 
            {
                tokens.add(new Token(TokenType.SYNCHRONIZED, matcher.group(TokenType.SYNCHRONIZED.name())));
                
            }
            else if (matcher.group(TokenType.THIS.name()) != null) 
            {
                tokens.add(new Token(TokenType.THIS, matcher.group(TokenType.THIS.name())));
                
            }
            else if (matcher.group(TokenType.THROWS.name()) != null) 
            {
                tokens.add(new Token(TokenType.THROWS, matcher.group(TokenType.THROWS.name())));
                
            }
            else if (matcher.group(TokenType.TRANSIENT.name()) != null) 
            {
                tokens.add(new Token(TokenType.TRANSIENT, matcher.group(TokenType.TRANSIENT.name())));
                
            }
            else if (matcher.group(TokenType.TRUE.name()) != null) 
            {
                tokens.add(new Token(TokenType.TRUE, matcher.group(TokenType.TRUE.name())));
                
            }
            else if (matcher.group(TokenType.TRY.name()) != null) 
            {
                tokens.add(new Token(TokenType.TRY, matcher.group(TokenType.TRY.name())));
                
            }
            else if (matcher.group(TokenType.VOID.name()) != null) 
            {
                tokens.add(new Token(TokenType.VOID, matcher.group(TokenType.VOID.name())));
                
            }
            else if (matcher.group(TokenType.VOLATILE.name()) != null) 
            {
                tokens.add(new Token(TokenType.VOLATILE, matcher.group(TokenType.VOLATILE.name())));
                
            }
            else if (matcher.group(TokenType.WHILE.name()) != null) 
            {
                tokens.add(new Token(TokenType.WHILE, matcher.group(TokenType.WHILE.name())));
                
            }
 
            /*8888888888888888888888888888888888888*/
            else if (matcher.group(TokenType.BINARYOP.name()) != null) 
            {
                tokens.add(new Token(TokenType.BINARYOP, matcher.group(TokenType.BINARYOP.name())));
                
            }
            else if (matcher.group(TokenType.FOR.name()) != null) 
            {
                tokens.add(new Token(TokenType.FOR, matcher.group(TokenType.FOR.name())));
                
            }
            else if (matcher.group(TokenType.WHITESPACE.name()) != null)
                ;
        }

        return tokens;
    }

    public static void main(String[] args)
    {
        String input = "while int float void for 55 + 22 - 33";

        // Create tokens and print them
        ArrayList<Token> tokens = lex(input);
        for (Token token : tokens)
            System.out.println(token);
    }
}