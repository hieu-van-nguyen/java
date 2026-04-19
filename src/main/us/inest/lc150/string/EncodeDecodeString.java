package us.inest.lc150.string;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/encode-and-decode-strings/
 */
public class EncodeDecodeString {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.replace("/", "//"));
            encodedString.append("/:");
        }
        return encodedString.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decodedStrings = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == ':') {
                decodedStrings.add(currentString.toString());
                currentString = new StringBuilder();
                i += 2;
            } else if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                currentString.append("/");
                i += 2;
            } else {
                currentString.append(s.charAt(i));
                i++;
            }
        }
        return decodedStrings;
    }
}
