package us.inest.epi.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CanReachEndTest {
    @Test
    public void testCanReachEnd() {
        Integer[] arr = new Integer[] { 3, 3, 1, 0, 2, 0, 1 };
        List<Integer> list = Arrays.asList(arr);

        boolean result = CanReachEnd.canReachEnd(list);
        assertTrue(result);
    }
}
