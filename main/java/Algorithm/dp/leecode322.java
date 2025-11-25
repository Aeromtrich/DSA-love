package Algorithm.dp;

// leecode 322 零钱兑换
public class leecode322 {

    public int coinChange(int[] coins, int amount) {
        // 初始化 dp 数组
        int[] dp = new int[amount + 1];

        // 填充成一个不可能达到的大值
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        // 开始动态规划 4 -> dp[7] = 1+ dp[3]
        for (int i = 1; i <= amount; i++) {             // 遍历所有金额
            for (int coin : coins) {                   // 尝试每一种硬币
                if (i - coin >= 0) {                   // 金额够用这个硬币
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // 如果 dp[amount] 仍然是初始值，说明凑不出来
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

