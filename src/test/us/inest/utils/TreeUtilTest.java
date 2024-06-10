package us.inest.utils;

import org.junit.Test;
import us.inest.utils.TreeNode;
import us.inest.utils.TreeUtil;

import static org.junit.Assert.assertEquals;

public class TreeUtilTest {
    @Test
    public void testInitBST() {
        TreeNode root = TreeUtil.initBST(new int[] {2, 1, 3});
        assertEquals(2, root.val);
        assertEquals(1, root.left.val);
        assertEquals(3, root.right.val);
    }
}
