package CyC2018.Leetcode.Algo.Greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 大概的思想是，根据这个字符最后出现的位置 lastIndex，不断向后延展这个 lastIndex
 * 不能向后延展的时候就是找到了一个 partition
 * **/

public class Leetcode_763_PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndexsOfChar = new int[26];
        for (int i = 0; i < s.length(); i++) lastIndexsOfChar[s.charAt(i) - 'a'] = i; // 记录每个字符最后出现的位置
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int lastIndex = lastIndexsOfChar[s.charAt(i) - 'a']; // 当前这个字符的最后出现的位置
            // 从下一个（lastIndex 的范围中）开始找它的最后出现的位置，看是不是大于之前最大的 lastIndex
            for (int j = i + 1; j <= lastIndex; j++) lastIndex = Math.max(lastIndex, lastIndexsOfChar[s.charAt(j) - 'a']);
            result.add(lastIndex - i + 1);
            i = lastIndex + 1; // i 赋值为 lastIndex 的下一个
        }
        return result;
    }
}
