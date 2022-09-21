package CyC2018.Leetcode.Algo.DynamicProgramming.MatrixPath;

import java.util.Arrays;

/**
 * 这题不写了，很简单，以前做过
 * 两种方法：
 * 1 纯数学，排列组合的方法
 * 2 dp 类似 64，用个一维数组就可以
 * */
public class Leetcode_62_UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public int uniquePaths2(int m, int n) {
        int S = m + n - 2;  // 总共的移动次数
        int D = m - 1;      // 向下的移动次数
        long ret = 1;
        for (int i = 1; i <= D; i++) {
            ret = ret * (S - D + i) / i;
        }
        return (int) ret;
    }
}
