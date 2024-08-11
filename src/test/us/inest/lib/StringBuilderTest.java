package us.inest.lib;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringBuilderTest {
    @Test
    public void testCommonStringBuilderMethods() {
        /*
         toString
         append
         charAt
         setLength
         deleteCharAt
         compareTo
         reverse
         indexOf
         insert
         replace
         setCharAt
         isEmpty
         equals
         */
        StringBuilder sb = new StringBuilder("abc");
        sb.append("d");
        assertEquals('b', sb.charAt(1));
        assertEquals(sb.length(), 4);
        sb.deleteCharAt(2);
        assertEquals(sb.length(), 3);
        assertEquals("abd", sb.toString());
        assertFalse(sb.isEmpty());
        assertEquals("dba", sb.reverse().toString());
        sb.append("ghk");
        sb.replace(2, 4, "xxxx");
        assertEquals("dbxxxxhk", sb.toString());
        sb.setCharAt(3, 't');
        assertEquals("dbxtxxhk", sb.toString());
    }
}
