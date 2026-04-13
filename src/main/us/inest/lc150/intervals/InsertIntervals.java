package us.inest.lc150.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        intervals = insertInterval(intervals, newInterval);
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            while (i < intervals.length && isOverlap(current, intervals[i])) {
                current = mergeIntervals(current, intervals[i]);
                i++;
            }
            ans.add(current);
            i--;
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    private boolean isOverlap(int[] a, int[] b) {
        if (a[1] < b[0] || b[1] < a[0]) return false;
        return true;
    }

    private int[] mergeIntervals(int[] a, int[] b) {
        int[] merged = new int[] {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
        return merged;
    }

    private int[][] insertInterval(int[][] intervals, int[] newInterval) {
        boolean isInserted = false;
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] < intervals[i][0]) {
                isInserted = true;
                list.add(i, newInterval);
                break;
            }
        }
        if (!isInserted) {
            list.add(newInterval);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
