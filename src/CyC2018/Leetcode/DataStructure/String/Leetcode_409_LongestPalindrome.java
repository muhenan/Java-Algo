package CyC2018.Leetcode.DataStructure.String;

import java.util.HashMap;

public class Leetcode_409_LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> my_map = new HashMap<>();
        for (char c: s.toCharArray()) {
            my_map.put(c, my_map.getOrDefault(c, 0) + 1);
        }
        int countOfOdd = 0;
        int result = 0;
        for (int i: my_map.values()) {
            result += i;
            if (i % 2 == 1) countOfOdd++;
        }
        if (countOfOdd > 1) result -= (countOfOdd - 1);
        return result;
    }
}
