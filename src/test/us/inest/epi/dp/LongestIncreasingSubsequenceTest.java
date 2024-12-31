package us.inest.epi.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestIncreasingSubsequenceTest {
    @Test
    public void testLIS() {
        int[] input = new int[] {-1, 3, 4, 5, 2, 2, 2, 2};
        int result = LongestIncreasingSubsequence.LIS(input);
        assertEquals(4, result);
    }
}
