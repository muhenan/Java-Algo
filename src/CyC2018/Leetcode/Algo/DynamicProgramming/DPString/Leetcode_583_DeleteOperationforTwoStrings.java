package CyC2018.Leetcode.Algo.DynamicProgramming.DPString;

public class Leetcode_583_DeleteOperationforTwoStrings {
    /**
     * 这题约等于找最长公共子序列
     * */

    /**
     * buttom-up 方法，直接过
     * */
    public int minDistance(String word1, String word2) {
        int lengthOfFirst = word1.length();
        int lengthOfSecond = word2.length();
        char[] CharArrF = word1.toCharArray();
        char[] CharArrS = word2.toCharArray();
        int dp[][] = new int[lengthOfFirst + 1][lengthOfSecond + 1];
        for (int i = 1; i <= lengthOfFirst; i++)
            for (int j = 1; j <= lengthOfSecond; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (CharArrF[i - 1] == CharArrS[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        return lengthOfFirst - dp[lengthOfFirst][lengthOfSecond] + lengthOfSecond - dp[lengthOfFirst][lengthOfSecond];
    }
}
