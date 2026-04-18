package us.inest.lc150.heap;

import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 */
public class KthLargestElement {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargestElement(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        if (pq.size() < k || pq.peek() < val) {
            pq.add(val);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }
}
