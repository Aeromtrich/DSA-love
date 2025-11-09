package Algorithm.hash;

import java.util.*;

/**
 * leecode 49. 字母异位词分组
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0 && strs == null) {
            return new ArrayList<>();
        }
        // hashMap
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String key = new String(s);
            // map.get(key) 对应的 value .add
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(input);
        System.out.println(result);
    }
}