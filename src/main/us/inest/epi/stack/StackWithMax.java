package us.inest.epi.stack;

import java.util.Stack;

class MaxWithCount {
    public int max;
    public int count;
    public MaxWithCount(int max, int count) {
        this.max = max;
        this.count = count;
    }
}
public class StackWithMax {
    private Stack<Integer> element;
    private Stack<MaxWithCount> cache;

    public StackWithMax() {
        this.element = new Stack<>();
        this.cache = new Stack<>();
    }

    public boolean isEmpty() {
        return element.isEmpty();
    }

    public int max() {
        if (isEmpty()) {
            throw new IllegalStateException("max(): stack is empty");
        }
        return cache.peek().max;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("pop(): stack is empty");
        }
        int popElement = element.pop();
        if (popElement == cache.peek().max) {
            cache.peek().count = cache.peek().count - 1;
            if (cache.peek().count == 0) {
                cache.pop();
            }
        }
        return popElement;
    }

    public void push(int x) {
        element.push(x);
        if (!cache.isEmpty()) {
            if (x == cache.peek().max) {
                cache.peek().count = cache.peek().count + 1;
            } else if (x > cache.peek().max) {
                cache.push(new MaxWithCount(x, 1));
            }
        } else {
            cache.push(new MaxWithCount(x, 1));
        }
    }
}
