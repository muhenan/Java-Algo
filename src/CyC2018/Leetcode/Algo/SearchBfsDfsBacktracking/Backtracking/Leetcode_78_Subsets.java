package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.Backtracking;

import java.util.*;

/**
 *
 * 子集这个题目太易，没有半点难度，每一次 backtracking 时 都 add 一次结果
 *
 * */

public class Leetcode_78_Subsets {
    private List<List<Integer>> res;
    private List<Integer> tempOne;
    private int lengthOfNums;

    public List<List<Integer>> subsets(int[] nums) {
        lengthOfNums = nums.length;
        tempOne = new LinkedList<>();
        res = new LinkedList<>();
        res.add(new ArrayList<>(tempOne));
        for (int i = 0; i < lengthOfNums; i++) backtracking(nums, i);
        return res;
    }

    private void backtracking (int[] nums, int index) {
        if (index >= lengthOfNums) return;
        tempOne.add(nums[index]);
        res.add(new ArrayList<>(tempOne));
        for (int i = index + 1; i < lengthOfNums; i++) {
            backtracking(nums, i);
        }
        tempOne.remove(tempOne.size() - 1);
    }

}
