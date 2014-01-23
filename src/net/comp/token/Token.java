package net.comp.token;

import java.util.Objects;

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
    
    @Override public boolean equals(final Object obj) {
        if (obj instanceof Token) {
            final Token other = (Token) obj;
            if ((this.type == other.type) && this.data.equals(other.data)) {
                return true;
            }
        }
        return false;
    }
    
    @Override public int hashCode() {
        return Objects.hash(this.type, this.data);
    }
}
