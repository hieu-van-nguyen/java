package us.inest.epi.hashtable;

import java.util.HashMap;
import java.util.Map;

public class SparseArray {
    private int n;
    private Map<Integer, Integer> dict;

    public SparseArray(int[] arr, int n) {
        this.n = n;
        dict = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                dict.put(i, arr[i]);
            }
        }
    }

    public void set(int i, int val) throws Exception {
        checkBound(i);
        if (val != 0) {
            dict.put(i, val);
        } else {
            dict.remove(i);
        }
    }

    public int get(int i) throws Exception {
        checkBound(i);
        return dict.getOrDefault(i, 0);
    }

    private boolean checkBound(int i) throws Exception {
        if (i < 0 || i >= this.n) {
            throw new Exception();
        }
        return true;
    }
}
