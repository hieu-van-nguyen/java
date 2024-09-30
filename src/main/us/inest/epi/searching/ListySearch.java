package us.inest.epi.searching;

public class ListySearch {
    public int listySearch(Listy list, int value) {
        int index = 1;
        while (list.elementAt(index) != -1 && list.elementAt(index) < value) {
            index *= 2;
        }
        return binarySearch(list, value, index / 2, index);
    }

    private int binarySearch(Listy list, int value, int low, int high) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            int midValue = list.elementAt(mid);
            if (midValue > value || midValue == -1) {
                high = mid - 1;
            } else if (midValue < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    class Listy {
        public int elementAt(int i) {
            // TODO
            return -1;
        }
    }
}
