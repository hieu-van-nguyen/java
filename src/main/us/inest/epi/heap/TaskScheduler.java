package us.inest.epi.heap;

import java.util.*;

public class TaskScheduler {
    public static int leastIntervals(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - 1);
        maxHeap.addAll(map.values());

        int intervals = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.remove());
                }
            }

            for (int value : temp) {
                if (--value > 0) {
                    maxHeap.add(value);
                }
            }

            intervals += maxHeap.isEmpty() ? temp.size() : n + 1;
        }

        return intervals;
    }
}
