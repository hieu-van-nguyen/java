package us.inest.lc150.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosetPoints {
    public int[][] kClosest(int[][] points, int k) {
        List<int[]> ans = new ArrayList<>();
        // a[0] -> distance
        // a[1] -> index
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < points.length; i++) {
            maxHeap.add(new int[] {getDistance(points[i]), i});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        while (!maxHeap.isEmpty()) {
            int index = maxHeap.poll()[1];
            ans.add(points[index]);
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
