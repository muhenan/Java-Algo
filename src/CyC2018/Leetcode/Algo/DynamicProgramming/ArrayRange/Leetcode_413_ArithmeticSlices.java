package CyC2018.Leetcode.Algo.DynamicProgramming.ArrayRange;

public class Leetcode_413_ArithmeticSlices {
    //第一反应，dp的方法没想到，倒是想到了一个直接一边走完的贪心的方法

    //想个 dp 方法
    public int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        if (length <= 2) return 0;
        int[][] dp = new int[2][length]; // 0 result 1 result end with i
        if (nums[2] - nums[1] == nums[1] - nums[0]) dp[0][2] = dp[1][2] = 1;
        for (int i = 3; i < length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[1][i] = dp[1][i - 1] + 1;
                dp[0][i] = dp[1][i] + dp[0][i - 1];
            }
            else {
                dp[1][i] = 0;
                dp[0][i] = dp[0][i - 1];
            }
        }
        return dp[0][length - 1];
    }
    /**
     * 直接过了，易
     * 只需记录，这个点到 0 的答案是什么，和已这个点结束的结果有多少个
     * */
    // Cyc 的方法和我们差不多，相当于只记录了 dp 1 然后最后再求和
}
