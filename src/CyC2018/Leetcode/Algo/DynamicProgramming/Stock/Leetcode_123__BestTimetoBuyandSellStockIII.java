package CyC2018.Leetcode.Algo.DynamicProgramming.Stock;

public class Leetcode_123__BestTimetoBuyandSellStockIII {
    /**
     * 最简单的 hard 题，没有之一！！
     *
     * base on 309，多弄几个 dp 表
     *
     * 心得：把东西写一下，思路就清晰多了
     * */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) return 0;
        int[][] dp = new int[length][4];
        dp[0][0] = dp[0][2] = -prices[0];
        dp[0][1] = dp[0][3] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }
        return dp[length - 1][3];
    }
    /**
     * 这里空间可以再优化一下，把数组变成一个数
     *
     * 空间优化之后，时间效率直接快了十倍，把线性空间优化成常数空间很重要！
     * */
    public int maxProfit2(int[] prices) {
        int length = prices.length;
        if (length <= 1) return 0;
        int[] dp = new int[4];
        dp[0] = dp[2] = -prices[0];
        dp[1] = dp[3] = 0;
        for (int i = 1; i < length; i++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            dp[2] = Math.max(dp[2], dp[1] - prices[i]);
            dp[3] = Math.max(dp[3], dp[2] + prices[i]);
        }
        return dp[3];
    }

    public int maxProfit3(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        for (int curPrice : prices) {
            if (firstBuy < -curPrice) {
                firstBuy = -curPrice;
            }
            if (firstSell < firstBuy + curPrice) {
                firstSell = firstBuy + curPrice;
            }
            if (secondBuy < firstSell - curPrice) {
                secondBuy = firstSell - curPrice;
            }
            if (secondSell < secondBuy + curPrice) {
                secondSell = secondBuy + curPrice;
            }
        }
        return secondSell;
    }
}
