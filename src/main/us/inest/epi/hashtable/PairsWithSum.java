package us.inest.epi.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsWithSum {
    public static List<Pair> pairsWithSum(int[] arr, int sum) {
        List<Pair> pairs = new ArrayList<>();
        Map<Integer, Integer> unpairedCount = new HashMap<>();
        for (int x: arr) {
            int complement = sum - x;
            if (unpairedCount.getOrDefault(complement, 0) > 0) {
                //found a pair
                pairs.add(new Pair(x, complement));

                //decrease complement
                unpairedCount.put(complement, unpairedCount.getOrDefault(complement, 0) - 1);
            } else {
                //increase count for x by 1
                unpairedCount.put(x, unpairedCount.getOrDefault(x, 0) + 1);
            }
        }
        return pairs;
    }
}

class Pair {
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}