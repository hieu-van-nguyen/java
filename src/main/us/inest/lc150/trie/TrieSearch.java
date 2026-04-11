package us.inest.lc150.trie;

import us.inest.utils.TrieNode;

/*
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */
public class TrieSearch {
    private TrieNode root;

    public TrieSearch() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, root);
    }

    private boolean searchHelper(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                if (c == '.') {
                    for (char x : node.children.keySet()) {
                        if (searchHelper(word.substring(i + 1), node.children.get(x))) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    return false;
                }
            } else {
                node = node.children.get(c);
            }
        }
        return node.isWord;
    }
}
