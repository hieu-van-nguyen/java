package us.inest.lc150.tree;

import us.inest.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializedDeserializedTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder output) {
        if (root == null) {
            output.append("null,");
        } else {
            output.append(String.valueOf(root.val) + ",");
            serializeHelper(root.left, output);
            serializeHelper(root.right, output);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(tokens));
        return deserialize(list);
    }

    private TreeNode deserialize(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }
}
