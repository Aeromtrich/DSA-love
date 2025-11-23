package Algorithm.serach;

// leecode 34 在排序中查找元素的第一个位置和最后一个位置
class leecode34 {
    public int[] searchRange(int[] nums, int target) {
        int left = binSearch(nums, target, true);
        int right = binSearch(nums, target, false);
        return new int[]{left, right};
    }
    
    // leftBias: true表示找左边界，false表示找右边界
    private int binSearch(int[] nums, int target, boolean leftBias) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                // 找到目标值，记录位置
                index = mid;
                // 根据leftBias决定继续搜索的方向
                if (leftBias) {
                    // 找左边界：继续在左半部分搜索
                    right = mid - 1;
                } else {
                    // 找右边界：继续在右半部分搜索
                    left = mid + 1;
                }
            }
        }
        
        return index;
    }
}