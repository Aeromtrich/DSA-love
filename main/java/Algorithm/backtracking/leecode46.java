package Algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// leecode 46 全排列 TODO
class leecode46 {

    public List<List<Integer>> permute(int[] nums) {
        // 基本情况：如果数组为空，返回包含空列表的列表
        if (nums.length == 0) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        // 递归调用：获取剩余元素的排列
        int[] remainingNums = Arrays.copyOfRange(nums, 1, nums.length);
        List<List<Integer>> perms = permute(remainingNums);
        List<List<Integer>> res = new ArrayList<>();

        // 对于每一个已有的排列，在每一个可能的位置插入当前元素
        for (List<Integer> p : perms) {
            for (int i = 0; i <= p.size(); i++) {
                List<Integer> pCopy = new ArrayList<>(p);  // 复制列表
                pCopy.add(i, nums[0]);  // 在位置i插入当前元素
                res.add(pCopy);
            }
        }
        return res;
    }
}