package CyC2018.Leetcode.Algo.DynamicProgramming.Stock;

public class Leetcode_714__BestTimetoBuyandSellStockwithTransactionFee {
    /**
     * base on 309
     * 相当于两个一维的dp表
     * */
    public int maxProfit(int[] prices, int fee) {
        int N = prices.length;
        int[][] dp = new int[N][2]; // 0 持有 1 不持有
        dp[0][0] = - prices[0] - fee;
        dp[0][1] = 0;
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[N-1][1];
    }
}
