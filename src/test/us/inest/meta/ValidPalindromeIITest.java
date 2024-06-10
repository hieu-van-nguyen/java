package us.inest.meta;

import org.junit.Test;
import us.inest.utils.TreeNode;
import us.inest.utils.TreeUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ValidPalindromeIITest {
    @Test
    public void testValidPalindrome() {
        String s = "abcdcbea";
        boolean result = ValidPalindromeII.validPalindrome(s);
        assertTrue(result);
    }
}
