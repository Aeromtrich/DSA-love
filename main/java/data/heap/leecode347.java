package data.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// leecode 347 前k个高频元素 桶排序
public class leecode347 {

    public int[] topKFrequent(int[] nums, int k) {
        // 第一步：统计每个数字出现的频率
        Map<Integer,Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        // 第二步：创建频率桶，索引表示频率，值是该频率下的数字列表
        // 注意：频率最大可能是nums.length（如果所有数字都相同），所以需要+1
        List<Integer>[] freq = new ArrayList[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        // 第三步：将数字放入对应频率的桶中
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            freq[frequency].add(num);
        }
        // 第四步：从高频率到低频率遍历，收集前k个高频元素
        List<Integer> res = new ArrayList<>();
        for (int i = freq.length - 1; i >=0 && res.size() < k ; i--) {
            // 如果该频率下有数字，添加到结果中
            for (int num : freq[i]) {
                res.add(num);
                if (res.size() == k) {
                    break;
                }
            }
        }
        // 将List转换为数组返回
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
