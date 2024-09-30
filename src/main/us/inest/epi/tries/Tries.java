package us.inest.epi.tries;

import us.inest.utils.TriesNode;

public class Tries {
    private final TriesNode root;

    public Tries() {
        root = new TriesNode();
    }

    /*
     * iterative implementation of insert
     */
    public void insert(String word) {
        TriesNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TriesNode node = current.children.get(c);
            if (node == null) {
                node = new TriesNode();
                current.children.put(c, node);
            }
            current = node;
        }
        current.isCompleteWord = true;
    }

    /*
     * recursive implementation of insert
     */
    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }

    private void insertRecursive(TriesNode current, String word, int index) {
        if (index == word.length()) {
            current.isCompleteWord = true;
            return;
        }
        char c = word.charAt(index);
        TriesNode node = current.children.get(c);
        if (node == null) {
            node = new TriesNode();
            current.children.put(c, node);
        }
        insertRecursive(node, word, index + 1);
    }

    /*
     * Iterative implementation of search
     */
    public boolean search(String word) {
        TriesNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return current.isCompleteWord;
    }

    /*
     * Recursive implementation of search
     */
    public boolean searchRecursive(String word) {
        return searchRecursive(root, word, 0);
    }

    private boolean searchRecursive(TriesNode current, String word, int index) {
        if (index == word.length()) {
            return current.isCompleteWord;
        }
        char c = word.charAt(index);
        TriesNode node = current.children.get(c);
        if (node == null) {
            return false;
        }
        return searchRecursive(node, word, index + 1);
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TriesNode current, String word, int index) {
        if (index == word.length()) {
            // when end of word is reached, only delete if current.isCompleteWord is true
            if (!current.isCompleteWord) {
                return false;
            }
            current.isCompleteWord = false;
            // if current has no other mapping then return true
            return current.children.size() == 0;
        }
        char c = word.charAt(index);
        TriesNode node = current.children.get(c);
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
