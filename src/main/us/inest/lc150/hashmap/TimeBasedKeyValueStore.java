package us.inest.lc150.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * https://leetcode.com/problems/time-based-key-value-store/
 */
public class TimeBasedKeyValueStore {
    private Map<String, TreeMap<Integer, String>> cache;

    public TimeBasedKeyValueStore() {
        cache = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!cache.containsKey(key)) {
            cache.put(key, new TreeMap<>());
        }
        cache.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!cache.containsKey(key)) {
            return "";
        }
        Integer ts = cache.get(key).floorKey(timestamp);
        if (ts != null) {
            return cache.get(key).get(ts);
        }
        return "";
    }
}
