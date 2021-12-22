package CyC2018.Leetcode.DataStructure.Hash;

import java.util.HashMap;

/**
 * Leetcode 1. Two Sum E
 * 经典中的经典，热门经典题，hash 经典题
 * 提供了三种解法
 *
 *      1. 暴力 n2 空间 1
 *          双循环，找和符合条件的两个元素
 *
 *      2. 排序的 nlogn 空间 1
 *          先排序，再双指针
 *          可以先对数组进行排序，然后使用双指针方法或者二分查找方法。这样做的时间复杂度为 O(NlogN)，空间复杂度为 O(1)
 *
 *      3. hash n 空间 n
 *          一放一查
 *          拿时间换空间了
 * */


public class Leetcode_1_TwoSum {


    public int[] twoSum1(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    // public int[] twoSum2(int[] nums, int target)

    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> indexForNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexForNum.containsKey(target - nums[i])) {
                return new int[]{indexForNum.get(target - nums[i]), i};
            } else {
                indexForNum.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Leetcode_1_TwoSum solu = new Leetcode_1_TwoSum();
        //solu.twoSum3()
    }
}
