package Algorithm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * leecode 3 无重复字符最长子串 sile window
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> window = new HashSet<>();
        int l = 0;
        int maxLen = 0;
        for (int r = 0; r < s.length(); r++) {

            while (window.contains(s.charAt(r))) {
                window.remove(s.charAt(l));
                l +=1;
            }
            window.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));  // 输出 3
    }
}