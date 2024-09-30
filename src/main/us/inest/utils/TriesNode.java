package us.inest.utils;

import java.util.HashMap;

public class TriesNode {
    public HashMap<Character, TriesNode> children;
    public boolean isCompleteWord;

    public TriesNode() {
        children = new HashMap<>();
        isCompleteWord = false;
    }
}
