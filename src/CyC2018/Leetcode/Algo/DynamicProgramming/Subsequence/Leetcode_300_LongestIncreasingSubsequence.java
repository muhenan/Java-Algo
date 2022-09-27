package CyC2018.Leetcode.Algo.DynamicProgramming.Subsequence;

public class Leetcode_300_LongestIncreasingSubsequence {
    // DP
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int dp[] = new int[length]; // dp [i] 仅表示，已 i 为 LIS 的最后一个，得到的结果是多少
        for (int i = 0; i < length; i++) dp[i] = 1;
        for (int i = 1; i < length; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = 0;
        for (int element: dp) result = Math.max(result, element);
        return result;
    }
    // n2

    // 使用二分查找将时间复杂度降低为 O(NlogN)
    // greedy and binary search
    // 考虑一个简单的贪心，如果我们要使上升子序列尽可能的长，则我们需要让序列上升得尽可能慢，因此我们希望每次在上升子序列最后加上的那个数尽可能的小。
    // 以输入序列 [0, 8, 4, 12, 2][0,8,4,12,2] 为例：
    //
    //第一步插入 00，d = [0]d=[0]；
    //
    //第二步插入 88，d = [0, 8]d=[0,8]；
    //
    //第三步插入 44，d = [0, 4]d=[0,4]；
    //
    //第四步插入 1212，d = [0, 4, 12]d=[0,4,12]；
    //
    //第五步插入 22，d = [0, 2, 12]d=[0,2,12]。
    /**
     * 也就是说你替代的那一个，肯定是前面已经有这个了，你替代也没关系
     * 只是说你找出的可能不是正常的最长子序列，但是长度是没错的
     * 题目的核心就是找到这个长度
     * */
    public int lengthOfLIS2(int[] nums) {
        int length = nums.length;
        int dp[] = new int[length];
        int lastIndexOfDp = 0;
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] > dp[lastIndexOfDp]) {
                dp[++lastIndexOfDp] = nums[i];
                continue;
            }
            int start = 0;
            int end = lastIndexOfDp;
            while (start != end) {
                int mid = (end - start) / 2 + start;
                if (dp[mid] < nums[i]) start = mid + 1;
                else end = mid;
            }
            dp[start] = nums[i];
        }
        return lastIndexOfDp + 1;
    }

    /**
     * 题目给的这个数组必须全部走完，所以时间复杂度无法低于 N
     * dp 的时间复杂度在 n2，太高
     * 思考降到 nlogn
     * 第一个遍历的 n 没法改进，只能在更深层的遍历中用二分查找
     *      二分查找就需要有序的数组，如果开始没有有序的数组，那么毫无疑问，你要自己构建有序的数组
     *
     * 一个非常 tricky 的点在于，dp数组的构造，元素更新的方式
     * */
}
