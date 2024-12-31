package us.inest.epi.dp;

public class UniqueWaysToMakeChange {
    public static int uniqueWaysToMakeChange(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        /*
         * Max ways to make change for 0 is 1, doing nothing
         */
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            int currentCoinValue = coins[i - 1]; // currentCoinValue can be 1, 2, 5
            for (int j = 1; j <= amount; j++) {
                int uniqueWaysWithoutThisCoinValue = dp[i - 1][j];
                int uniqueWaysWithThisCoinValue = currentCoinValue <= j ? dp[i][j - currentCoinValue] : 0;
                dp[i][j] = uniqueWaysWithoutThisCoinValue + uniqueWaysWithThisCoinValue;
            }
        }
        return dp[coins.length][amount];
    }
}
