package us.inest.lc150.stack;

import java.util.Stack;

/*
 * https://leetcode.com/problems/min-stack/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        int min = minStack.isEmpty() ? val : Math.min(minStack.peek(), val);
        stack.push(val);
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
