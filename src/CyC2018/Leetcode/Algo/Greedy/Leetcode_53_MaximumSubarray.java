package CyC2018.Leetcode.Algo.Greedy;

/**
 * 非常好，用一个精妙的 presum 解决问题
 * 主要思想，如果 presum 是正数，就加上 presum
 * 如果不是正数，就不用 pre 的东西了，从这个元素开始从新立门户
 * 每一步都是追求最优
 * **/

public class Leetcode_53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int presum = nums[0];
        int maxsum = nums[0];
        for (int i = 1; i < length; i++) {
            presum = presum > 0 ? presum + nums[i] : nums[i];
            maxsum = Math.max(maxsum, presum);
        }
        return maxsum;
    }
}
