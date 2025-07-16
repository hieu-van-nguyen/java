package us.inest.epi.dp;

import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        // declare and initialize dp array
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        // build the solution bottom-up
        dp[0] = 0;
        for (int a = 0; a <= amount; a++) {
            // find the solution for i
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= a) {
                    // try this coin
                    dp[a] = Math.min(dp[a], 1 + dp[a - coins[j]]);
                } else {
                    break;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
