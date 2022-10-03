package CyC2018.Leetcode.Algo.DynamicProgramming.Bag01;

/**
 * 最简单的 01 背包问题，就是这个物品只有一个，可以选择拿或者不拿
 *有一个容量为 N 的背包，要用这个背包装下物品的价值最大，这些物品有两个属性：体积 w 和价值 v。
 *
 * 定义一个二维数组 dp 存储最大价值，其中 dp[i][j] 表示前 i 件物品体积不超过 j 的情况下能达到的最大价值。设第 i 件物品体积为 w，价值为 v，根据第 i 件物品是否添加到背包中，可以分两种情况讨论：
 *
 * 第 i 件物品没添加到背包，总体积不超过 j 的前 i 件物品的最大价值就是总体积不超过 j 的前 i-1 件物品的最大价值，dp[i][j] = dp[i-1][j]。
 * 第 i 件物品添加到背包中，dp[i][j] = dp[i-1][j-w] + v。
 * 第 i 件物品可添加也可以不添加，取决于哪种情况下最大价值更大。因此，0-1 背包的状态转移方程为：
 * dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w] + v)
 *
 * //背包问题不能贪心，因为会造成浪费，不用考虑，就用 DP 解决
 *
 * 解决这种问题的唯一方法就是遍历所有情况
 *
 * */
public class bag_overview {
    /**
     * Cyc 关于 01 背包的思路我感觉写得非常非常一般，这块的知识，多看算法导论里的切木条
     * */
    // W 为背包总体积
    // N 为物品数量
    // weights 数组存储 N 个物品的重量
    // values 数组存储 N 个物品的价值
//    public int knapsack(int W, int N, int[] weights, int[] values) {
//        int[][] dp = new int[N + 1][W + 1];
//        for (int i = 1; i <= N; i++) {
//            int w = weights[i - 1], v = values[i - 1];
//            for (int j = 1; j <= W; j++) {
//                if (j >= w) {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
//        return dp[N][W];
//    }

    // 下面这个写的不会，虽然结果和钢条切割一样，但是逻辑不好，不够 understandable
//    public int knapsack2(int W, int N, int[] weights, int[] values) {
//        int[] dp = new int[W + 1];
//        for (int i = 1; i <= N; i++) {
//            int w = weights[i - 1], v = values[i - 1];
//            for (int j = W; j >= 1; j--) {
//                if (j >= w) {
//                    dp[j] = Math.max(dp[j], dp[j - w] + v);
//                }
//            }
//        }
//        return dp[W];
//    }
    // dp[i] 指的是，i 这么大的容积最大装多少价值
}
