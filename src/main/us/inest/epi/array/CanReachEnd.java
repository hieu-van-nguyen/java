package us.inest.epi.array;

import java.util.List;

public class CanReachEnd {
    /*
     * Greedy Algorithm
     */
    public static boolean canReachEnd(List<Integer> list) {
        int maxReachSoFar = 0;
        int lastIndex = list.size() - 1;
        for (int i = 0; i <= maxReachSoFar && maxReachSoFar < lastIndex; i++) {
            maxReachSoFar = Math.max(maxReachSoFar, i + list.get(i));
        }
        return maxReachSoFar >= lastIndex;
    }
}
