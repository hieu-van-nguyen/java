package us.inest.epi.tries;

import us.inest.utils.TrieNode;

public class Tries {
    private final TrieNode root;

    public Tries() {
        root = new TrieNode();
    }

    /*
     * iterative implementation of insert
     */
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if (node == null) {
                node = new TrieNode();
                current.children.put(c, node);
            }
            current = node;
        }
        current.isWord = true;
    }

    /*
     * recursive implementation of insert
     */
    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }

    private void insertRecursive(TrieNode current, String word, int index) {
        if (index == word.length()) {
            current.isWord = true;
            return;
        }
        char c = word.charAt(index);
        TrieNode node = current.children.get(c);
        if (node == null) {
            node = new TrieNode();
            current.children.put(c, node);
        }
        insertRecursive(node, word, index + 1);
    }

    /*
     * Iterative implementation of search
     */
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return current.isWord;
    }

    /*
     * Recursive implementation of search
     */
    public boolean searchRecursive(String word) {
        return searchRecursive(root, word, 0);
    }

    private boolean searchRecursive(TrieNode current, String word, int index) {
        if (index == word.length()) {
            return current.isWord;
        }
        char c = word.charAt(index);
        TrieNode node = current.children.get(c);
        if (node == null) {
            return false;
        }
        return searchRecursive(node, word, index + 1);
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            // when end of word is reached, only delete if current.isCompleteWord is true
            if (!current.isWord) {
                return false;
            }
            current.isWord = false;
            // if current has no other mapping then return true
            return current.children.size() == 0;
        }
        char c = word.charAt(index);
        TrieNode node = current.children.get(c);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        // if true then delete the mapping of character and triesnode reference in the
        // map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(c);
            // return true if no mapping are left in the map
            return current.children.size() == 0;
        }
        return false;
    }
}
