package CyC2018.Leetcode.Algo.DynamicProgramming.BreakInteger;

public class Leetcode_343_IntegerBreak {
    int[] dp;
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        dp = new int[n + 1];
        return dp(n);
    }
    private int dp(int n) {
        if (dp[n] != 0) return dp[n];
        if (n <= 4) return n;
        int half = n / 2;
        for (int i = 1; i <= half; i++) dp[n] = Math.max(dp[n], dp(i) * dp(n - i));
        return dp[n];
    }
    /**
     * 易
     * dp 表即可
     * 注意一下特殊情况，用了个 half 稍微减少点用时
     * */


    // Cyc iterative version
    public int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }
}
