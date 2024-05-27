package us.inest.epi.stack;

import us.inest.epi.utils.ArrayUtil;

import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int asteroid : asteroids) {
            boolean flag = true;
            while (!st.isEmpty() && (st.peek() > 0 && asteroid < 0)) {
                if (Math.abs(st.peek()) < Math.abs(asteroid)) {
                    st.pop();
                    continue;
                } else if (Math.abs(st.peek()) == Math.abs(asteroid)) {
                    st.pop();
                }
                flag = false;
                break;
            }
            if (flag) {
                st.push(asteroid);
            }
        }
        int[] remainingAsteroids = new int[st.size()];
        for (int i = remainingAsteroids.length - 1; i >= 0; i--) {
            remainingAsteroids[i] = st.pop();
        }
        return remainingAsteroids;
    }

    public static void main(String[] args) {
        int[] result1 = asteroidCollision(new int[] {5,10,-5});
        ArrayUtil.display(result1);// [5, 10]

        int[] result2 = asteroidCollision(new int[] {8,-8});
        ArrayUtil.display(result2); // []

        int[] result3 = asteroidCollision(new int[] {10,2,-5});
        ArrayUtil.display(result3);// [10]
    }
}
