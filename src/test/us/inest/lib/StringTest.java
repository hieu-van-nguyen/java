package us.inest.lib;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringTest {
    @Test
    public void testCommonStringMethods() {
        String str = "adbcehlkg";
        String sub = str.substring(1, 4);
        assertEquals("dbc", sub);
    }
}
