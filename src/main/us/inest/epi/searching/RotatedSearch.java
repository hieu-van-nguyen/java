package us.inest.epi.searching;

public class RotatedSearch {
    /*
     * using case analysis
     */
    public int rotatedSearch(int[] a, int left, int right, int x) {
        if (right < left) {
            return -1; //not found
        }
        int mid = (left + right) / 2;
        if (x == a[mid]) {
            return mid;
        }

        if (a[left] < a[mid]) {
            // the left side is normally sorted
            if (x >= a[left] && x < a[mid]) {
                return rotatedSearch(a, left, mid - 1, x);
            } else {
                return rotatedSearch(a, mid + 1, right, x);
            }
        } else if (a[mid] < a[left]) {
            // the right side is normally sorted
            if (x > a[mid] && x <= a[right]) {
                return rotatedSearch(a, mid + 1, right, x);
            } else {
                return rotatedSearch(a, left, mid - 1, x);
            }
        } else { // a[left] == a[mid]
            if (a[mid] != a[right]) {
                return rotatedSearch(a, mid + 1, right, x);
            } else {
                // need to search on both halves
                int result = rotatedSearch(a, left, mid - 1, x);
                if (result == -1) {
                    return rotatedSearch(a, mid + 1, right, x);
                } else {
                    return result;
                }
            }
        }
    }
}
