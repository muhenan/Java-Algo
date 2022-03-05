package CyC2018.Leetcode.Algo.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_451_SortCharactersByFrequency {
    /**
     * 方法还是桶排序，和 347 的桶排序一样，时间复杂度 O(n)
     * 这道题的话，学一些字符串的操作：toCharArray StringBuilder append
     * **/
    public String frequencySort(String s) {
        // 计数
        Map<Character, Integer> frequencyForNum = new HashMap<>();
        for (char c : s.toCharArray())
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);

        //  frequency to element
        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];
        for (char c : frequencyForNum.keySet()) {
            int f = frequencyForNum.get(c);
            if (frequencyBucket[f] == null) {
                frequencyBucket[f] = new ArrayList<>();
            }
            frequencyBucket[f].add(c);
        }

        // 组装成结果字符串
        StringBuilder str = new StringBuilder();
        for (int i = frequencyBucket.length - 1; i >= 0; i--) {
            if (frequencyBucket[i] == null) {
                continue;
            }
            for (char c : frequencyBucket[i]) {
                for (int j = 0; j < i; j++) {
                    str.append(c);
                }
            }
        }

        return str.toString();
    }
}
