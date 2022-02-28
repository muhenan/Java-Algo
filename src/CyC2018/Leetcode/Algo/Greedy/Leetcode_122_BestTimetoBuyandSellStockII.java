package CyC2018.Leetcode.Algo.Greedy;

public class Leetcode_122_BestTimetoBuyandSellStockII {

    /**
     * 这次是找到每一个涨幅，都加起来
     * **/
        public int maxProfit(int[] prices) {
        int Profit = 0;
        int length = prices.length;
        if (length == 1) return Profit;
        int pre = prices[0];
        for (int i = 1; i < length; i++) {
            if (prices[i] > pre) {
                Profit += (prices[i] - pre);
            }
            pre = prices[i];
        }
        return Profit;
    }
}
