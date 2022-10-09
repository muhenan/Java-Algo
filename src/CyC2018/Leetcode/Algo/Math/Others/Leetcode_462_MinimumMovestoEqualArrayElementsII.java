package CyC2018.Leetcode.Algo.Math.Others;

import java.util.Arrays;

public class Leetcode_462_MinimumMovestoEqualArrayElementsII {
    /**
     * 这是个典型的相遇问题，移动距离最小的方式是所有元素都移动到中位数。理由如下：
     *
     * 设 m 为中位数。a 和 b 是 m 两边的两个元素，且 b > a。要使 a 和 b 相等，它们总共移动的次数为 b - a，
     * 这个值等于 (b - m) + (m - a)，也就是把这两个数移动到中位数的移动次数。
     *
     * 设数组长度为 N，则可以找到 N/2 对 a 和 b 的组合，使它们都移动到 m 的位置。
     *
     * 所以可以说，找到中位数即完成任务
     * */
    public int minMoves2(int[] nums) {
        /** 不要总害怕排序，上来直接排序一下能把题做出来也可以，也没问题，大不了时间复杂度 NlogN 罢了
         *  比如下面这个解法，就非常非常优雅
         *  最小的对最大的，要使这两个相等，要操作对步数是一定的
         * */
        Arrays.sort(nums);
        int move = 0;
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            move += nums[h] - nums[l];
            l++;
            h--;
        }
        return move;
    }

    /** 接下来用一种方式，用 O(N) 的时间复杂度找到 中位数
     *
     *  使用快速选择，找中位数
     *
     *  使用快速选择，同 kth 问题
     *
     * */

    /**
     * 这个方法要用心学，结合了快速排序中的快速选择
     *
     * 找的不一定是中位数，找的是 kth smallest
     *
     * 如果一共奇数个，找的是中位数，如果是偶数个，找的是小的那一个就行
     *
     * */

    public int minMoves22(int[] nums) {
        int move = 0;
        int median = findKthSmallest(nums, nums.length / 2);
        for (int num : nums) {
            move += Math.abs(num - median);
        }
        return move;
    }

    private int findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) { // 每次都弄到新的区间里
            int j = partition(nums, l, h);
            if (j == k) { // 刚好是 k
                break;
            }
            if (j < k) { // k 还在右边，l 往右走
                l = j + 1;
            } else { // k 还在左边，h 往左走
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int l, int h) {
        int i = l, j = h + 1; // 刚开始都阔一下，因为之后要先减或者加，再比
        while (true) {
            while (nums[++i] < nums[l] && i < h) ;
            while (nums[--j] > nums[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j); // 最后 j 肯定到从右边数，第一个小于 l 的数
        return j;
    }

    private void swap(int[] nums, int i, int j) { // swap
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 事实证明，在实际的操作中，排序的远远更快
     * */

}
