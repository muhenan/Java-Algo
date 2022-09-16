package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.Backtracking;

import java.util.*;

/***
 * 和 39 不一样，元素不能重复用
 *
 * 和 47 有相似之处，给的数组里有重复元素
 *
 *
 * 同样的意思，先排序，0 3 3 3，要用一个 3 时，保证前面的没有没用过的 3。
 * ***/

public class Leetcode_40_CombinationSumII {
    private int lengthOfNum;
    private List<List<Integer>> res;
    private List<Integer> tempOne;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        lengthOfNum = candidates.length;
        res = new LinkedList<>();
        tempOne = new LinkedList<>();
        Arrays.sort(candidates);
        boolean[] hasVisited = new boolean[lengthOfNum];
        bt(candidates, hasVisited,target, 0);
        return res;
    }
    private void bt(int[] nums,boolean[] hasVisited, int rest, int start) {
        if (rest == 0) {
            res.add(new ArrayList<>(tempOne));
            return;
        } else if (rest < 0) {
            return;
        } else {
            for (int i = start; i < lengthOfNum; i++) {
                if (hasVisited[i] || (i != 0 && nums[i] == nums[i - 1] && !hasVisited[i - 1])) continue;
                else {
                    hasVisited[i] = true;
                    tempOne.add(nums[i]);
                    bt(nums, hasVisited, rest - nums[i], i + 1);
                    tempOne.remove(tempOne.size() - 1);
                    hasVisited[i] = false;
                }
            }
        }
        return;
    }
}
