package us.inest.lc150.hashmap;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
/*
 * https://leetcode.com/problems/lfu-cache/description/
 */

class Pair {
    public int key;
    public int value;
    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LFUCache {
    private Map<Integer, Pair> cache;
    private Map<Integer, LinkedHashSet<Integer>> frequencies;
    private int minf;
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        frequencies = new HashMap<>();
        minf = 0;
    }

    private void insert(int key, int frequency, int value) {
        cache.put(key, new Pair(frequency, value));
        frequencies.putIfAbsent(frequency, new LinkedHashSet<>());
        frequencies.get(frequency).add(key);
    }

    public int get(int key) {
        Pair pair = cache.get(key);
        if (pair == null) {
            return -1;
        }
        int frequency = pair.key;
        Set<Integer> keys = frequencies.get(frequency);
        keys.remove(key);
        if (keys.isEmpty()) {
            frequencies.remove(frequency);

            if (minf == frequency) {
                minf++;
            }
        }
        int value = pair.value;
        insert(key, frequency + 1, value);
        return value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        Pair pair = cache.get(key);
        if (pair != null) {
            cache.put(key, new Pair(pair.key, value));
            get(key);
            return;
        }
        if (capacity == cache.size()) {
            Set<Integer> keys = frequencies.get(minf);
            int keyToDelete = keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);
            if (keys.isEmpty()) {
                frequencies.remove(minf);
            }
        }
        minf = 1;
        insert(key, 1, value);
    }
}
