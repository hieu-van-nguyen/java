package us.inest.epi.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int LIS(int[] input) {
        if (input.length == 0) {
            return 0;
        }

        //initialization
        int[] maxLength = new int[input.length];
        Arrays.fill(maxLength, 1);

        int maxSoFar = 1;
        for (int j = 1; j < input.length; j++) {
            for (int i = 0; i < j; i++) {
                if (input[j] > input[i]) {
                    maxLength[j] = Math.max(maxLength[j], maxLength[i] + 1);
                }
            }
            maxSoFar = Math.max(maxSoFar, maxLength[j]);
        }
        return maxSoFar;
    }
}
