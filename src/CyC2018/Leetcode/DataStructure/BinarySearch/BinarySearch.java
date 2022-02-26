package CyC2018.Leetcode.DataStructure.BinarySearch;


// 只要是排序的数组，那么一般就肯定考虑二分查找
// 不是排序的，也要思考可不可以二分查找

public class BinarySearch {


    //最基础的二分查找的方法！！！
    //而且这里使用的是循环，不是递归哦
    //循环主要是循环的 low 和 high
    //只要是符合 low <= high 就继续操作
    /**
     * 如果相等，那么说明我们找到了
     * 如果大于，那么说明目标在左侧，而且 mid 肯定不是了，所以这时的话 high = mid - 1
     * 剩下的一种就是小于，那么这样的话就 low = mid + 1
     * 最后会缩到 low 和 high 相等，如果这样还没找到，那么 low 或者 high 再变一次，就无法保证
     * 两者的大小关系了，也就是到 low > high 的情况了，也就错误退出了
     * **/
    public int binarySearch(int[] nums, int key) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    //用的是带进来的左右（和上面一样的意思）
    public int binarySearch(int[] nums, int key, int left, int right) {
        int low = left, high = right;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // 变种
    // 二分查找可以有很多变种，实现变种要注意边界值的判断。
    // 例如在一个有重复元素的数组中查找 key 的最左位置的实现如下：（我们假设肯定能找到）
    /**
     * 如果 key <= nums[mid] ，那么说明答案在 mid 左侧并包括 mid
     * 否则的话，肯定在右侧了，且不包括 mid
     * 最后相等的时候退出
     * **/
    public int binarySearchLeftest(int[] nums, int key) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= key) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    // 如果找到的话，正常是 l 和 h 一样
    // 重点就在于，当找到相同的时候，high 赋过去，这样就能保证一直是在往左推进

}
