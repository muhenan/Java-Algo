package CyC2018.Leetcode.Algo.BinarySearch;

// 非常经典一个题目

// O(n) 的算法直接找即可，这里我们只讨论 logn 的情况，即二分查找的情况

// 我自己的解法是用先走到一个正常数组里，然后在这个数组里二分查找

//33. 搜索旋转排序数组
//首先处理了数组空的情况和只有一个元素的情况，这是好习惯
//然后就是考虑二分查找
/*
 * 二分查找
 * 主要就是考虑一个事
 * 什么情况下往左边走，什么情况下往右边走，把这个考虑明白就OK，这就是二分查找的精髓
 * */

/**
 * 这道题没有很难，就是一个变种的，换了一个复杂排序形式数组的二分查找
 * 多考虑一些情况，想清楚什么时候往左走，什么时候往右走即可
 * **/

// 代码里的那些 if else 还可以更简单一些，有空再说

public class Leetcode_33_BinarySearch {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 1) {
            if (nums[0] == target) return 0;
            else return -1;
        }
        int left = 0;
        int right = length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) { // 目标值小于中间的数
                if (nums[left] < nums[right] || nums[mid] < nums[left]) right = mid - 1;
                else if (target > nums[right]) right = mid - 1;
                else left = mid + 1;
            } else { // 目标值大于中间的数
                if (nums[left] < nums[right] || nums[mid] > nums[left]) left = mid + 1;
                else if (target > nums[right]) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode_33_BinarySearch solu = new Leetcode_33_BinarySearch();
        solu.search(new int[]{4,5,6,7,0,1,2}, 0);
    }

}
