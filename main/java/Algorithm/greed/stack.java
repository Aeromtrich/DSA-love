package Algorithm.greed;

/**
 * leecode 121 买卖股票的最佳时机
 */
public class stack {
    public int maxProfit(int[] prices) {
        int left = 0;  // 买入日
        int right = 1; // 卖出日
        int maxProfit = 0;

        while (right < prices.length) {
            if (prices[right] > prices[left]) {
                // 有利润，计算一下
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                // 出现更低的买入价，更新买入日
                left = right;
            }
            right++;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        stack s = new stack();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(s.maxProfit(prices)); // 输出 5
    }
}