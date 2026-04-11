package us.inest.dropbox;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CandyTest {
    @Test
    public void testCandy() {
        int ans = Candy.candy(new int[] {1, 0, 2});
        assertEquals(5, ans);
    }
}
