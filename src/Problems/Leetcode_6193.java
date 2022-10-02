package Problems;

public class Leetcode_6193 {
    int result = 0;
    public int maxSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int r = 0; r < row - 2; r++)
            for (int c = 0; c < col - 2; c++)
                result = Math.max(result, getSum(grid, r, c));
        return result;
    }
    private int getSum(int[][] grid, int r, int c) {
        int sum = 0;
        sum += grid[r][c];
        sum += grid[r][c + 1];
        sum += grid[r][c + 2];

        sum += grid[r + 1][c + 1];


        sum += grid[r + 2][c];
        sum += grid[r + 2][c + 1];
        sum += grid[r + 2][c + 2];
        return sum;
    }
}
