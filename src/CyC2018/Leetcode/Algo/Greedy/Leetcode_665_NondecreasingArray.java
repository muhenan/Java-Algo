package CyC2018.Leetcode.Algo.Greedy;

/**
 * 不要着急，这种题目，分情况讨论，把大的问题拆分成小的问题，贪心，局部最优
 * 每次遇到递减情况的时候，我们都希望是降低左边那个（如果可以的话），这样就能尽量不影响后面的
 * 但是不行的时候，为了保证局部最优，即局部达到要求，我们就必须提高右边那个，即使这样可能对后续的数组造成影响
 * **/

public class Leetcode_665_NondecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int length = nums.length;
        if (length <= 2) return true;
        int count = 0;
        for (int i = 1; i < length && count < 2; i++) {
            if (nums[i] >= nums[i - 1]) continue;
            count++;
            if (i > 1 && nums[i - 2] > nums[i]) {
                /**
                 * 这里就是深刻的局部最优的思想，虽然我希望我是尽量能弄 nums[i - 1] = nums[i]
                 * 但是这种情况下，为了保证不递减，我就必须弄 nums[i] = nums[i - 1] ，升高 nums[i]
                 * 这里就是在这种特殊情况下，我们不管后面的数组是什么样的，我们为了保证局部最优，我们必须这么做
                 * **/
                nums[i] = nums[i - 1];
            } else nums[i - 1] = nums[i];
        }
        return count <= 1;
    }
}
