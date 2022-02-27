package CyC2018.Leetcode.DataStructure.BinarySearch;

// 经典无比的一道题目

// 最简单的方法就是一个一个的算平方，最粗暴的方法，时间复杂度是线性

// 这道题当然不是让我们用线性做的，用二分查找的方法，让时间复杂度到 log

/**
 * 从二分查找的角度，这道题相当于让我们找：
 *      如果可以找到这个数的话，找到这个数
 *      如果找不到这个数的话，找到比这个数小的最大的一个
 *      经典变种一点点的二分查找！
 *
 *      不要用暴力的 mid * mid ，太大了会炸掉，用除的
 *
 *      涉及到了好几个关键的点：
 *          1. 直接乘可能会炸掉，要用除
 *          2. 除的话就要考虑到可能会抹数的情况，这里是 int 的除
 * **/

public class Leetcode_69_Sqrtx { // 这里的边界真的不好控制，这是重点，务必认真思考！！！


    public int mySqrt(int x) {
        if (x <= 1) return x;
        int low = 1;
        int high = x;
        int mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (x / mid == x) {
                return mid;
            } else if (x / mid < x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (low <= x / low ? low : low - 1);
    }

    // Cyc 大佬代码
    /**
     * 最后这个返回 high 是精髓中的精髓
     * 首先我们明白最后返回的时候是 high 比 low 小 1
     * 如果最后 high 和 low 相等的时候，指的那个数是小于的，那么这个数就是答案，这个时候 low 变化了，high 还指着答案
     * 如果最后 high 和 low 相等的时候，指的那个数是大于的，那么比这个数小 1 的就是答案，high - 1 一下，那么 high 刚好指着答案
     * **/
    public int mySqrt2(int x) {
        if (x <= 1) return x;
        int low = 1, high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid; // 这里能理解，等于的话直接返回
            } else if (mid > sqrt) { // 说明 mid 大了
                high = mid - 1;
            } else { // 说明 mid 小了
                low = mid + 1;
            }
        }
        return high;
    }
}
