package Algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

// leecode 46 全排列 TODO
class leecode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();

        backtrack(nums, used, path, res);
        return res;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        // 如果 path 中的数量 == nums 的长度，说明生成了一个排列
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path)); // 拷贝加入结果
            return;
        }

        // 尝试每一个数字
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;  // 该数已经被用过，跳过

            // 做选择
            used[i] = true;
            path.add(nums[i]);

            // 递归
            backtrack(nums, used, path, res);

            // 撤销选择（回溯）
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}