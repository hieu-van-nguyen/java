package us.inest.epi.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ProductCalculationTest {
    @Test
    public void testProducts() {
        int[] input = new int[] {1, 2, 3, 4, 5};
        int[] result = ProductCalculation.products(input);
        int[] expected = new int[] {120, 60, 40, 30, 24};
        assertArrayEquals(expected, result);
    }
}
