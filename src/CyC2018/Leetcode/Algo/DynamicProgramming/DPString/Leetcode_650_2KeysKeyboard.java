package CyC2018.Leetcode.Algo.DynamicProgramming.DPString;

public class Leetcode_650_2KeysKeyboard {

    /**
     * 读题！！！
     * 题目说的是只能复制全部
     *
     * 自解方法，平方时间复杂度，能通过，时间效率不高，第二个 for 可以优化，可以提前结束
     * */
    public int minSteps(int n) {
        if (n == 1) return 0;
        int[] dp = new int[n + 1];
        int[] copied = new int[n + 1];
        for (int i = 0; i < n + 1; i++) dp[i] = Integer.MAX_VALUE;
        dp[1] = copied[1] = 0;
        for (int i = 2; i <= n; i++)
            for (int j = i - 1; j >= 1; j--) {
                if (copied[j] == i - j && dp[i] > dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    copied[i] = copied[j];
                } else if (i % j == 0 && dp[i] > dp[j] + 1 + (i - j) / j) {
                    dp[i] = dp[j] + 1 + (i - j) / j;
                    copied[i] = j;
                }
            }
        return dp[n];
    }

    /**
     * 下面的方法类似于 sqrt(n) * sqrt(n) ?，时间效率提高了
     *
     * 大于 sqrt(n) 的时候就没意义了，因为那样的情况一定已经找过了，会造成重复计算
     *
     * 找的就是这种能乘除开的，这样才能全部全部的复制粘贴
     *
     * Yes！！！！
     * */
    public int minSteps2(int n) {
        if (n == 1) return 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return i + minSteps2(n / i);
        }
        return n;
    }

    public static void main(String[] args) {
        Leetcode_650_2KeysKeyboard solu = new Leetcode_650_2KeysKeyboard();
        solu.minSteps(7);
    }

}
