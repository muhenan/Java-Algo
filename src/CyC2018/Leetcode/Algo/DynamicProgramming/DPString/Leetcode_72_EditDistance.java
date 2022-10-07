package CyC2018.Leetcode.Algo.DynamicProgramming.DPString;

public class Leetcode_72_EditDistance {
    public int minDistance(String word1, String word2) {
        int firstLength = word1.length();
        int secondLength = word2.length();
        if (firstLength == 0 && secondLength == 0) return 0;
        if (firstLength == 0) return secondLength;
        if (secondLength == 0) return firstLength;
        int[][] dp = new int[firstLength + 1][secondLength + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= firstLength; i++) dp[i][0] = i;
        for (int i = 1; i <= secondLength; i++) dp[0][i] = i;
        char[] firstCharArr = word1.toCharArray();
        char[] secondCharArr = word2.toCharArray();
        for (int i = 1; i <= firstLength; i++) {
            for (int j = 1; j <= secondLength; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                if (firstCharArr[i - 1] == secondCharArr[j - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
//                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
//                }
            }
        }
        return dp[firstLength][secondLength];
    }

    public static void main(String[] args) {
        Leetcode_72_EditDistance solu = new Leetcode_72_EditDistance();
        solu.minDistance("horse", "ros");
    }
}
