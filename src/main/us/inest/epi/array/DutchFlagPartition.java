package us.inest.epi.array;

import java.util.Collections;
import java.util.List;

public class DutchFlagPartition {
    public static void dutchFlagPartition_V3(int pivotIndex, List<Integer> A) {
        int pivot = A.get(pivotIndex);
        int smaller = 0, equal = 0, larger = A.size();
        while (equal < larger) {
            if (A.get(equal) < pivot) {
                Collections.swap(A, smaller++, equal++);
            } else if (A.get(equal) == pivot) {
                equal++;
            } else {
                Collections.swap(A, equal, --larger);
            }
        }
    }
}
