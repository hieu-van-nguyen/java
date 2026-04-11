package us.inest.lc150.bit_manipulation;

/*
 * https://leetcode.com/problems/counting-bits/description/
 */
public class CountingBits {
    public int[] countBits(int n) {
       int[] dp = new int[n + 1];
       int offset = 1;
       for (int i = 1; i <= n; i++) {
           if (i == 2 * offset) {
               dp[i] = 1;
               offset *= 2;
           } else {
               dp[i] = 1 + dp[i - offset];
           }
       }
       return dp;
    }
}
