package Algorithm.trick;

// leecode 287 寻找重复数 Floyd循环检测算法
public class leecode287 {

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        // 第一阶段：寻找相遇点
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }

        // 第二阶段：寻找环的入口（重复数）
        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) {
                return slow;
            }
        }
    }

}
