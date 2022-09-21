package CyC2018.Leetcode.Algo.DynamicProgramming.Fabonacci;

public class Leetcode_213_HouseRobberII {
    /**
     * 自解方法（genbnewudi），两个 dp 表解决问题
     * 最后一个元素用的算式和中途的不同
     * **/
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        int[] dp_with_first = new int[length + 1];
        int[] dp_without_first = new int[length + 1];
        dp_with_first[0] = nums[0];
        dp_without_first[0] = 0;
        dp_with_first[1] = nums[0];
        dp_without_first[1] = nums[1];
        for (int i = 2; i < length - 1; i++) {
            dp_with_first[i] = Math.max(dp_with_first[i - 2] + nums[i], dp_with_first[i - 1]);
            dp_without_first[i] = Math.max(dp_without_first[i - 2] + nums[i], dp_without_first[i - 1]);
        }
        dp_with_first[length - 1] = Math.max(dp_with_first[length - 3], dp_with_first[length - 2]);
        dp_without_first[length - 1] = Math.max(dp_without_first[length - 3] + nums[length - 1], dp_without_first[length - 2]);
        return Math.max(dp_with_first[length - 1], dp_without_first[length - 1]);
    }


    /**
     * Cyc 解法
     * 往 1 版本上套
     * 第一个和最后一个肯定有一个不选，所以用两次 1 的函数
     * 一次不算最后一个，一次不算第一个
     * **/
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    private int rob(int[] nums, int first, int last) {
        int pre2 = 0, pre1 = 0;
        for (int i = first; i <= last; i++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
