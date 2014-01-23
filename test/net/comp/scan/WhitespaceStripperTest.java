package net.comp.scan;

import org.junit.Assert;
import org.junit.Test;

public class WhitespaceStripperTest {
    private static final WhitespaceStripper STRIPPER = new WhitespaceStripper();
    
    @Test public void testBaseCase() {
        final String input = "";
        final String expected = "";
        final String actual = WhitespaceStripperTest.STRIPPER.strip(input);
        
        Assert.assertEquals(expected, actual);
    }
    
    @Test public void testNoDuplicates() {
        final String input = "class A {}";
        final String expected = "class A {}";
        final String actual = WhitespaceStripperTest.STRIPPER.strip(input);
        
        Assert.assertEquals(expected, actual);
    }
    
    @Test public void testDoubleSpaces() {
        final String input = "class   A {}";
        final String expected = "class A {}";
        final String actual = WhitespaceStripperTest.STRIPPER.strip(input);
        
        Assert.assertEquals(expected, actual);
    }
    
    @Test public void testDoubleNewLines() {
        final String input = "class A {\n\n}";
        final String expected = "class A {\n}";
        final String actual = WhitespaceStripperTest.STRIPPER.strip(input);
        
        Assert.assertEquals(expected, actual);
    }
    
    @Test public void testDoubleNewLinesAndSpaces() {
        final String input = "class   A {\n\n}";
        final String expected = "class A {\n}";
        final String actual = WhitespaceStripperTest.STRIPPER.strip(input);
        
        Assert.assertEquals(expected, actual);
    }
    
    @Test public void testMultipleSpaceAndLines() {
        final String input = "class \t\t  A \t\n{\n\t\n\t\t\n\n}";
        final String expected = "class A\n{\n}";
        final String actual = WhitespaceStripperTest.STRIPPER.strip(input);
        
        Assert.assertEquals(expected, actual);
    }
}
