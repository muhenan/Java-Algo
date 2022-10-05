package CyC2018.Leetcode.Algo.DynamicProgramming.Stock;

public class Leetcode_188_BestTimetoBuyandSellStockIV {
    /**
     * Based on 123
     *
     * 不必多言，基于 123 直接秒
     * */
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if (length <= 1) return 0;
        int[] dp = new int[k * 2];
        for (int i = 0; i < k * 2; i++) {
            if (i % 2 == 0) dp[i] = -prices[0];
            else dp[i] = 0;
        }
        for (int i = 1; i < length; i++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            for (int j = 1; j < k * 2; j++) {
                if (j % 2 == 1) dp[j] = Math.max(dp[j], dp[j - 1] + prices[i]);
                else dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
            }
        }
        return dp[k * 2 - 1];
    }
}
