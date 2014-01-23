package net.comp.token;

/**
 * Cannot have underscore in names as it is used in consolidated regex expression. Note: order is important, as it searches based on the order provided in the
 * definition. Keep in mind you have to double escape regular expressions because Java will first unescape them during compilation and then regex will process
 * them.
 */
public enum TokenType {
    // @formatter:off
    COMMENT("(/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/)|(//.*[\\n|\\r|\\r\\n])"),
    //    (/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)|(//.*[\n|\r|\r\n]?)
    
    ABSTRACT("abstract"),
    BYTE("byte"),BREAK("break"),BOOLEAN("boolean"),
    CONTINUE("continue"),CONST("const"),CLASS("class"),CHAR("char"),CATCH("catch"),CASE("case"),
    DOUBLE("double"),DEFAULT("default"),
    EXTENDS("extends"),ELSE("else"),
    FALSE("false"),FLOAT("float"),FINAL("final"),FINALLY("finally"),FOR("for|FOR"), 
    GOTO("goto"),
    IF("if"),IMPLEMENTS("implements"),INTERFACE("interface"),
    LONG("long"),
    NATIVE("native"),NULL("null"),NEW("new"),
    PACKAGE("package"),PRIVATE("private"),PROTECTED("protected"),PUBLIC("public"),
    RETURN("return"),
    SHORT("short"),SYNCHRONIZED("synchronize"),SWITCH("switch"),SUPER("super"),STATIC("static"),STRICTFP("strictfp"),
    THIS("this"),THROWS("throws"),TRUE("true"),TRANSIENT("transient"),TRY("try"),
    VOID("void"),VOLATILE("volatile"),
    WHILE("while"),
    
    NUMBER("-?[0-9]+"),
    BINARYOP("[*|/|+|-]"), // Note: these should probably be separated out to enhance logic
    WHITESPACE("[ \t\f]+"),
    
    LINETERMINATOR("[\\n|\\r|\\r\\n]"),
        
    
    OPENBRACE("\\{"),
    CLOSEBRACE("\\}"),
    
    OPENBRACKET("\\("),
    CLOSEBRACKET("\\)"),
    
    SUB("\\032"), // End of file optional character 
    
    IDENTIFIER("[A-Za-z_$][A-Za-z0-9_$]*"); // Should always be last
    
    // @formatter:on
    
    public final String pattern;
    
    private TokenType(final String pattern) {
        this.pattern = pattern;
    }
}
