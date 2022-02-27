package CyC2018.Leetcode.Algo.TwoPointers;

import java.util.List;

/**
 * 思路其实非常简单，就是每个 word 都是和 s 匹配，然后匹配的时候是用到了双指针
 * 选匹配情况最好的一个
 * 所以最后时间复杂度是平方的
 * **/

/**
 * 写法的话，我这个是写一起了，也可以写个专门测是不是子序列的小函数，也就是分开两个函数
 * （也就是以前我们经常讲的，面对一个复杂问题时，首先的想法是把问题分解成小的问题）
 * **/
public class Leetcode_524_LongestWordinDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> dictionary) {
        int length = s.length();
        String res = new String("");
        for (String word : dictionary) {
            int lengthOfWord = word.length();
            if (lengthOfWord > res.length() || (lengthOfWord == res.length() && res.compareTo(word) > 0)) {
                int indexOfS = 0;
                int indexOfWord = 0;
                while (indexOfS < length && indexOfWord < lengthOfWord) {
                    if (s.charAt(indexOfS++) == word.charAt(indexOfWord)) {
                        indexOfWord++;
                    }
                }
                if (indexOfWord == lengthOfWord) res = word;
            }
        }
        return res;
    }

    // 分开两个函数的写法
    public String findLongestWord2(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubstr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    // 专门测是不是子序列的小函数
    private boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}
