package CyC2018.Leetcode.Algo.BinarySearch;

/**
 * 这里说一点，计算机的 int 的除法，其实是默认让你偏左放的
 *      如果 0 1 2 3 4 找 mid，那么 mid 肯定是 2
 *      但是如果 0 1 2 3 找 mid，mid 就变成了 1
 * **/

// 变种的二分查找，数组里有重复的，找最左的和最右的

public class Leetcode_34_FindFirstandLastPositionofK {

    /**
     * 找这个数，找不到的话返回 -1，找到的话，返回最左的那个的 index
     * **/
    private int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2; // int 除法 默认是便往左放的
            if (nums[mid] == target) right = mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return nums[left] == target ? left : -1;
    }

    /**
     * 找这个数，找不到的话返回 -1，找到的话，返回最右的那个的 index
     * **/
    private int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) % 2 == 1 ? (right - left + 1) / 2 : (right - left) / 2); // 改写一下，让其偏右放
            if (nums[mid] == target) left = mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return nums[left] == target ? left : -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int indexOfLeft = searchLeft(nums, target);
        if (indexOfLeft == - 1) return new int[]{-1, -1};
        int indexOfRight = searchRight(nums, target);
        return new int[]{indexOfLeft, indexOfRight};
    }

    /**
     * 到目前为止，要解题的话已经有非常多办法可以简单解题了，我们可以根据 searchLeft 有没有查到，再做后续的操作
     * 现在我们讨论一下二分查找的变种
     * **/


    /**
     * 如果是能找到的话，肯定能找去最左的一个
     * 如果找不到
     *      如果有比它大的，找到比这个数大的最小的那个
     *      如果没有比它大的，最后 left 指着 nums.length，也就是出去了
     * **/
    // 二分查找查找 等于这个数的最左的数，或者大于这个数的第一个数
    private int findFirst(int[] nums, int target) {
        int low = 0, high = nums.length;
        /**
         * 注意 h 的初始值，这里是为了面对数组里只有一个元素的情况，这样也可以判断一个的了
         * 正是因为 high = nums.length 开始，所以如果所有元素都小于 target 的时候，最后会有 low = high = nums.length
         * 但是无论如何都没有 low 或 high 小于 0 的情况，因为都在 [0, nums.length]
         */
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int[] searchRange2(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findFirst(nums, target + 1) - 1;
        if (first < nums.length && nums[first] == target) return new int[]{first, last}; // 如果正常找到的情况
        return new int[]{-1, -1}; // 剩的这种情况就是找不到的情况
    }

    public static void main(String[] args) {
        Leetcode_34_FindFirstandLastPositionofK solu = new Leetcode_34_FindFirstandLastPositionofK();
        solu.searchRange2(new int[]{5,7,7,8,8,10}, 8);
    }
}
