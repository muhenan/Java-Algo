package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.Backtracking;

import java.util.*;

/**
 * 代码建议
 * 这里很清晰很有限的 Set 其实可以用 boolean 数组代替，可以加快运行的速度
 * */

public class Leetcode_51_NQueens {
    private  List<List<String>> res = new LinkedList<>();
    private HashSet<Integer> cols = new HashSet<>();
    private HashSet<Integer> pos = new HashSet<>();
    private HashSet<Integer> neg = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        Backtracking(n, 0, board);
        return res;
    }
    private void Backtracking(int n, int now, boolean[][] board) {
        if (now < n) {
            for (int i = 0; i < n; i++) {
                if (cols.contains(i) || pos.contains(now + i) || neg.contains(now - i)) continue;
                else {
                    // 解决这个点上的事
                    cols.add(i);
                    pos.add(now + i);
                    neg.add(now - i);
                    board[now][i] = true;

                    // 沿着树往下走，DFS
                    Backtracking(n, now + 1, board);

                    // 排出这个点，也就是开始做 backtracking
                    cols.remove(i);
                    pos.remove(now + i);
                    neg.remove(now - i);
                    board[now][i] = false;
                }
            }
        } else {
            // get an answer
            List<String> answer = new LinkedList<>();
            for (int r = 0; r < n; r++) {
                StringBuilder row = new StringBuilder();
                for (int c = 0; c < n; c++) {
                    if (board[r][c]) row.append('Q');
                    else row.append('.');
                }
                answer.add(row.toString());
            }
            res.add(answer);
        }
    }
}
