package CyC2018.Leetcode.Algo.DynamicProgramming.Bag01;

public class Leetcode_416_PartitionEqualSubsetSum {
    /**
     * 不要老想着，让两个子集各自的和相等
     * 让一个子集的和，等于总的和的一半就行了
     * */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int W = sum / 2;
        boolean[] dp = new boolean[W + 1]; // dp[i] 表示 质量 i 能否被填满
        dp[0] = true;
        /**
         * 下面的逻辑是，用这个物品，能填满多少可能的质量
         * */
        for (int num : nums) {                 // 0-1 背包一个物品只能用一次
            for (int i = W; i >= num; i--) {   // 从后往前，先计算 dp[i] 再计算 dp[i-num]
                //dp[i] = dp[i] || dp[i - num]; 下面的那种写法比上面这种快了非常多
                dp[i] |= dp[i - num];
            }
        }
        return dp[W];
    }
}
