package us.inest.dropbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/find-duplicate-file-in-system/
 */
public class DuplicateFiles {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] values = path.split(" ");
            String basePath = values[0];
            for (int i = 1; i < values.length; i++) {
                String value = values[i];
                String[] tokens = value.split("\\(");
                String content = tokens[1].replace(")", "");
                List<String> list = map.getOrDefault(content, new ArrayList<>());
                list.add(basePath + "/" + tokens[0]);
                map.put(content, list);
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                ans.add(map.get(key));
            }
        }
        return ans;
    }
}
