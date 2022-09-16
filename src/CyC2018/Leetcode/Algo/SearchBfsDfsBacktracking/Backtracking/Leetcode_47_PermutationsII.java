package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.Backtracking;

import java.util.*;

public class Leetcode_47_PermutationsII {

    private int lengthOfNum;
    private List<List<Integer>> res;
    private List<Integer> tempOne;

    public List<List<Integer>> permuteUnique(int[] nums) {
        lengthOfNum = nums.length;
        res = new LinkedList<>();
        tempOne = new LinkedList<>();

        Arrays.sort(nums);
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
                if (i == 0 || nums[i] != nums[i - 1] || hasVisited[i - 1]) {
                    tempOne.add(nums[i]);
                    hasVisited[i] = true;
                    backtracking(nums, hasVisited, tempOne);
                    tempOne.remove(tempOne.size() - 1);
                    hasVisited[i] = false;
                }
            }
        }
    }

    /***
     *
     * 数组元素可能含有相同的元素，进行排列时就有可能出现重复的排列，要求重复的排列只返回一个。
     *
     * 在实现上，和 Permutations 不同的是要先排序，然后在添加一个元素时，判断这个元素是否等于前一个元素，如果等于，并且前一个元素还未访问，那么就跳过这个元素。
     *
     * ***/
}
