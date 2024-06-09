package us.inest.epi.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveElementTest {
    @Test
    public void testRemoveElement() {
        int[] nums = new int[] {1, 3, 2, 4, 5, 2, 7};
        int val = 2;
        int newLengh = RemoveElement.removeElement(nums, val);
        assertEquals(5, newLengh);
    }
}
