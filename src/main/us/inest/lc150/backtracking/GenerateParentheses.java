package us.inest.lc150.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(0, 0, n, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int open, int close, int n, StringBuilder sb, List<String> result) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            backtrack(open + 1, close, n, sb, result);
            sb.setLength(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            backtrack(open, close + 1, n, sb, result);
            sb.setLength(sb.length() - 1);
        }
    }
}
