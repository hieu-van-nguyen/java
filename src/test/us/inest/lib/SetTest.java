package us.inest.lib;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class SetTest {
    @Test
    public void testCommonSetMethods() {
        /*
        add
        contains
        size
        isEmpty
        remove
         */
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2);
        set.add(3);
        set.add(4);
        assertEquals(4, set.size());
        assertFalse(set.isEmpty());
        assertTrue(set.contains(2));
        set.remove(3);
        assertFalse(set.contains(3));
    }
}
