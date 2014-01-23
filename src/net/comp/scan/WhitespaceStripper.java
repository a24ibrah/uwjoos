package net.comp.scan;

/**
 * Strips duplicated whitespace from input text but also preserves formatting of new line and spaces
 */
public class WhitespaceStripper {
    private static final char SPACE = ' ';
    private static final char TAB = '\t';
    private static final char FORM_FEED = '\f';
    
    private static final char CARRIAGE_RETURN = '\r';
    private static final char LINE_FEED = '\n';
    
    public String strip(final String input) {
        final char[] builder = new char[input.length()];
        int index = 0;
        
        boolean lastWhitespace = false;
        boolean lastEndOfLine = false;
        
        for (final char current : input.toCharArray()) {
            final boolean whitespace = this.isWhitespaceCharacter(current);
            final boolean endOfLine = this.isEndOfLineCharacter(current);
            if (whitespace) {
                if (!lastWhitespace && !lastEndOfLine) { // Example: a\t -> a\t
                    builder[index] = current;
                    index++;
                }
            } else if (endOfLine) {
                if (lastWhitespace) { // Example: \t\n -> \n
                    builder[index - 1] = current;
                } else if (!lastEndOfLine) { // Example: a\n -> a\n
                    builder[index] = current;
                    index++;
                }
            } else {
                builder[index] = current;
                index++;
            }
            lastWhitespace = whitespace;
            lastEndOfLine = endOfLine;
        }
        
        return String.valueOf(builder).trim();
    }
    
    private boolean isWhitespaceCharacter(final char character) {
        return (character == WhitespaceStripper.SPACE) || (character == WhitespaceStripper.TAB) || (character == WhitespaceStripper.FORM_FEED);
    }
    
    private boolean isEndOfLineCharacter(final char character) {
        return (character == WhitespaceStripper.CARRIAGE_RETURN) || (character == WhitespaceStripper.LINE_FEED);
    }
}
