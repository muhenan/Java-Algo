package CyC2018.Leetcode.Algo.DynamicProgramming.Bag01;

public class Leetcode_322_CoinChange {
    /**
     * 每种物品都无限取
     *
     * 完全背包问题
     * */
    private int length;
    private int[] dp;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        length = coins.length;
        dp = new int[amount + 1];
        compute(coins, amount);
        return dp[amount];
    }


    /**
     * 思路最简单的自顶向下的方式
     *
     * 只用一个 for 但是要递归很多函数
     * */
    private int compute(int[] coins, int amount) {
        if (dp[amount] != 0) return dp[amount];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (coins[i] == amount) {
                result = 1;
                break;
            } else if (coins[i] < amount) {
                int temp = compute(coins, amount - coins[i]);
                if (temp != -1) result = Math.min(result, 1 + temp);
                else continue;
            }
        }
        dp[amount] = result != Integer.MAX_VALUE ? result : -1;
        return dp[amount];
    }



    /**
     * Cyc 自底向上写法
     * 自底向上就要两个 for，不用递归函数
     *
     * 完全背包问题，物品无限用
     * 外层 for 循环物品
     * 内层循环结果
     * */
    public int coinChange2(int[] coins, int amount) {
        if (amount == 0 || coins == null) return 0;
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) { //从大于等于这个 coin 的 amount 开始算
                if (i == coin) {
                    dp[i] = 1;
                } else if (dp[i] == 0 && dp[i - coin] != 0) {
                    dp[i] = dp[i - coin] + 1;

                } else if (dp[i - coin] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }



    /**
     * 思路都是一样的，代码做了些调整，时间效率无敌
     * */
    public int coinChange3(int[] coins, int amount) {
        if (amount == 0 || coins == null) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) dp[i] = Integer.MAX_VALUE - 1; // 这里是为了解决后面有 + 1
                                                                            // 因为 Integer.MAX_VALUE + 1 会变成负数
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) { //从大于等于这个 coin 的 amount 开始算
                if (i == coin) dp[i] = 1;
                else dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Leetcode_322_CoinChange solu = new Leetcode_322_CoinChange();
        solu.coinChange(new int[]{1,2,5}, 11);
    }
}
