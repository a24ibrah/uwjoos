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
    
    ABSTRACT("\\babstract\\b"),
    BYTE("\\bbyte\\b"),BREAK("\\bbreak\\b"),BOOLEAN("\\bboolean\\b"),
    CONTINUE("\\bcontinue\\b"),CONST("\\bconst\\b"),CLASS("\\bclass\\b"),CHAR("\\bchar\\b"),CATCH("\\bcatch\\b"),CASE("\\bcase\\b"),
    DOUBLE("\\bdouble\\b"),DEFAULT("\\bdefault\\b"),
    EXTENDS("\\bextends\\b"),ELSE("\\belse\\b"),
    FALSE("\\bfalse\\b"),FLOAT("\\bfloat\\b"),FINAL("\\bfinal\\b"),FINALLY("\\bfinally\\b"),FOR("\\bfor\\b"), 
    GOTO("\\bgoto\\b"),
    IF("\\bif\\b"),IMPLEMENTS("\\bimplements\\b"),INTERFACE("\\binterface\\b"),INT("\\bint\\b"),
    LONG("\\blong\\b"),
    NATIVE("\\bative\\b"),NULL("\\bnull\\b"),NEW("\\bnew\\b"),
    PACKAGE("\\bpackage\\b"),PRIVATE("private"),PROTECTED("protected"),PUBLIC("public"),
    RETURN("\\breturn\\b"),
    SHORT("\\bshort\\b"),SYNCHRONIZED("\\bsynchronize\\b"),SWITCH("\\bswitch\\b"),SUPER("\\bsuper\\b"),STATIC("\\bstatic\\b"),STRICTFP("\\bstrictfp\\b"),
    THIS("\\bthis\\b"),THROW("\\bthrow\\b"),THROWS("\\bthrows\\b"),TRUE("\\btrue\\b"),TRANSIENT("\\btransient\\b"),TRY("\\btry\\b"),
    VOID("\\bvoid\\b"),VOLATILE("\\bvolatile\\b"),
    WHILE("\\bwhile\\b"),
    
    NUMBER("-?[0-9]+"), // Note: this is incorrect, it should be for integers and for longs (also should be separate types). Make sure float/doubles do not match it.
    //BINARYOP("[*|/|+|-]"), // Note: these should probably be separated out to enhance logic
    WHITESPACE("[ \t\f]+"),
    
    LINETERMINATOR("[\\n|\\r|\\r\\n]"),
    
    OPENBRACE("\\{"),
    CLOSEBRACE("\\}"),
    
    OPENBRACKET("\\("),
    CLOSEBRACKET("\\)"),
    
    SEMICOLON(";"),
    
    SUB("\\032"), // End of file optional character 
    
        // By Ahmed
       DIVIE("/"),MINUS("-"),EQL("="),LEQ("<="),GEQ(">="),GTR(">"),
       LSS("<"),
       PERIOD("."),
       COMMA(","),
       TILDE("~"),
       EXCLAMATION("!"),
       COLON(":"),CARET("^"),BITAND("&"),PERCENT("%"),BITOR("|"),
       AND ("&&"),EQ("=="),NEG("!="),
       OR("||"),SHIFTLEFT("<<"),SIGNEDSHIFTRIGHT(">>"),
       UNSIGNEDSHIFTRIGHT(">>>"),SHIFTLEFTASSIGN("<<="),
       SIGNEDSHIFTLEFTASSIGN(">>="),UNSIGNEDSHIFTLEFTASSIGN(">>="),
       MODASSIGN("%="),BITXORASSIGN("^="),BITORASSIGN("|="),
        BITANDASSIGN("&="),DIVASSIGN("/="),MINUSASSIGN("-="),
        //STARASSIGN("*=")
        //PLUS("+"),
        //MINUS("-"),
        //STAR("*"),
        //PLUSASSIGN("+=")
        //PLUSPLUS("++"),
        MINUSMINUS("--"),
        //ends here - ahmed
    IDENTIFIER("\\b[A-Za-z_$][A-Za-z0-9_$]*\\b"); // Should always be last
    
    // @formatter:on 
    public final String pattern;
    
    private TokenType(final String pattern) {
        this.pattern = pattern;
    }
}
