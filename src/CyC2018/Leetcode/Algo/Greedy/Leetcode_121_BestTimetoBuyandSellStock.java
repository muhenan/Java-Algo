package CyC2018.Leetcode.Algo.Greedy;

public class Leetcode_121_BestTimetoBuyandSellStock {



    /**
     * 把题目想复杂了，这道题非常简单，关键在于只能买卖一次
     * 还是直方图折线图的思想，找到涨幅最大的那一次，或者说把这中间涨幅的那几次都记下来
     * 然后这样通过记录找到涨幅最大的一次即可
     *
     * 我代码的写法是，记录 min 然后遇到大的就测是不是更大的一次涨幅
     * 如果遇到小的就更新 min
     * **/

    public int maxProfit(int[] prices) {
        int Profit = 0;
        int length = prices.length;
        if (length == 1) return Profit;
        int min = prices[0];
        for (int i = 1; i < length; i++) {
            if (prices[i] > min) {
                if (prices[i] - min > Profit) Profit = prices[i] - min;
            }
            else min = prices[i];
        }
        return Profit;
    }
}
