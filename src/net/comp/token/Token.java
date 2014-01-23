package net.comp.token;

public class Token {
    public TokenType type;
    public String data;
    
    public Token(final TokenType type, final String data) {
        this.type = type;
        this.data = data;
    }
    
    @Override public String toString() {
        return String.format("(%s %s)", this.type.name(), this.data);
    }
}
