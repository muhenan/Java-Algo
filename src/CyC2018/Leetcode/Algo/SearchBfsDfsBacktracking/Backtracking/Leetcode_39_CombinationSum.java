package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.Backtracking;

import java.util.*;

public class Leetcode_39_CombinationSum {

    private int lengthOfNum;
    private List<List<Integer>> res;
    private List<Integer> tempOne;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        lengthOfNum = candidates.length;
        res = new LinkedList<>();
        tempOne = new LinkedList<>();
        Arrays.sort(candidates);
        bt(candidates, target, 0);
        return res;
    }

    private void bt(int[] nums, int rest, int start) {
        if (rest == 0) {
            res.add(new ArrayList<>(tempOne));
            return;
        } else if (rest < 0) {
            return;
        } else {
            for ( int i = start; i < lengthOfNum; i++) {
                tempOne.add(nums[i]);
                bt(nums, rest - nums[i], i); // 这里带的还是原来这个数，就说明选了这个数了，还可以再选这个数
                tempOne.remove(tempOne.size() - 1);
            }
        }
    }

    /***
     *
     * Easy，正常回溯即可，一个注意的点，start，每次往前推
     *
     * ***/

}
