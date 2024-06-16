package us.inest.epi.string;

import java.util.Map;

public class AlienDictionary {
    public static boolean isWordsSorted(String[] words, String order) {
        if (words == null || words.length <= 1) {
            return true;
        }

        // Build the alphabet mapping
        Integer[] map = new Integer[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            int min = Math.min(curr.length(), next.length());
            for (int j = 0; j < min; j++) {
                char currChar = curr.charAt(j);
                char nextChar = next.charAt(j);
                if (map[currChar - 'a'] < map[nextChar - 'a']) {
                    break; // curr < next
                } else if (map[currChar - 'a'] > map[nextChar - 'a']) {
                    return false;
                } else if (j == min - 1 && curr.length() > next.length()) {
                    return false;
                }
            }
        }
        return true;
    }
}
