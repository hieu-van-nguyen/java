package us.inest.lc150.stack;

import java.util.Stack;

/*
 * https://leetcode.com/problems/simplify-path/?envType=study-plan-v2&envId=top-interview-150
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] tokens = path.split("/");
        for (String token : tokens) {
            if (token.equals(".") || token.length() == 0) {
                continue;
            }
            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(token);
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }
        return result.equals("") ? "/" : result;
    }
}
