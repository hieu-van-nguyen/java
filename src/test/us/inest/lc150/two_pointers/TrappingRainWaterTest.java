package us.inest.lc150.two_pointers;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TrappingRainWaterTest {
    @Test
    public void testTrap() {
        int ans = TrappingRainWater.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});
        assertEquals(6, ans);
    }
}
