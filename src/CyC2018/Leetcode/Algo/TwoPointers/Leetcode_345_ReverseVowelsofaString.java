package CyC2018.Leetcode.Algo.TwoPointers;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 题目不难，双指针从两头向中间夹逼
 * 这里解说一下代码的书写
 *      是不是元音这里用了一个 HashSet，查找的时间复杂度是常数，仔细看看这个 HashSet 的初始化
 *
 * **/

public class Leetcode_345_ReverseVowelsofaString {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        if (s == null) return null;
        int left = 0, right = s.length() - 1;
        char[] result = new char[s.length()];
        while (left <= right) {
            char charLeft = s.charAt(left);
            char charRight = s.charAt(right);
            if (!vowels.contains(charLeft)) { // 如果不是元音，就向右走；如果是就停下
                result[left++] = charLeft;
            } else if (!vowels.contains(charRight)) { // 如果不是元音，就向左走；如果是就停下
                result[right--] = charRight;
            } else { // 两个都是元音，就交换，并且都往中间走
                result[left++] = charRight;
                result[right--] = charLeft;
            }
        }
        return new String(result); // 用 char 数组初始化 string
    }
}
