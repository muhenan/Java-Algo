package CyC2018.Leetcode.Algo.BinarySearch;

// 简单的二分查找，最后 low 和 high 走到一个低的小数组里 返回 nums[low]

public class Leetcode_153_FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        while (nums[low] > nums[high]) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        return nums[low];
    }
}
