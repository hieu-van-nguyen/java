package us.inest.lc150.two_pointers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContainerWithMostWaterTest {
    @Test
    public void testmaxArea() {
        int ans = ContainerWithMostWater.maxArea(new int[] {1,8,6,2,5,4,8,3,7});
        assertEquals(49, ans);
    }
}
