package us.inest.epi.recursion;

import java.util.Arrays;

public class TripleStep {
    public int countWays(int n) {
        // base cases
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }

    public int countWaysV2(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWaysV2Helper(n, memo);
    }

    public int countWaysV2Helper(int n, int[] memo) {
        // base cases
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (memo[n] > -1) {
            return memo[n];
        }
        memo[n] = countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        return memo[n];
    }
}
