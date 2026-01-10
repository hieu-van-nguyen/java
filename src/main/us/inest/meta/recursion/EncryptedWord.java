package us.inest.meta.recursion;

public class EncryptedWord {
    public static String findEncryptedWord(String s) {
        if (s == null) return null;
        if (s.length() == 0) return "";
        int n = s.length();
        int mid = n % 2 != 0 ? (int) (n / 2) : (int) (n / 2) - 1;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(mid));
        String leftPart = s.substring(0, mid);
        String rightPart = s.substring(mid + 1, s.length());
        if (leftPart.length() > 0) {
            sb.append(findEncryptedWord(leftPart));
        }
        if (rightPart.length() > 0) {
            sb.append(findEncryptedWord(rightPart));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String encryted = findEncryptedWord("abcxcba");
        System.out.println(encryted);
    }
}
