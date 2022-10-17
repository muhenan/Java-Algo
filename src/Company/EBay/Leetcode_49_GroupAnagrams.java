package Company.EBay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode_49_GroupAnagrams {
    /**
     * 题目要求
     * 单词中，字母组合数量一样的，放在一起
     * */
    // By sorted string
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        HashMap<String, List> ans = new HashMap<>();
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = String.valueOf(charArr);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(str);
        }
        return new ArrayList(ans.values());
    }
    /** 学学里面这些数据结构的使用 */



    /**
     * 理论上下面这种的时间复杂度 是 NK，上面的是 NlogK
     * 但是上面的却快很多
     * 只能说 Arrays.sort 还是太强大
     * */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        HashMap<String, List> ans = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);
            char[] charArr = str.toCharArray();
            for (char c : charArr) count[c - 'a']++;

            StringBuffer sb = new StringBuffer("");
            for (int c : count) {
                sb.append('#');
                sb.append(c); // 这里直接加数字就变成字符 这里是 java 和 c++ 的不同
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(str);
        }
        return new ArrayList(ans.values());
    }


    public static void main(String[] args) {
        Leetcode_49_GroupAnagrams solu = new Leetcode_49_GroupAnagrams();
        solu.groupAnagrams2(new String[]{"bdddddddddd","bbbbbbbbbbc"});
    }
}
