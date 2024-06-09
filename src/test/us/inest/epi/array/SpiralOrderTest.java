package us.inest.epi.array;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
public class SpiralOrderTest {
    @Test
    public void testSpiralOrder() {
        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        List<Integer> nums = SpiralOrder.spiralOrder(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5);
        assertThat(nums, is(expected));
    }
}
