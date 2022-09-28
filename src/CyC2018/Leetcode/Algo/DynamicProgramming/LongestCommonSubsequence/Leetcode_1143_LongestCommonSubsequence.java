package CyC2018.Leetcode.Algo.DynamicProgramming.LongestCommonSubsequence;

/**
 *
 * 最长公共子序列
 *
 * 动态规划经典中的经典
 *
 * */
public class Leetcode_1143_LongestCommonSubsequence {
    char[] firstCharArray;
    int length1;
    char[] secondCharArray;
    int length2;
    int[][] dpMatrix;
    boolean[][] dpBoolean;
    public int longestCommonSubsequence(String text1, String text2) {
        firstCharArray = text1.toCharArray();
        length1 = text1.length();
        secondCharArray = text2.toCharArray();
        length2 = text2.length();
        dpMatrix = new int[length1][length2];
        dpBoolean = new boolean[length1][length2];
        return dp(length1 - 1, length2 - 1);
    }
    private int dp(int firstIndex, int secondIndex) {
        if (dpBoolean[firstIndex][secondIndex]) return dpMatrix[firstIndex][secondIndex];

        if (firstIndex == 0 && secondIndex == 0) {
            dpMatrix[firstIndex][secondIndex] = (firstCharArray[firstIndex] == secondCharArray[secondIndex] ? 1 : 0);
        } else if (firstIndex == 0) {
            if (dp(firstIndex, secondIndex - 1) == 1) dpMatrix[firstIndex][secondIndex] = 1;
            else dpMatrix[firstIndex][secondIndex] = (firstCharArray[0] == secondCharArray[secondIndex] ? 1 : 0);
        } else if (secondIndex == 0) {
            if (dp(firstIndex - 1, secondIndex) == 1) dpMatrix[firstIndex][secondIndex] = 1;
            else dpMatrix[firstIndex][secondIndex] = (firstCharArray[firstIndex] == secondCharArray[0] ? 1 : 0);
        } else {
            if (firstCharArray[firstIndex] == secondCharArray[secondIndex]) {
                dpMatrix[firstIndex][secondIndex] = dp(firstIndex - 1, secondIndex - 1) + 1;
            } else {
                dpMatrix[firstIndex][secondIndex] = Math.max(dp(firstIndex, secondIndex - 1), dp(firstIndex - 1, secondIndex));
            }
        }
        dpBoolean[firstIndex][secondIndex] = true;
        return dpMatrix[firstIndex][secondIndex];
    }


    /**
     * 按顺序构建 dp 表
     * 循环，不用递归函数了，速度会提高一些
     * */
    public int longestCommonSubsequence2(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1]; // dp 表自己加了一圈 0，用来处理靠边的元素
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
