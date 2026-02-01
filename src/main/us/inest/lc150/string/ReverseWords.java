package us.inest.lc150.string;

/*
 * https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder sb = trimSpaces(s);
        reverse(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    private StringBuilder trimSpaces(String s) {
        int i = 0, j = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i <= j && s.charAt(i) == ' ') {
            i++;
        }
        while (i <= j && s.charAt(j) == ' ') {
            j--;
        }
        while (i <= j) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else {
                if (sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(s.charAt(i));
                }
            }
            i++;
        }
        return sb;
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0, end = 0;
        while (end < sb.length()) {
            while (end < sb.length() && sb.charAt(end) != ' ') {
                end++;
            }
            reverse(sb, start, end - 1);
            start = end + 1;
            end = start;
        }
    }

    private void reverse(StringBuilder sb, int left, int right) {
        int i = left, j = right;
        while (i < j) {
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, tmp);
            i++;
            j--;
        }
    }

}
