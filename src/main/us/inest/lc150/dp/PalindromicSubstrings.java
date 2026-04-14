package us.inest.lc150.dp;

/*
 * https://leetcode.com/problems/palindromic-substrings/description/
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans++;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans++;
            }
        }
        for (int d = 2; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                int j = i + d;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
