package Algorithm.dbpointer;

import java.util.*;

public class ThreeSUm {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // 排序

        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复的第一个数
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 跳过重复的左、右值
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }

    // 测试用例
    public static void main(String[] args) {
        ThreeSUm s = new ThreeSUm();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = s.threeSum(nums);
        System.out.println(result);
    }
}