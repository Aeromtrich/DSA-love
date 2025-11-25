package Algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

// leecode 39 组合总和
class leecode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, candidates, target, new ArrayList<>(), 0, res);
        return res;
    }
    
    private void dfs(int i, int[] candidates, int target, List<Integer> cur, int total, List<List<Integer>> res) {
        // 找到满足条件的组合
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        // 超出边界或总和已超过目标值
        if (i >= candidates.length || total > target) {
            return;
        }
        
        // 选择当前元素
        cur.add(candidates[i]);
        dfs(i, candidates, target, cur, total + candidates[i], res);
        
        // 不选择当前元素，移动到下一个元素
        cur.remove(cur.size() - 1);
        dfs(i + 1, candidates, target, cur, total, res);
    }
}