package us.inest.lc150.sliding_window;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinSizeSubArraySumTest {
    @Test
    public void testMinSubArrayLen() {
        int ans = MinSizeSubArraySum.minSubArrayLen(7, new int[] {2,3,1,2,4,3});
        assertEquals(2, ans);
    }
}
