package us.inest.epi.math;

import java.util.Random;

public class ShuffleDeck {
    public static int[] shuffle(int[] arr) {
        Random r = new Random();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j = r.nextInt(n - i) + i;
            // swap
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
}
