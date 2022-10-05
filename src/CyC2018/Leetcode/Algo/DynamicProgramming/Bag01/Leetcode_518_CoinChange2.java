package CyC2018.Leetcode.Algo.DynamicProgramming.Bag01;

public class Leetcode_518_CoinChange2 {
    /**
     * 完全背包问题
     * 记录有几种方式
     * */
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins)
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        return dp[amount];
    }
}
