package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.DFS;

/**
 * 几个重要的点
 *      图的问题，用方向数组来走
 *      dfs 只管自己，把自己遍历完之后标记掉，这里标记的方法是直接改数，解决完自己后，直接 dfs 其他几个方向
 *
 * 图中 DFS 的经典题目，值得深入学习
 * */
public class Leetcode_695_MaxAreaofIsland {
    private int row, col;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // dfs 时要走的四个方向

    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j)); // 在每个点都去 dfs
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c] == 0) return 0; // 如果点不在图里，或者是 0 ，直接返回 0
        grid[r][c] = 0; // 这里是标记的意思，把这个点变成 0，就相当于把这个点标记了，保证这个点之后不会再被算上，即保证了仅遍历一次
        int area = 1; // 这一个点
        for (int[] d : direction) {
            area += dfs(grid, r + d[0], c + d[1]); // 加上其他四个方向遍历的结果
        }
        return area;
    }
}
