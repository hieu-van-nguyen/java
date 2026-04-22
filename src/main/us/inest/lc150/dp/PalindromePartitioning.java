package us.inest.lc150.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/palindrome-partitioning/description/
 */
public class PalindromePartitioning {
    private boolean[][] dp;
    public List<List<String>> partition(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        List<List<String>> results = new ArrayList<>();
        backtrack(s, 0, new LinkedList<>(), results);
        return results;
    }

    private void backtrack(String s, int start, LinkedList<String> list, List<List<String>> results) {
        if (start == s.length()) {
            results.add(new LinkedList<>(list));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start +1][end - 1])) {
                list.add(s.substring(start, end + 1));
                dp[start][end] = true;
                backtrack(s, end + 1, list, results);
                list.removeLast();
            }
        }
    }
}
