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

}
