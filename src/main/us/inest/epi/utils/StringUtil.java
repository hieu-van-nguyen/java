package us.inest.epi.utils;

public class StringUtil {
    public static boolean isBlank(String s) {
        return (s == null || s.trim().length() == 0);
    }
}
