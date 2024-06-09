package us.inest.meta;

public class ValidPalindromeII {
    // https://leetcode.com/problems/valid-palindrome-ii/
    private boolean checkPalindrome(String s, int i, int j) {
        int left = i, right = j;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return checkPalindrome(s, i + 1, j) || checkPalindrome(s, i , j - 1);
            }
            i++;
            j--;
        }
        return true;
    }
}
