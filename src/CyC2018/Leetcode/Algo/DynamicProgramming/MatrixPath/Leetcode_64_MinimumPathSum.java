package CyC2018.Leetcode.Algo.DynamicProgramming.MatrixPath;

/**
 * 常规 dp 表加递归
 * */
public class Leetcode_64_MinimumPathSum {

    int[][] dp;

    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        return dp(grid, grid.length - 1, grid[0].length - 1);
    }

    private int dp(int[][] grid, int row, int col) {
        if (dp[row][col] != 0) return dp[row][col];
        else if (row == 0 && col == 0)  dp[row][col] = grid[row][col];
        else if (row == 0) dp[row][col] = dp(grid, row, col - 1) + grid[row][col];
        else if (col == 0) dp[row][col] = dp(grid, row - 1, col) + grid[row][col];
        else dp[row][col] = Math.min(dp(grid, row, col - 1), dp(grid, row - 1, col)) + grid[row][col];
        return dp[row][col];
    }


    /**
     * Cyc 方法
     * 递归变循环
     * 空间优化了，用了一维的 lengthOfCol 长度的数组
     * 空间优化的思路：
     *      要找 map[3][4] 的时候，即 dp[4]
     *      这时 dp[3] 记录的是 map[3][3]
     *          dp[4] 记录的是 map[2][4]
     *          够用了
     * */
    public int minPathSum2(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] = dp[j];        // 只能从上侧走到该位置
                } else if (i == 0) {
                    dp[j] = dp[j - 1];    // 只能从左侧走到该位置
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]);
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[n - 1];
    }

}
