package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.DFS;

/**
 * 岛屿个数
 *
 * 有了 695 这道开山鼻祖一样的题目后，这类题目就变得非常简单了
 * */
public class Leetcode_200_NumberofIslands {

    private int row, col;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // dfs 时要走的四个方向

    private int count;

    public int numIslands(char[][] grid) {
        count = 0;
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(grid, i, j, false); // 在每个点都去 dfs
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c, boolean isInAnIsland) {
        if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c] == '0') return;
        if (!isInAnIsland) count++;
        grid[r][c] = '0';
        for (int[] d : direction) {
            dfs(grid, r + d[0], c + d[1], true); // 加上其他四个方向遍历的结果
        }
        return;
    }
}
