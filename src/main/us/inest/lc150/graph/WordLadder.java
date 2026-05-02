package us.inest.lc150.graph;

import java.util.*;

/*
 * https://leetcode.com/problems/word-ladder/description/
 */

record Pair<K, V>(K key, V value) {
    // Static factory method
    public static <K, V> Pair<K, V> of(K key, V value) {
        return new Pair<>(key, value);
    }
}

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Map<String, List<String>> wordMap = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, len);
                List<String> transformations = wordMap.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                wordMap.put(newWord, transformations);
            }
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String word = node.key();
            int level = node.value();
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, len);
                List<String> adjWords = wordMap.getOrDefault(newWord, new ArrayList<>());
                for (String adjWord : adjWords) {
                    if (adjWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(adjWord)) {
                        visited.put(adjWord, true);
                        queue.add(new Pair(adjWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}
