package us.inest.lc150.string;

/*
 * https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int ans = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            ans++;
            i--;
        }
        return ans;
    }
}
