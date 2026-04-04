package us.inest.lc150.two_pointers;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ThreeSumTest {
    @Test
    public void testThreeSum() {
        List<List<Integer>> ans = ThreeSum.threeSum(new int[] {-1,0,1,2,-1,-4});
        assertEquals(2, ans.size());
        assertEquals(List.of(-1, -1, 2), ans.get(0));
        assertEquals(List.of(-1, -0, 1), ans.get(1));
    }
}
