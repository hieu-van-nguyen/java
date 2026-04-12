package us.inest.lc150.top_k;

import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
