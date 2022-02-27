package CyC2018.Leetcode.Algo.BinarySearch;

/**
 * 最后返回的那个，肯定是第奇数，因为前面肯定有 k 个 2 连组了
 *
 * 不难，一下就做对了
 * 二分查找的思想，结合 index 和前后数的情况，只要知道答案在哪边，要往哪边走就行了
 * **/

public class Leetcode_540_SingleElementinaSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        int low = 0;
        int high = length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
             if (mid % 2 == 0) {
                 if (nums[mid] == nums[mid + 1]) low = mid + 1;
                 else high = mid;
             } else {
                 if (nums[mid] == nums[mid - 1]) low = mid + 1;
                 else high = mid;
             }
        }
        return nums[low];
    }
}
