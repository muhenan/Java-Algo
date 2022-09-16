package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.Backtracking;

import java.util.*;

/**
 * 有重复元素，结合 hasVisited
 *
 * 先排序，判断前一个相同的是否 visited
 *
 * **/

public class Leetcode_90_SubsetsII {
    private List<List<Integer>> res;
    private List<Integer> tempOne;
    private int lengthOfNums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        lengthOfNums = nums.length;
        tempOne = new LinkedList<>();
        res = new LinkedList<>();

        res.add(new ArrayList<>(tempOne));

        Arrays.sort(nums);

        boolean[] hasVisited = new boolean[lengthOfNums];

        for (int i = 0; i < lengthOfNums; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = 0; j < lengthOfNums; j++) hasVisited[j] = false;
            bt(nums, i, hasVisited);
        }

        return res;
    }
    private void bt(int[] nums, int index, boolean[] hasVisited) {
        if ((index != 0 && nums[index] == nums[index - 1] && !hasVisited[index - 1]) || index >= lengthOfNums) {
            return;
        } else {
            tempOne.add(nums[index]);
            hasVisited[index] = true;
            res.add(new ArrayList<>(tempOne));
            for (int i = index + 1; i < lengthOfNums; i++) {
                bt(nums, i, hasVisited);
            }
            hasVisited[index] = false;
            tempOne.remove(tempOne.size() - 1);
        }
    }

    public static void main(String[] args) {
        Leetcode_90_SubsetsII solu = new Leetcode_90_SubsetsII();
        int[] nums = new int[]{1,2,2};
        solu.subsetsWithDup(nums);
    }
}
