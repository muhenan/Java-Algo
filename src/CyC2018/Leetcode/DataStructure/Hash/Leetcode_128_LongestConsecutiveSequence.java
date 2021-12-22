package CyC2018.Leetcode.DataStructure.Hash;

import java.util.HashMap;

public class Leetcode_128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> my_map = new HashMap<>();
        for (int num: nums) {
            my_map.put(num, null);
        }
        int longest = 0;
        for (int num: nums) {
            if(!my_map.containsKey(num - 1)) {
                int current = num;
                int current_longest = 1;
                while (my_map.containsKey(current + 1)) {
                    current ++;
                    current_longest ++;
                }
                longest = Math.max(current_longest, longest);
            }
        }
        return longest;
    }
}
