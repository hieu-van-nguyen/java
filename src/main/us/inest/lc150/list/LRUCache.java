package us.inest.lc150.list;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

/*
 * https://leetcode.com/problems/lru-cache/description/?envType=study-plan-v2&envId=top-interview-150
 */
class LRUListNode {
    public int key;
    public int value;
    public LRUListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    private final int capacity;
    private final Map<Integer, LRUListNode> cache;
    private final LinkedList<LRUListNode> queue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        LRUListNode node = cache.get(key);
        queue.remove(node);
        queue.addLast(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            LRUListNode oldNode = cache.get(key);
            queue.remove(oldNode);
        }
        LRUListNode node = new LRUListNode(key, value);
        cache.put(key, node);
        queue.addLast(node);
        if (cache.size() > capacity) {
            LRUListNode firstNode = queue.getFirst();
            cache.remove(firstNode.key);
            queue.remove(firstNode);
        }
    }
}
