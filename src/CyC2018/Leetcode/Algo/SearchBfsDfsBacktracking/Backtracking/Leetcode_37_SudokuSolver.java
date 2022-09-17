package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.Backtracking;

/**
 * 理解 bt 核心的意思后，根本不难
 *
 * 数独题：
 *      无非限制条件更多一些，要尝试的情况更多
 * **/

/**
 * bt 核心：
 *      for
 *          在这个位置选择这个元素
 *          bt 下一个位置
 *          在这个位置不选择这个元素，remove, backtracking
 *
 * **/

public class Leetcode_37_SudokuSolver {

    private boolean[][] rowsUsed = new boolean[9][10];
    private boolean[][] colsUsed = new boolean[9][10];
    private boolean[][] cubesUsed = new boolean[9][10];
    private char[][] my_board = new char[9][9];

    public void solveSudoku(char[][] board) {

        // firstly read given board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                my_board[r][c] = board[r][c];
                if (board[r][c] != '.') {
                    rowsUsed[r][board[r][c] - '0'] = true;
                    colsUsed[c][board[r][c] - '0'] = true;
                    cubesUsed[map_RC_to_cube(r,c)][board[r][c] - '0'] = true;
                }
            }
        }

        // secondly backtracking
        bt(0, 0, board);
    }


    private void bt(int r, int c, char[][] board) {

        // when complete
        if (r == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = my_board[i][j];
                }
            }
            return;
        }

        // get next positon
        int next_r;
        int next_c;
        if (c == 8) {
            next_c = 0;
            next_r = r + 1;
        } else {
            next_c = c + 1;
            next_r = r;
        }


        // bt
        if (my_board[r][c] != '.') { // already have a number
            bt(next_r, next_c, board);
        } else { // try all possible numbers and bt
            for (int i = 1; i <= 9; i++) {
                if (!rowsUsed[r][i] && !colsUsed[c][i] && !cubesUsed[map_RC_to_cube(r,c)][i]) {
                    rowsUsed[r][i] = true;
                    colsUsed[c][i] = true;
                    cubesUsed[map_RC_to_cube(r,c)][i] = true;
                    my_board[r][c] = (char)('0' + i);
                    bt(next_r, next_c, board);
                    rowsUsed[r][i] = false;
                    colsUsed[c][i] = false;
                    cubesUsed[map_RC_to_cube(r,c)][i] = false;
                    my_board[r][c] = '.';
                } else continue;
            }
        }
    }



    private int map_RC_to_cube(int r, int c) {
        return (r / 3) * 3 + (c / 3);
    }
}
