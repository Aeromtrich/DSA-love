package data.array;

// lecode 189 旋转数组
public class leecode189 {
    // 主函数：在原数组上原地旋转
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;
        int n = nums.length;
        // 取模 n 得到旋转次数 1000 % 3 = 1 100次 = 1次
        // 数组为4 旋转4次 = 没旋转
        k = k % n;
        if (k == 0) return;

        // 反转整个数组
        reverse(nums, 0, n - 1);
        // 反转前 k 个
        reverse(nums, 0, k - 1);
        // 反转剩下的 n-k 个
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] a, int i, int j) {
        while (i < j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++; j--;
        }
    }
}