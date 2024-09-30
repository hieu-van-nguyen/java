package us.inest.epi.searching;

public class SparseSearch {
    public int sparseSearch(String[] arr, String str) {
        if (arr == null || str == null || str == "") {
            return -1;
        }
        return sparseSearch(arr, str, 0, arr.length - 1);
    }

    private int sparseSearch(String[] arr, String str, int first, int last) {
        if (first > last) {
            return -1;
        }
        int mid = (last + first) / 2;
        if (arr[mid] == "") {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < first && right > last) {
                    return -1;
                } else if (right <= last && arr[right] != "") {
                    mid = right;
                    break;
                } else if (left >= first && arr[left] != "") {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }
        if (str.equals(arr[mid])) {
            return mid;
        } else if (arr[mid].compareTo(str) < 0) {
            return sparseSearch(arr, str, mid + 1, last); // search right
        } else { // search left
            return sparseSearch(arr, str, first, mid - 1);
        }
    }
}
