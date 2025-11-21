package Algorithm.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// leecode 438
public class leecode438 {

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;
        }
        HashMap<Character, Integer> pCount = new HashMap<>();
        HashMap<Character, Integer> sCount = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            pCount.put(p.charAt(i), pCount.getOrDefault(p.charAt(i), 0) + 1);
            sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
        }

        // 检查第一个窗口
        if (sCount.equals(pCount)) {
            res.add(0);
        }

        // 开滑
        int left = 0;
        for (int right = p.length(); right < s.length(); right++) {
            // 添加新字符 去掉旧字符
            char rightChar = s.charAt(right);
            sCount.put(rightChar,sCount.getOrDefault(rightChar, 0) + 1);
            char leftChar = s.charAt(left);
            sCount.put(leftChar, sCount.get(leftChar) - 1);

            // 如果计数为0，从Map中移除该字符
            if (sCount.get(leftChar) == 0) {
                sCount.remove(leftChar);
            }

            left++;

            // 检查是否易位词
            if (pCount.equals(sCount)) {
                res.add(left);
            }
        }

        return res;

    }

}
