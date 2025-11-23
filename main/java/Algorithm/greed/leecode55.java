package Algorithm.greed;

// leecode 55 跳格子
public class leecode55 {
    // 从数组最后开始向前判断就行
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            // 当前位置可以跳到goal的位置 goal 就为当前位置
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }
}
