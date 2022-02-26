package CyC2018.Leetcode.DataStructure.ArrayAndMatrix;

// 非常简单的矩阵的题目，比较这个元素的左上角的元素即可

/**
如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？
对于进阶问题一，一次最多只能将矩阵的一行加载到内存中，我们将每一行复制到一个连续数组中，随后在读取下一行时，就与内存中此前保存的数组进行比较。

如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？
对于进阶问题二，一次只能将不完整的一行加载到内存中，我们将整个矩阵竖直切分成若干子矩阵，并保证两个相邻的矩阵至少有一列或一行是重合的，然后判断每个子矩阵是否符合要求。**/


public class Leetcode_766_ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int numberOfRow = matrix.length;
        int numberofCol = matrix[0].length;
        for (int row = 1; row < numberOfRow; row++) {
            for (int col =1; col < numberofCol; col++) {
                if (matrix[row][col] != matrix[row-1][col-1]) return false;
            }
        }
        return true;
    }
}
