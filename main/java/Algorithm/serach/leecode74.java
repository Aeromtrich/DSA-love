package Algorithm.serach;

// leecode 74 搜索二维矩阵
class leecode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        
        // 第一步：在行之间进行二分查找，找到目标可能所在的行
        int top = 0, bot = ROWS - 1;
        while (top <= bot) {
            int row = (top + bot) / 2;
            
            // 如果目标大于当前行的最后一个元素，说明目标在下面的行
            if (target > matrix[row][COLS - 1]) {
                top = row + 1;
            } 
            // 如果目标小于当前行的第一个元素，说明目标在上面的行
            else if (target < matrix[row][0]) {
                bot = row - 1;
            } 
            // 目标在当前行的范围内，跳出循环
            else {
                break;
            }
        }
        
        // 如果没有找到合适的行，返回false
        if (!(top <= bot)) {
            return false;
        }
        
        // 第二步：在找到的行内进行二分查找
        int row = (top + bot) / 2;  // 确定目标所在的行
        int left = 0, right = COLS - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (target > matrix[row][mid]) {
                left = mid + 1;
            } else if (target < matrix[row][mid]) {
                right = mid - 1;
            } else {
                return true;  // 找到目标
            }
        }
        
        return false;  // 在当前行中没有找到目标
    }
}