package Array;

import java.util.*;

public class Array {

    // 283
    // 把数组中的 0 移到末尾
    // given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
    // 最简单的不占用内存空间的做法
    // 直接一遍遍历，不是0的直接向前赋值，这是数组这边的一个常用思想

    // 这样也可以保证了数组的顺序

    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }


    //给定一个包含n + 1 个整数的数组nums ，其数字都在 1 到 n之间（包括 1 和 n），可知至少存在一个重复的整数。
    //
    //假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
    //

    //最简单的这里有 O(N) 的 哈希的方法


    //更简单的是二分查找的方法
    //我们可以查找小于等于 i 的数字有多少个
        //如果刚好等于i，说明答案比 i 大
        //如果大于i，说明答案是小于i的
    public int findDuplicate(int[] nums) {
        int l = 1, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) cnt++;
            }
            if (cnt > mid) h = mid - 1;
            else l = mid + 1;
        }
        return l;
    }


    //56. 合并区间
    //首先是按照区间的起点来排序的
    //然后弄了一个足够长的二维数组
    //但是返回的时候返回的是 copyOf 也就是只返回来一部分
    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

    //152. 乘积最大子数组
    //关键点就是这句话：“由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin。”
    //维护当前的最大值，有史以来的最大值，当前的最小值
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
}
