package CyC2018.Leetcode.Algo.DynamicProgramming.Subsequence;

public class Leetcode_376_WiggleSubsequence {
    /**
     * 第一种方法
     * 还是类似 LIS 的方法一，记录以这个元素结尾的最长的结果（分 high 和 low 两种）
     * 简单写一下，练练 coding 能力
     * */
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        int[] low = new int[length];
        int[] high = new int[length];
        for (int i = 0; i < length; i++) {
            low[i] = 1;
            high[i] = 1;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j]) {
                    low[i] = Math.max(low[i], low[j]);
                    high[i] = Math.max(high[i], high[j]);
                } else if (nums[i] > nums[j]) {
                    high[i] = Math.max(high[i], low[j] + 1);
                } else {
                    low[i] = Math.max(low[i], high[j] + 1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            result = Math.max(result, low[i]);
            result = Math.max(result, high[i]);
        }
        return result;
    }
    /**
     * 通过，但是时间复杂度惨不忍睹
     * */

    /**
     * 要求 On，线性遍历解决问题！！！
     * */
    /**
     * 过！时间效率无敌！
     *
     * 采用了 300 里面更新数组的思想，这里只要更新两个变量即可
     * 一遍走完
     *
     * 思想就是这个更新的思想，答案数组的内容不一定是对的，但是答案数组的长度是对的
     */
    public int wiggleMaxLength2(int[] nums) {
        int length = nums.length;
        if (length == 1) return 1;
        int result = 1;
        int index = 1;
        int current = nums[0];
        while (current == nums[index]) {
            index++;
            if (index == length) break;
        }
        if (index >= length) return result;
        boolean isHigh = (nums[index] > current ? true : false);
        result++;
        current = nums[index];
        for (int i = index + 1; i < length; i++) {
            if (isHigh) {
                if (nums[i] < current) {
                    result++;
                    isHigh = !isHigh;
                }
                current = nums[i];
            } else {
                if (nums[i] > current) {
                    result++;
                    isHigh = !isHigh;
                }
                current = nums[i];
            }
        }
        return result;
    }
}
