package us.inest.epi.stack;

import us.inest.utils.StringUtil;

import java.util.Stack;

public class RemoveStars {
    public String removeStars(String s) {
        if (StringUtil.isBlank(s)) return s;

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '*') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
