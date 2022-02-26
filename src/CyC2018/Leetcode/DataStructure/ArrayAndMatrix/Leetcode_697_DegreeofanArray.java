package CyC2018.Leetcode.DataStructure.ArrayAndMatrix;

// 个人感觉非常简单的一个题目，是走几遍计数

// 方法一，自解方法，也是哈希表的思想，走几遍计数，但是最后搞得走的太多了，用时很长，因为自己用的最简单是数据结构数组，所以操作就复杂了很多

// 方法二，leetcode 官方方法，也是哈希的思想，但是用的是高级一点的数据结构，用的是 HashMap 并且是 数字 int 对 数组 int[]，数组中是各种信息
// 总的来说这次的话相当于走两遍就搞定了

// 方法三，当然也可以就一个 for，边统计边更新，简单想一下，非常简单，做好记录就好

import java.util.HashMap;
import java.util.Map;

public class Leetcode_697_DegreeofanArray {
    public int findShortestSubArray(int[] nums) {
        int length = nums.length;
        int[] counts = new int[50000];
        for (int element: nums) counts[element]++;
        int max = 0;
        int numberOfValue = 0;
        int[] values = new int[50000];
        for (int i = 0; i < 50000; i++) {
            if (counts[i] > max) {
                max = counts[i];
            }
        }
        for (int i = 0; i < 50000; i++) {
            if (counts[i] == max) {
                values[numberOfValue++] = i;
            }
        }
        int result = 50000;
        for (int i = 0; i < numberOfValue; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < length; j++) {
                if (nums[j] == values[i]) {
                    left = j;
                    break;
                }
            }
            for (int j = length - 1; j >= 0; j--) {
                if (nums[j] == values[i]) {
                    right = j;
                    break;
                }
            }
            if (right - left + 1 < result) result = right - left + 1;
        }
        return result;
    }

    public int findShortestSubArray2(int[] nums) {
        int length = nums.length;
        HashMap<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i - map.get(nums[i])[1] + 1;
            } else {
                map.put(nums[i], new int[]{1, i, 1});
            }
        }
        int result = 50000;
        int max = 0;
        for (Map.Entry<Integer, int[]> entry: map.entrySet()) {
            int[] arr = entry.getValue();
            if (arr[0] > max) {
                max = arr[0];
                result = arr[2];
            } else if (arr[0] == max) {
                if (arr[2] < result) result = arr[2];
            }
        }
        return result;
    }
}
