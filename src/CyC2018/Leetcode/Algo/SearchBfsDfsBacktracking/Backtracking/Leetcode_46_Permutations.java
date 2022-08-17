package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.Backtracking;

import java.util.*;

/**
 *
 * 经典回溯
 *
 * 太简单了，比想象中容易太多
 *
 * */

public class Leetcode_46_Permutations {
    private int lengthOfNum;
    private List<List<Integer>> res;

    private List<Integer> tempOne;

    public List<List<Integer>> permute(int[] nums) {
        lengthOfNum = nums.length;
        res = new LinkedList<>();
        tempOne = new LinkedList<>();
        boolean[] hasVisited = new boolean[lengthOfNum];

        backtracking(nums, hasVisited, tempOne);

        return res;
    }

    private void backtracking (int[] nums, boolean[] hasVisited, List<Integer> tempOne) {
        if (tempOne.size() == lengthOfNum) {
            res.add(new ArrayList<>(tempOne));
        }
        for (int i = 0; i < lengthOfNum; i++) {
            if (!hasVisited[i]) {
                tempOne.add(nums[i]);
                hasVisited[i] = true;
                backtracking(nums, hasVisited, tempOne);
                tempOne.remove(tempOne.size() - 1);
                hasVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Leetcode_46_Permutations solu = new Leetcode_46_Permutations();
        solu.permute(new int[]{1, 2, 3});
    }

}
