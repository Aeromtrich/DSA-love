package Algorithm.trick;

// leecode 169 多数元素
public class leecode169 {

    public int majorityElement(int[] nums) {
        int res = 0;  // 候选的众数
        int count = 0;  // 候选众数的计数器

        // 遍历整个数组
        for (int num : nums) {
            // 如果计数器为0，选择当前元素作为新的候选众数
            if (count == 0) {
                res = num;
            }
            // 如果当前元素等于候选众数，计数器加1；否则减1
            count = count + ((num == res) ? 1 : -1);
        }

        return res;  // 返回找到的众数
    }
}
