package us.inest.utils;

public class TreeNodeGeneric<T> {
    public T val;
    public TreeNodeGeneric<T> left;
    public TreeNodeGeneric<T> right;

    public TreeNodeGeneric(T val) {
        this(val, null, null);
    }

    public TreeNodeGeneric(T val, TreeNodeGeneric<T> left, TreeNodeGeneric<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
