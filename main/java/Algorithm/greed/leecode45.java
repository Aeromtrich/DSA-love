package Algorithm.greed;

// leecode 45 跳跃游戏2
public class leecode45 {

    public int jump(int[] nums) {
        int res = 0;  // 记录跳跃次数
        int l = 0, r = 0;  // 当前跳跃范围的左右边界 [l, r]

        // 当右边界还没到达最后一个位置时继续跳跃
        while (r < nums.length - 1) {
            // 记录当前范围内能跳到的最远位置
            int farthest = 0;
            // 遍历当前范围内的所有位置，找到能跳到的最远位置
            for (int i = l; i < r + 1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            // 更新下一跳的范围 // 左边界：从当前位置的下一个位置开始
            // 右边界：当前能跳到的最远位置
            l = r + 1;
            r = farthest;
            // 完成一次跳跃
            res = res + 1;

            // 如果已经能跳到最后一个位置，提前退出
            if (r >= nums.length - 1) {
                break;
            }
        }
        return res;
    }
}
