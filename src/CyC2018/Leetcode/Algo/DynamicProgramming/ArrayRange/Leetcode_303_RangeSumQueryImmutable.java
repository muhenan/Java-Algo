package CyC2018.Leetcode.Algo.DynamicProgramming.ArrayRange;

/**
 * 易
 *
 * 初始化的时候直接吧各个地方的求和都算一遍即可
 * */
public class Leetcode_303_RangeSumQueryImmutable {
}
class NumArray {

    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}