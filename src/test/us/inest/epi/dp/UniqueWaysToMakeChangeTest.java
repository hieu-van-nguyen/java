package us.inest.epi.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniqueWaysToMakeChangeTest {
    @Test
    public void testUniqueWaysToMakeChange() {
        int amount = 5;
        int[] coins = new int[] { 1, 2, 5 };

        int result = UniqueWaysToMakeChange.uniqueWaysToMakeChange(amount, coins);
        assertEquals(4, result);
    }
}
