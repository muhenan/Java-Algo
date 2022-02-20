package CyC2018.Leetcode.DataStructure.ArrayAndMatrix;

// 重塑矩阵，就是矩阵的形状变一下，非常非常基础的一个矩阵的题目
// 走一遍这个矩阵即可，时间空间都是线性

public class Leetcode_566_Matrix1 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int old_row = mat.length;
        if (old_row == 0) return mat;
        int old_col = mat[0].length;
        if (old_col == 0) return mat;
        if (old_col * old_row != r * c) return mat;
        int res[][] = new int[r][c]; // int[][] res = = new int[r][c]
        for (int i = 0; i < old_row; i++) {
            for (int j = 0; j < old_col; j++) {
                int index = old_col * i + j;
                res[index / c][index % c] = mat[i][j];
            }
        }
        return res;
    }
}

/**
 * 复盘：
 * 1 要适应这种从 0 开始的数数的感觉
 * 2 遍历矩阵时，跨行时，乘除mod的都是 col
 * **/
