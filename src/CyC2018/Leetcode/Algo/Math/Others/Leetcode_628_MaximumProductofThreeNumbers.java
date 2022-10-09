package CyC2018.Leetcode.Algo.Math.Others;

import java.util.Arrays;

public class Leetcode_628_MaximumProductofThreeNumbers {
    /** 看了一眼提示，直接排序做了，以后要有这个意识，多排序，快速的解决问题 */
    public int maximumProduct(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[length - 1] * nums[length - 2] * nums[length - 3], nums[0] * nums[1] * nums[length - 1]);
    }

    /** 研究一个 O(N) 的方法 */
    /**
     * 找到最大的三个数，最小的两个数，就行了
     *
     * 快了很多，只走一遍
     * */
    public int maximumProduct2(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
}
