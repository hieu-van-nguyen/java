package us.inest.lc150.hashmap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class ListNode {
    public int key;
    public int value;
    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    private Map<Integer, ListNode> cache;
    LinkedList<ListNode> queue;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        ListNode node = cache.get(key);
        queue.remove(node);
        queue.addLast(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            ListNode oldNode = cache.get(key);
            queue.remove(oldNode);
        }
        ListNode newNode = new ListNode(key, value);
        cache.put(key, newNode);
        queue.addLast(newNode);
        if (queue.size() > capacity) {
            ListNode firstNode = queue.getFirst();
            queue.removeFirst();
            cache.remove(firstNode.key);
        }
    }
}
