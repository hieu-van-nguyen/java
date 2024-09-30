package us.inest.epi.sorting;

public class SortedMerge {
    public void merge(int[] a, int[] b, int lengthA, int lengthB) {
        int indexA = lengthA - 1;
        int indexB = lengthB - 1;
        int index = lengthA + lengthB - 1;
        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[index] = a[indexA--];
            } else {
                a[index] = b[indexB--];
            }
            index--;
        }
    }
}
