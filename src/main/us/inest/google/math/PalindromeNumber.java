package us.inest.google.math;

/*
 * https://leetcode.com/problems/palindrome-number/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x % 10 == 0 && x != 0) return false;
        int reverse = 0;
        while (x > reverse) {
            int d = x % 10;
            reverse = reverse * 10 + d;
            x /= 10;
        }
        return (x == reverse || x == reverse / 10);
    }
}
