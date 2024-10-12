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
        for (int i = 0; i <= amount; i++) {
            // find the solution for i
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    // try this coin
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                } else {
                    break;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
