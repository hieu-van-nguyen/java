package us.inest.epi.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeleteDuplicatesTest {
    @Test
    public void testDeleteDuplicates() {
        int[] arr = new int[] {1, 2, 2, 3, 3};
        int count = DeleteDuplicates.deleteDuplicates(arr);
        assertEquals(3, count);
    }
}
