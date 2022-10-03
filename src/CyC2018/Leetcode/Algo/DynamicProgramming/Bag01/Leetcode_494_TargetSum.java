package CyC2018.Leetcode.Algo.DynamicProgramming.Bag01;

/**
 * DP 题的一个特点就是
 * 做这个题，你就必须要尝试所有可能的结果
 * 这种题一般要用 DP 做
 * */

import java.util.HashMap;

/**
 * 这题和 416 情况一样
 * 0 1 背包拿物品，填满恰好的容积
 * */
public class Leetcode_494_TargetSum {
    /**
     * 自解方法，算是用了 DP，用了 HashMap 来存所有的可能结果
     * 更新 HashMap 的过程，用了 BO 中更新容器的手法
     * 尝试了所有可能最后得到答案
     *
     * 时间效率一般
     * */
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Integer, Integer> my_map = new HashMap<>();
        if (nums[0] == 0) my_map.put(0, 2);
        else {
            my_map.put(nums[0], 1);
            my_map.put(-nums[0], 1);
        }
        for (int i = 1; i < nums.length; i++) {
            HashMap<Integer, Integer> new_map = new HashMap<>();
            for (Integer k : my_map.keySet()) {
                int plus = k + nums[i];
                int minus = k - nums[i];
                if (new_map.containsKey(plus)) {
                    new_map.put(plus, new_map.get(plus) + my_map.get(k));
                } else new_map.put(plus, my_map.get(k));
                if (new_map.containsKey(minus)) {
                    new_map.put(minus, new_map.get(minus) + my_map.get(k));
                } else new_map.put(minus, my_map.get(k));
            }
            my_map = new_map;
        }
        return my_map.getOrDefault(target, 0);
    }

    /**
     * Cyc 方法，转换为 0 1 背包问题
     * 发现
     * sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     * 2 * sum(P) = target + sum(nums)
     * sum(P) = (target + sum(nums)) / 2
     *
     * 也就是说我们知道了要找的子数组的 sum
     *
     * 我们的任务是找到有多少种可能是子数组 sum 是那个特定的值
     *
     * */

    public int findTargetSumWays2(int[] nums, int S) {
        int sum = computeArraySum(nums); // 求和整个数组
        if (sum < S || -sum > S || (sum + S) % 2 == 1) {
            return 0;
        }
        int W = (sum + S) / 2;
        int[] dp = new int[W + 1]; // dp[i] 记录子数组的 sum 是 i，有几种情况
        dp[0] = 1; // sum 是 0 只有一种情况，什么也不拿
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
                /**
                 * 最最关键的还是这两个 for 要看懂
                 * 这句 dp[i] = dp[i] + dp[i - num]; 就是说
                 * dp[i] =
                 * dp[i] 不拿这个 num，之前就已经得到的 重量 为 i 的种类
                 * + 加
                 * dp[i - num] 拿这个 num，拿之前，重量为 i - num 的种类
                 * */
            }
        }
        return dp[W];
    }
    /**
     * 通过分析和归纳，让题目变成简单的背包问题后，确实时间效率高很多
     * */

    private int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }


    /**
     * DFS 直接递归的方法
     * 思路非常简单！
     * 也非常值得学习！
     *
     * 时间效率极低，时间是自解方法的 10 倍，是 dp 数组方法的 500 倍
     * */
    public int findTargetSumWay3(int[] nums, int S) {
        return findTargetSumWays(nums, 0, S);
    }

    private int findTargetSumWays(int[] nums, int start, int S) {
        if (start == nums.length) {
            return S == 0 ? 1 : 0;
        }
        return findTargetSumWays(nums, start + 1, S + nums[start])
                + findTargetSumWays(nums, start + 1, S - nums[start]);
    }

    public static void main(String[] args) {
        Leetcode_494_TargetSum solu = new Leetcode_494_TargetSum();
        solu.findTargetSumWays(new int[]{1,1,1,1,1}, 3);
    }
}
