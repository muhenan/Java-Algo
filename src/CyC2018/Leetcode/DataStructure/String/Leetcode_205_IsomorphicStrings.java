package CyC2018.Leetcode.DataStructure.String;

import java.util.HashMap;

public class Leetcode_205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map1.get(s1[i]) != null) {
                if (map1.get(s1[i]) != s2[i]) return false;
            } else {
                map1.put(s1[i], s2[i]);
            }
            if (map2.get(s2[i]) != null) {
                if (map2.get(s2[i]) != s1[i]) return false;
            } else {
                map2.put(s2[i], s1[i]);
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (preIndexOfS[sc] != preIndexOfT[tc]) return false;
            preIndexOfS[sc] = i + 1;
            preIndexOfT[tc] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode_205_IsomorphicStrings solu = new Leetcode_205_IsomorphicStrings();
        String s = new String("foo");
        String t = new String("bar");
        System.out.println(solu.isIsomorphic(s, t));
        int[] preIndexOfS = new int[5];
        for (int i: preIndexOfS) System.out.println(i);
    }
}
