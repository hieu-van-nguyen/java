package us.inest.lc150.intervals;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/non-overlapping-intervals/
 */
public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
        int k = Integer.MIN_VALUE;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (k <= start) {
                k = end;
            } else {
                ans++;
            }
        }
        return ans;
    }
}
