package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.Backtracking;

/**
 * 可达性问题
 *
 * 算是图论 DFS
 *
 * 在之前图论 DFS 的基础上，代码很快完成
 *
 *             boolboard[r][c] = true;
 *             for (int[] d: direction) {
 *                 if (backtracking(board, word, index + 1, boolboard, r + d[0], c + d[1])) return true;
 *             }
 *             boolboard[r][c] = false;
 *
 * 这里这里的 boolboard[r][c] = false; 其实就是开始回溯了
 *
 * */

public class Leetcode_79_WordSearch {

    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // dfs 时要走的四个方向

    private int row;
    private int col;

    private int lengthOfWord;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;

        lengthOfWord = word.length();

        boolean[][] boolboard = new boolean[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (backtracking(board, word, 0, boolboard, r, c)) return true;
            }
        }

        return false;
    }
    private boolean backtracking(char[][] board, String word, int index, boolean[][] boolboard, int r, int c) {
        if (index == lengthOfWord) return true;
        if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] != word.charAt(index) || boolboard[r][c]) return false; // 如果点不在图里，或者不是 ，直接返回 false
        else {
            boolboard[r][c] = true;
            for (int[] d: direction) {
                if (backtracking(board, word, index + 1, boolboard, r + d[0], c + d[1])) return true;
            }
            boolboard[r][c] = false;
        }
        return false;
    }
}

/**
 *
 * 做完题看了 Cyc 的解法，不谋而合，代码几乎一模一样，算是学到了 Cyc 的图论 DFS 回溯了！
 *
 * */