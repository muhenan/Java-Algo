package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.Backtracking;

import java.util.*;

/**
 * 有了 39 40 的基础，这个比之前两个更容易，没有重复元素，且不能重复用
 * Easiest
 * ***/

public class Leetcode_216_CombinationSumIII {
    private List<List<Integer>> res;
    private List<Integer> tempOne;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new LinkedList<>();
        tempOne = new LinkedList<>();
        bt(n, 1, k);
        return res;
    }
    private void bt(int rest, int start, int k) {
        if (rest == 0 && tempOne.size() == k) {
            res.add(new ArrayList<>(tempOne));
            return;
        } else if (tempOne.size() > k || rest < 0) {
            return;
        } else {
            for (int i = start; i <= 9; i++) {
                tempOne.add(i);
                bt( rest - i, i + 1, k);
                tempOne.remove(tempOne.size() - 1);
            }
        }
    }
}
