package us.inest.epi.hashtable;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SparseArrayTest {
    @Test
    public void testSparseArrayOperations() throws Exception {
        SparseArray sut = new SparseArray(new int[] {1, 0, 0, 0, 5, 0, 0, 0, 9}, 9);
        int zero = sut.get(2);
        assertEquals(0, zero);

        int nonZero = sut.get(8);
        assertEquals(9, nonZero);
    }
}
