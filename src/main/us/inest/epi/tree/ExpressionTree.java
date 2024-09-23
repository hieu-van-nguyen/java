package us.inest.epi.tree;

import us.inest.utils.TreeNodeGeneric;

public class ExpressionTree {
    public int evaluate(TreeNodeGeneric<String> root) {
        switch (root.val) {
            case "+":
                return evaluate(root.left) + evaluate(root.right);
            case "-":
                return evaluate(root.left) - evaluate(root.right);
            case "*":
                return evaluate(root.left) * evaluate(root.right);
            case "/":
                return evaluate(root.left) / evaluate(root.right);
            default:
                return Integer.valueOf(root.val);
        }
    }
}
