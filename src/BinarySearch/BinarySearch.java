package BinarySearch;

// 只要是排序的数组，那么一般就肯定是二分查找


// 不是排序的，也要思考是不是二分查找


public class BinarySearch {

    //最基础的二分查找的方法！！！
    //而且这里使用的是循环，不是递归哦
    //循环主要是循环的 low 和 high
    //只要是符合 low <= high 就继续操作
    public int binarySearch(int[] nums, int key) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] == key) {
                return m;
            } else if (nums[m] > key) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    //用的是带进来的左右
    public int binarySearch2(int[] nums, int key, int left, int right) {
        int l = left, h = right;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] == key) {
                return m;
            } else if (nums[m] > key) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    // 变种
    // 二分查找可以有很多变种，实现变种要注意边界值的判断。
    // 例如在一个有重复元素的数组中查找 key 的最左位置的实现如下：
    public int binarySearchLeftest(int[] nums, int key) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= key) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    // 如果找到的话，正常是 l 和 h 一样
    // 重点就在于，当找到相同的时候，high 赋过去，这样就能保证一直是在往左推进



    //33. 搜索旋转排序数组
    //首先处理了数组空的情况和只有一个元素的情况，这是好习惯
    //然后就是考虑二分查找
    /*
    * 二分查找
    * 主要就是考虑一个事
    * 什么情况下往左边走，什么情况下往右边走，把这个考虑明白就OK，这就是二分查找的精髓
    * */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }





}
