package data.array;

// leecode 238 除自身以外数组的乘积
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // 1. 用 prefix 计算左边乘积
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prefix;
            prefix = prefix * nums[i];
        }
        // 2. 用 postfix 乘回去右边乘积
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = postfix * res[i];
            postfix = postfix * nums[i];
        }

        return res;
    }
}