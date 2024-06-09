package us.inest.meta;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    // https://leetcode.com/problems/moving-average-from-data-stream/
    private Queue<Integer> queue;
    private int size;
    private int windowSum;

    public MovingAverage(int size) {
        this.size = size;
        this.windowSum = 0;
        this.queue = new LinkedList<>();
    }

    public double next(int val) {
        queue.add(val);
        int first = queue.size() > size ? queue.poll() : 0;
        windowSum = windowSum - first + val;
        return windowSum * 1.0 / Math.min(queue.size(), size);
    }
}
