package Algorithm.dp;

// leecode 279 完全平方数
public class leecode279 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // 初始化 dp 数组为最大值（n 是最大可能值，因为最差情况是全部用 1^2）
        for (int i = 1; i <= n; i++) {
            dp[i] = n; // 相当于 Python 中的 [n] * (n+1)
        }
        dp[0] = 0;

        for (int target = 1; target <= n; target++) {
            for (int s = 1; s <= target; s++) {
                int square = s * s;
                if (target - square < 0) {
                    break;
                }
                dp[target] = Math.min(dp[target], 1 + dp[target - square]);
            }
        }
        return dp[n];
    }
}
