package Algorithm.serach;

// leecode 153 寻找旋转排序数组中的最小值
class leecode153 {

    public int findMin(int[] nums) {
        int res = nums[0];
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            // 如果当前区间已经有序，直接取左端点
            if (nums[left] < nums[right]) {
                res = Math.min(res, nums[left]);
                break;
            }
            
            int mid = (left + right) / 2;
            res = Math.min(res, nums[mid]);
            
            if (nums[mid] >= nums[left]) {
                // 中点位于左半部分有序区间，最小值在右侧
                left = mid + 1;
            } else {
                // 中点位于右半部分有序区间，最小值在左侧
                right = mid - 1;
            }
        }
        return res;
    }
}