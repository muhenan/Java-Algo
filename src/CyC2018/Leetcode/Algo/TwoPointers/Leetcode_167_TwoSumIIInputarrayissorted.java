package CyC2018.Leetcode.Algo.TwoPointers;

/**
 * 利用有序数组的特性，两个指针，一个从头，一个从尾，走就行了，走到答案的时候返回
 * **/

public class Leetcode_167_TwoSumIIInputarrayissorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) break;
            else if (numbers[left] + numbers[right] > target) right--;
            else left++;
        }
        return new int[]{left + 1, right + 1};
    }
}
