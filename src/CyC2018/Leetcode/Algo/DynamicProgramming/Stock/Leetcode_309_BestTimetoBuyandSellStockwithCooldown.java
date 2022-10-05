package CyC2018.Leetcode.Algo.DynamicProgramming.Stock;

public class Leetcode_309_BestTimetoBuyandSellStockwithCooldown {
    /**
     * 如果没有 cool down
     * 找到所有的上升趋势即可
     * 现在是有 cool down 了，一个上升趋势后必须有一个 cool down 才能再一个上升趋势
     *
     * 如果在一个上升趋势里面搞一个 cool down，那是没有任何意义的
     * 可以在上升趋势的最后一个搞一个 cool down
     * */

    int length;
    int[] dp;
    public int maxProfit(int[] prices) {
        length = prices.length;
        if (length == 1) return 0;
        dp = new int[length];
        return compute(prices, 0);
    }

    private int compute(int[] prices, int index) {
        if (index >= length - 1) return 0;
        if (dp[index] != 0) return dp[index];

        /**
         * 先找到一个极小值点
         * */
        int start = index;
        while (start + 1 < length && prices[start + 1] <= prices[start]) start++;
        /**
         * 然后遍历后面买或者不买
         * */
        for (int next = start + 1; next < length; next++) {
            if (prices[next] > prices[start]) {
                int temp = Math.max(prices[next] - prices[start] + compute(prices, next + 2), compute(prices, next + 1));
                dp[index] = Math.max(dp[index], temp);
            }
        }
        return dp[index];
    }

    /**
     * 有多种情况，就用多个 dp 表
     * 这里就用了三个 dp 表
     * */
    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) return 0;
        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益（i 过后），f[0][0] = -prices[0];
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益，即在 i 处把股票卖了
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益，不持有股票，并且股票不是在 i 处卖的
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]); // 以前的 f[i - 1][0] 或者 f[i][2] 加 现在买一个
            f[i][1] = f[i - 1][0] + prices[i]; // 只能是这样卖一个
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]); // 可以是自己的上一个，或者是刚好在 i - 1 处卖了的
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }

    public static void main(String[] args) {
        Leetcode_309_BestTimetoBuyandSellStockwithCooldown solu = new Leetcode_309_BestTimetoBuyandSellStockwithCooldown();
        solu.maxProfit(new int[]{2,1,4,5,2,9,7});
    }
}
