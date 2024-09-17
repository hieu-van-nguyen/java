package us.inest.epi.hashtable;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PairsWithSumTest {
    @Test
    public void pairsWithSumTest() {
        int[] arr = new int[] {1, 4, 2, 7, 5, 3, 9};
        int sum = 7;
        List<Pair> pairs = PairsWithSum.pairsWithSum(arr, sum);
        assertEquals(pairs.size(), 2); //(4, 3) and (2, 5)
    }
}
