package CyC2018.Leetcode.Algo.DynamicProgramming.BreakInteger;

public class Leetcode_91_DecodeWays {
    /**
     * 自解 dp 方法，过！
     * 字符串问题，多考虑些特殊情况（主要是 0 导致的）
     * */
    int[] dp;
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int length = s.length();
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == '0' && s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') return 0;
        }
        dp = new int[length];
        return dp(s);
    }
    private int dp(String s) {
        int length = s.length();
        if (dp[length - 1] != 0) return dp[length - 1];
        if (length == 1) {
            dp[length - 1] = 1;
        }
        else if (length == 2) {
            int intValue = Integer.valueOf(s);
            dp[length - 1] = (intValue <= 26 && intValue >= 10 && intValue % 10 != 0 ? 2 : 1);
        }
        else {
            int withoutLastOne = (Integer.valueOf(s.charAt(length - 1) == '0' ? 0 : dp(s.substring(0, length - 1))));
            int lastTwo = Integer.valueOf(s.substring(length - 2, length));
            int withoutLastTwo = (lastTwo >= 10 && lastTwo <= 26? dp(s.substring(0, length - 2)) : 0);
            dp[length - 1] = withoutLastOne + withoutLastTwo;
        }
        return dp[length - 1];
    }


    /**
     * Cyc 循环方法
     * 从小到大，一点一点组成最终结果
     * */
    public int numDecodings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // 专门就给 two 用的
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one != 0) { // 只要不能是 0，这个 char 就可以单独用
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '0') { // 说明后面两个 char 不能同时用
                continue;
            }
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two <= 26) { // 说明后面两个 char 能同时用 （这里其实是两个判断，上面的通过了才到这个才真正说明后面两个 char 能同时用）
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
