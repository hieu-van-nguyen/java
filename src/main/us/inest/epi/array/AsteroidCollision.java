package us.inest.epi.array;

import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < asteroids.length) {
            int current = asteroids[i];
            if (current > 0) {
                stack.push(current);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(current)) {
                    // current asteroid destroys asteroid on top of stack
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(current);
                } else if (stack.peek() == Math.abs(current)) {
                    // both current asteroid and the one on top of stack are destroyed
                    stack.pop();
                }
            }
            i++;
        }
        int[] result = new int[stack.size()];
        for (int j = stack.size() - 1; j >= 0; j--) {
            result[j] = stack.pop();
        }
        return result;
    }
}
