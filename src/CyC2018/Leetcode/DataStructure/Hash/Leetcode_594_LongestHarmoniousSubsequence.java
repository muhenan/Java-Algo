package CyC2018.Leetcode.DataStructure.Hash;

import java.util.HashMap;

public class Leetcode_594_LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num, countForNum.getOrDefault(num, 0) + 1);
        }
        int longest = 0;
        for (int num : countForNum.keySet()) {
            //System.out.println(num);
            if (countForNum.containsKey(num + 1)) {
                longest = Math.max(longest, countForNum.get(num + 1) + countForNum.get(num));
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Leetcode_594_LongestHarmoniousSubsequence solu = new Leetcode_594_LongestHarmoniousSubsequence();
        int[] testArray = new int[]{2, 3, 1, 2, 7, 1};
        int res = solu.findLHS(testArray);
    }
}
