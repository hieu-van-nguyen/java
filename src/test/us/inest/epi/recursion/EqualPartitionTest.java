package us.inest.epi.recursion;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EqualPartitionTest {
    @Test
    public void testPartition() {
        int[] nums = new int[] { 1, 8, 2, 5 };
        boolean result = EqualPartition.canPartition_DP(nums);
        assertTrue(result);
    }
}
