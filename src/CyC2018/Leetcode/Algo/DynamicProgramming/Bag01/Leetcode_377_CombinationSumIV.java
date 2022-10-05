package CyC2018.Leetcode.Algo.DynamicProgramming.Bag01;

import java.util.Arrays;

/**
 * 保持原生，注意时间复杂度是个好的习惯
 * 但很多时候，我们的第一步是尽量用短的时间把题做出来
 * 这就要求我们熟练用一些已有的强大的数据结构和函数帮我们解决问题
 * 有时间写一个 Java 内置数据结构和函数的使用速查表
 * */
public class Leetcode_377_CombinationSumIV {
    /**
     * 完全背包问题
     * 记录所以 OK 的组合，并且不同的顺序都算不同的组合
     * */

    /**
     * DP 问题，时间复杂度已经是妥妥的平方了
     * 所以不用再在乎排序的 nlogn 了，大胆用上排序即可
     *
     * 这个 sort 很多人都是随便用的，需要的时候就大胆用吧
     *
     * 递归方法超时，函数递归调用还是太耗时了
     * */
    int[] dp;
//    public int combinationSum4(int[] nums, int target) {
//        dp = new int[target + 1];
//        dp[0] = 1;
//        Arrays.sort(nums);
//        return compute(nums, target);
//    }
//    private int compute(int[] nums, int target) {
//        if (dp[target] != 0) return dp[target];
//        for (int num:nums) {
//            if (num <= target) {
//                dp[target] += compute(nums, target - num);
//            } else {
//                break;
//            }
//        }
//        return dp[target];
//    }

    /**
     * 直接 buttom-up 双 for 方法
     * 没有多余的运算和验证，且没有函数递归调用
     * 速度最快！
     * */
    public int combinationSum41(int[] nums, int target) {
        dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++)
            for (int num:nums) {
                if (num <= i) dp[i] += dp[i - num];
                else break;
            }
        return dp[target];
    }



    public int combinationSum42(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] maximum = new int[target + 1];
        maximum[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length && nums[j] <= i; j++) {
                maximum[i] += maximum[i - nums[j]];
            }
        }
        return maximum[target];
    }
}
