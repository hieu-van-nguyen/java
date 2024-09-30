package us.inest.epi.sorting;

public class QuickSort {
    public void quicksort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quicksort(arr, 0, arr.length - 1);
    }

    private void quicksort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {
            // sort left half
            quicksort(arr, left, index - 1);
        }
        if (index < right) {
            // sort right half
            quicksort(arr, index, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        int pivot = arr[mid];
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                // swap
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
