package us.inest.lc150.sliding_window;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */
public class ChracterReplacement {
    public int characterReplacement(String s, int k) {
        int start = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int maxFrequency = 0;
        int ans = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            maxFrequency = Math.max(maxFrequency, freq.get(c));
            boolean isValid = end - start + 1 - maxFrequency <= k;
            if (!isValid) {
                char deleteChar = s.charAt(start);
                freq.put(deleteChar, freq.get(deleteChar) - 1);
                start++;
            }
            ans = end - start + 1;
        }
        return ans;
    }
}
