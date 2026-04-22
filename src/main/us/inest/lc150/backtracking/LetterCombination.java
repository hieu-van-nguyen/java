package us.inest.lc150.backtracking;

import java.util.*;

/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */

public class LetterCombination {
    private Map<Character, List<Character>> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        List<String> results = new ArrayList<>();
        if (digits.isEmpty()) {
            return results;
        }
        backtrack(digits, 0, new StringBuilder(), results);
        return results;
    }

    private void backtrack(String digits, int index, StringBuilder partial, List<String> results) {
        if (index == digits.length()) {
            results.add(partial.toString());
            return;
        }
        for (char c : map.get(digits.charAt(index))) {
            partial.append(c);
            backtrack(digits, index + 1, partial, results);
            partial.setLength(partial.length() - 1);
        }
    }
}
