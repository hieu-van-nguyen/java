package us.inest.lc150.monotonic_stack;

import java.util.Stack;

public class DailyTemperatures {
    class Pair {
        int temp;
        int index;
        public Pair(int temp, int index) {
            this.temp = temp;
            this.index = index;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek().temp < temperatures[i]) {
                Pair pair = stack.pop();
                ans[pair.index] = i - pair.index;
            }
            stack.push(new Pair(temperatures[i], i));
        }
        return ans;
    }
}
