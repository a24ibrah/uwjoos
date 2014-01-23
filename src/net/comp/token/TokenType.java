package net.comp.token;

public enum TokenType {
    // Token types cannot have underscores
    // @formatter:off
    ABSTRACT("abstract"),
    BYTE("byte"),BREAK("break"),BOOLEAN("boolean"),
    CONTINUE("continue"),CONST("const"),CLASS("class"),CHAR("char"),CATCH("catch"),CASE("case"),
    DOUBLE("double"),DEFAULT("default"),
    EXTENDS("extends"),ELSE("else"),
    FALSE("false"),FLOAT("float"),FINAL("final"),FINALLY("finally"),FOR("for|FOR"), 
    GOTO("Goto"),
    IF("if"),IMPLEMENTS("implements"),INTERFACE("interface"),
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
    
    // @formatter:on
    
    public final String pattern;
    
    private TokenType(final String pattern) {
        this.pattern = pattern;
    }
}
