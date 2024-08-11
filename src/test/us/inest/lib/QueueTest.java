package us.inest.lib;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;
public class QueueTest {
    @Test
    public void testCommonQueueMethods() {
        /*
        add
        offer
        size
        peek
        poll
        remove
        contains
        isEmpty
        toArray
         */
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        assertEquals(4, q.size());
        assertFalse(q.isEmpty());
        assertTrue(q.contains(3));
        int pe = q.peek();
        assertEquals(1, pe);
        assertEquals(4, q.size());

        int po = q.poll();
        assertEquals(1, po);
        assertEquals(3, q.size());
    }
}
