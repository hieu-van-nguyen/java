package us.inest.epi.stack;

import java.util.Stack;

public class BasicCalculator {
    public static int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int currentNum = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNum = currentNum * 10 + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNum);
                } else if (operation == '+') {
                    stack.push(currentNum);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNum);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNum);
                }
                operation = currentChar;
                currentNum = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
