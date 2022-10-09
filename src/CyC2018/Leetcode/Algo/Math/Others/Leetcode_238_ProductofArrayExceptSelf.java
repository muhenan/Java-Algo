package CyC2018.Leetcode.Algo.Math.Others;

import java.util.Arrays;

public class Leetcode_238_ProductofArrayExceptSelf {
    /**
     * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     *
     * 搞两个数组，把从两边乘的都记录了
     *
     * 居然秒过。。。
     * */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];
        int leftOne = 1;
        for (int i = 0; i < length - 1; i++) {
            left[i] = (leftOne *= nums[i]);
        }
        int rightOne = 1;
        for (int i = length - 1; i >= 1; i--) {
            right[i] = (rightOne *= nums[i]);
        }
        res[0] = right[1];
        res[length - 1] = left[length - 2];
        for (int i = 1; i < length - 1; i++) {
            res[i] = left[i - 1] * right[i + 1];
        }
        return res;
    }

    /**
     * 空间优化了一下
     * 走了两遍，第二次走的时候就把结果算出来了
     * */
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] products = new int[n];
        Arrays.fill(products, 1);
        int left = 1;
        for (int i = 1; i < n; i++) {
            left *= nums[i - 1];
            products[i] *= left;
        }
        int right = 1;
        for (int i = n - 2; i >= 0; i--) {
            right *= nums[i + 1];
            products[i] *= right;
        }
        return products;
    }
}
