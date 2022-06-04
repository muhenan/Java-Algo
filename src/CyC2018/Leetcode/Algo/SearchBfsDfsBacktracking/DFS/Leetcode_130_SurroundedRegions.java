package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.DFS;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_130_SurroundedRegions {

    /**
     * 自解方法，顺利通过，不错很棒！！！
     * 用到了标记，不走回头路
     * dfs 的返回值是这个连通分量是不是活的
     * */
    private int row, col;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // dfs 时要走的四个方向

    public void solve(char[][] board) {
        row = board.length;
        col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int r = 1; r < row - 1; r++) {
            for (int c = 1; c < col - 1; c++) {
                if (board[r][c] == 'O' && !visited[r][c]) {
                    List<Integer[]> nodes = new ArrayList<>();
                    if (!dfs(board, r, c, visited, nodes)) drawX(board, nodes);
                }
            }
        }
    }

    private boolean dfs (char[][] board, int r, int c, boolean[][] visited, List<Integer[]> nodes) {
        if (board[r][c] == 'X') return false;
        if (isHelper(r, c)) return true;
        visited[r][c] = true;
        nodes.add(new Integer[]{r, c});
        boolean ans = false;
        for (int[] d : direction) {
            int next_r = r + d[0];
            int next_c = c + d[1];
            if (!visited[next_r][next_c]) {
                if (dfs(board, next_r, next_c, visited, nodes)) ans = true;
            }
        }
        return ans;
    }

    private boolean isHelper (int r, int c) {
        if (r == 0 || r == row - 1 || c == 0 || c == col - 1) return true;
        else return false;
    }

    private void drawX (char[][] board, List<Integer[]> nodes) {
        for (Integer[] node: nodes) board[node[0]][node[1]] = 'X';
    }
    /**
     * 我的思路有点类似于找到所有的死分量，然后将其填充
     * */


    /**
     * Cyc 方法
     * 找到所有的活分量，标记成 T
     * 最后把剩下的 O 填充，把 T 变回 O
     * 反向思维！！！！！！！
     * */
    // 代码
/**
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m, n;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        for (int[] d : direction) {
            dfs(board, r + d[0], c + d[1]);
        }
    }*/
    /**
     *
     * 这种方法简单，效率高，直接秒杀所有其他方法
     *
     * */


    public static void main(String[] args) {
        Leetcode_130_SurroundedRegions solu = new Leetcode_130_SurroundedRegions();
        solu.solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
    }
}
