package us.inest.epi.stack;

import java.util.Stack;

public class BalancedBrackets {
    public static boolean checkBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
