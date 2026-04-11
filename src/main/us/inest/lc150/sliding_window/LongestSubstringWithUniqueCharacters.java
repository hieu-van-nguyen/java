package us.inest.lc150.sliding_window;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-interview-150
 */
public class LongestSubstringWithUniqueCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int ans = Integer.MIN_VALUE, start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int index = map.get(c);
                if (index >= start) {
                    ans = Math.max(ans, i - start);
                    start = index + 1;
                }
            }
            map.put(c, i);
        }
        ans = Math.max(ans, s.length() - start);
        return ans;
    }
}
