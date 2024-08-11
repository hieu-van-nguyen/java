package us.inest.lib;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;
public class StackTest {
    @Test
    public void testCommonStackMethods() {
        /*
        push
        pop
        isEmpty
        size
        peek
        contains
         */
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        int pe = s.peek();
        assertEquals(4, pe);
        assertEquals(4, s.size());
        int po = s.pop();
        assertEquals(4, po);
        assertEquals(3, s.size());
        assertFalse(s.isEmpty());
        assertTrue(s.contains(2));
    }
}
