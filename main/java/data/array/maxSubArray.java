package data.array;

public class maxSubArray {
    // leecode 53 最大子数组和
    public int maxSubArray(int[] nums) {
        int maxSub = nums[0];
        int curSum = 0;
        for (int n : nums) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += n;
            maxSub = Math.max(maxSub,curSum);
        }
        return maxSub;
    }
}
