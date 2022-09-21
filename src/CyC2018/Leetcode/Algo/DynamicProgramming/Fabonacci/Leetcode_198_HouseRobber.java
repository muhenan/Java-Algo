package CyC2018.Leetcode.Algo.DynamicProgramming.Fabonacci;

/**
 * dp[i] = max(dp[i-2] + nums[i], dp[i-1])
 * **/
public class Leetcode_198_HouseRobber {


    // 题目比较简单，先学 Cyc 写个循环形式 （这里能写个简单的循环，因为你用这个 dp[i] 的时候只用到前两个）
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        int dp_i_minus2 = nums[0], dp_i_minus1 = Math.max(nums[0], nums[1]);
        int result = 0;
        for (int i = 2; i < length; i++) {
            result = Math.max(dp_i_minus2 + nums[i], dp_i_minus1);
            dp_i_minus2 = dp_i_minus1;
            dp_i_minus1 = result;
        }
        return result;
    }

    // in my opinion, 循环不是长久之际，还是要学会写递归的

    public static void main(String[] args) {
        Leetcode_198_HouseRobber solu = new Leetcode_198_HouseRobber();
        solu.rob(new int[]{2,1,1,2});
    }

    /**
     * 这里放一个 dp 表的写法吧，不要忘了 dp
     * 但是对于这道题来说，dp 表占了更多的空间，完全可以优化
     * **/
    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 子问题：
        // f(k) = 偷 [0..k) 房间中的最大金额

        // f(0) = 0
        // f(1) = nums[0]
        // f(k) = max{ rob(k-1), nums[k-1] + rob(k-2) }

        int N = nums.length;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int k = 2; k <= N; k++) {
            dp[k] = Math.max(dp[k-1], nums[k-1] + dp[k-2]);
        }
        return dp[N];
    }
}
