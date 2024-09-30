package us.inest.epi.sorting;

import java.util.*;

public class GroupAnagrams {
    private class AnagramComparator implements Comparator<String> {
        private String sortChars(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }
            char[] content = s.toCharArray();
            Arrays.sort(content);
            return new String(content);
        }

        @Override
        public int compare(String s1, String s2) {
            return sortChars(s1).compareTo(sortChars(s2));
        }
    }

    public String[] groupAnagrams(String[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        Arrays.sort(arr, new AnagramComparator());
        return arr;
    }

    public void groupAnagramsV2(String[] arr) {
        Map<String, List<String>> mapList = new HashMap<>();

        /* build the hashtable */
        for (String s : arr) {
            String key = sortChars(s);
            if (!mapList.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(s);
                mapList.put(key, list);
            } else {
                mapList.get(key).add(s);
            }
        }

        /* convert hash table to array */
        int index = 0;
        for (String key : mapList.keySet()) {
            List<String> list = mapList.get(key);
            for (String s : list) {
                arr[index++] = s;
            }
        }
    }

    private String sortChars(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}
