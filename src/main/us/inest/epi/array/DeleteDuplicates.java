package us.inest.epi.array;

public class DeleteDuplicates {
    //delete duplicates in a sorted array
    public static int deleteDuplicates(int[] arr) {
        //check if array is null or empty
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int writeIndex = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[writeIndex - 1] != arr[i]) {
                arr[writeIndex++] = arr[i];
            }
        }
        return writeIndex;
    }
}
