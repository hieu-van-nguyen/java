package us.inest.utils;

import java.util.HashMap;

public class TrieNode {
    public HashMap<Character, TrieNode> children;
    public boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}
