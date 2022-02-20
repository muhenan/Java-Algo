package CyC2018.Leetcode.DataStructure.ArrayAndMatrix;

// 经典题目，一遍遍历
// 遍历的过程中进行计数

public class Leetcode_485_MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        if (length < 1) return 0;
        int max = 0;
        int curr = 0;
        for (int i  = 0; i < length; i++) {
            if (nums[i] == 1) {
                curr++;
                max = Math.max(max, curr);
            } else {
                curr = 0;
            }
        }
        return max;
    }
}
