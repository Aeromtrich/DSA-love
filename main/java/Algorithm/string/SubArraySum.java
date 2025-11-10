package Algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 子串 leecode 560 
 */
public class SubArraySum {
    // prefix sum[j] - prefix sum[i] = k
    // prefix sum[j] = prefix sum[i] - k
    // j - i
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // 前缀和为0的情况（必须加）

        int count = 0;
        int curSum = 0;

        for (int num : nums) {
            curSum += num;

            // 查找是否有前缀和 = curSum - k
            if (prefixCount.containsKey(curSum - k)) {
                count += prefixCount.get(curSum - k);
            }

            // 记录当前前缀和出现的次数
            prefixCount.put(curSum, prefixCount.getOrDefault(curSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubArraySum s = new SubArraySum();
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(s.subarraySum(nums, k)); // 输出2 -> [1,2] 和 [3]
    }
}