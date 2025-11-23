package Algorithm.greed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// leecode 763 划分字母区间
public class leecode763 {

    public List<Integer> partitionLabels(String s) {
        // 存储每个字符最后出现的位置
        Map<Character, Integer> lastIndex = new HashMap<>();

        // 遍历字符串，记录每个字符最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();  // 存储每个分区的长度
        // 当前分区的长度 // 当前分区结束的位置
        int size = 0;
        int end = 0;

        // 遍历字符串进行分区 // 当前分区长度加1
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            size++;
            // 更新当前分区的结束位置为当前字符最后出现的位置
            end = Math.max(end, lastIndex.get(c));
            // 如果当前位置等于分区结束位置，说明找到一个完整分区  // 重置分区长度
            if (i == end) {
                res.add(size);
                size = 0;
            }
        }

        return res;
    }
}
