package CyC2018.Leetcode.Algo.DynamicProgramming.Fabonacci;


/**
 *
 * 定义一个数组 dp 存储上楼梯的方法数（为了方便讨论，数组下标从 1 开始），dp[i] 表示走到第 i 个楼梯的方法数目。
 *
 * dp[i] = dp[i -1] + dp[i - 2]
 *
 * iterative or recursive
 *
 * 如果写成递归，那么更好理解也更好写成，更有 dp 的感觉
 * 只需要 dp 表，递归，递归式子，即可
 * but remember, 任何能写成递归的，都可以写成循环，且循环更快
 *
 * **/

public class Leetocde_70_ClimbingStairs {
    private int[] dp = new int[46];
    public int climbStairs(int n) { // recursive
        if (n <= 2) return n;
        if (dp[n] != 0) return dp[n];
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        dp[n] = result;
        return result;
    }

    /**
     * dp:
     *      dp list
     *      recursion
     *      dp formula
     * **/

    public int climbStairs2(int n) { // iterative
        if (n <= 2) return n;
        int first = 1, second = 2;
        for (int i = 2; i < n; i++) {
            int current = first + second;
            first = second;
            second = current;
        }
        return second;
    }
}
