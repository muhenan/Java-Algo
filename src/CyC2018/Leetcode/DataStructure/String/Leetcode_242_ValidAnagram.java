package CyC2018.Leetcode.DataStructure.String;

import java.util.HashMap;

public class Leetcode_242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> my_map = new HashMap<>();
        for (char c: s.toCharArray()) {
            my_map.put(c, my_map.getOrDefault(c, 0) + 1);
        }
        for (char c: t.toCharArray()) {
            my_map.put(c, my_map.getOrDefault(c, 0) - 1);
        }
        for (int i: my_map.values()) {
            if (i != 0) return false;
        }
        return true;
    }
}
