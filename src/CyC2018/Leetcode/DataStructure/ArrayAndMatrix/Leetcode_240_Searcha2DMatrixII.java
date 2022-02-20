package CyC2018.Leetcode.DataStructure.ArrayAndMatrix;

// 矩阵中查找的一个题目，可以用很多方法解，也是非常经典的一个题目

/**
 * 1. 直接查找
 *      不再赘述，时间复杂度 O(mn) 相当于平方
 * 2. 在每一行进行二分查找
 *      时间复杂度 O(mlogn) 相当于把另一个 n 从线性变成了 log
 * 3. Z 字型
 *      从右上往左下走，时间复杂度 O(m + n) 相当于走了一行一列就找到了
 * **/

// 代码的话直接查找的不再赘述，Z 字型的也好写，主要写写二分查找

public class Leetcode_240_Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i_row = 0;
        int i_col = col - 1;
        while (i_row < row && i_col >= 0) {
            if (matrix[i_row][i_col] == target) return true;
            else if (matrix[i_row][i_col] > target) i_col--;
            else i_row++;
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) if (BSearch(matrix[i], target)) return true;
        return false;
    }

    private boolean BSearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle = 0;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (nums[middle] == target) return true;
            else if (target < nums[middle]) high = middle - 1;
            else low = middle + 1;
        }
        return false;
    }
}
