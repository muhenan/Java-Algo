package Problems;

public class Leetcode_2411 {
    // 暴力 n2 败北
//    public int[] smallestSubarrays(int[] nums) {
//        int length = nums.length;
//        int[] maxArr = new int[length];
//        int max = 0;
//        for (int i = length - 1; i >= 0; i--) {
//            max |= nums[i];
//            maxArr[i] = max;
//        }
//        int[] result = new int[length];
//        for (int i = 0; i < length; i++) {
//            int count = 1;
//            int temp = nums[i];
//            int j = i + 1;
//            while (temp != maxArr[i]) {
//                temp |= nums[j];
//                j++;
//                count++;
//            }
//            result[i] = count;
//        }
//        return result;
//    }

    /**
     * On
     * 从后往前来
     * 最短的距离是由贡献 1 的最远位置决定
     *
     * 我们记录一下从这位到最后都有哪些 1 出现了
     * 并用一个 dp 数组记录贡献这个 1 的最近的那个元素的 index
     * */
    public int[] smallestSubarrays(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int[] dp = new int[32]; // 记录这个 1 出现的最近的位置 （因为是 int 最多有 32 个 1）
        for (int ele : dp) ele = -1; // -1 表示这个 1 还没出现
        for (int i = length - 1; i >= 0; i--) {
            int count = 1;
            for (int j = 0; j < 32; j++) { // 测所有可能的 32 位 1
                if (((nums[i] >> j) & 1) == 1) { // 如果 i 的这一位是 1，更新这一位的 dp 为 i
                    dp[j] = i;
                }
                if (dp[j] != -1) { // 这个 1 出现过，通过这个 1 出现的最近位置更新一下距离
                    count = Math.max(count, dp[j] - i + 1);
                }

            }
            result[i] = count;
        }
        return result;
    }



    /**
     * 每次都想象成当前的 i 就是数组的最后一个，也就是新加的一个
     * 在这个的基础上更新前面的所有元素
     * 如果或一下不影响前面的值，说明新加的这个元素没有提供新 1，答案不变
     * 如果影响了，说明提供了新一，根据这个元素的 index 更新答案
     * */
    public int[] smallestSubarrays2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            ans[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[j] | x) == nums[j]) break;
                nums[j] |= x;
                ans[j] = i - j + 1;
            }
        }
        return ans;
    }
}

// 521 521 521 521 521
// 123 89 78 34 23 12 7 5 1
// 3 3 3 3 3

// 3 2