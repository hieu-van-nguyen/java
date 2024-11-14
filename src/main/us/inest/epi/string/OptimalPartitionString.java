package us.inest.epi.string;

import java.util.Arrays;

public class OptimalPartitionString {
    public static int partitionString(String s) {
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        int count = 1, substringStart = 0;

        for (int i = 0; i < s.length(); i++) {
            if (lastSeen[s.charAt(i) - 'a'] >= substringStart) {
                count++;
                substringStart = i;
            }
            lastSeen[s.charAt(i) - 'a'] = i;
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "abacaba";
        int ans = partitionString(str);
        System.out.println(ans);
    }
}
