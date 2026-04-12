package us.inest.lc150.top_k;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));
        for (int num : freq.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] ans = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            ans[index] = minHeap.poll();
            index++;
        }
        return ans;
    }
}
