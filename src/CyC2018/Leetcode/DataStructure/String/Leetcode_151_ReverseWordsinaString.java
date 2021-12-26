package CyC2018.Leetcode.DataStructure.String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode_151_ReverseWordsinaString {

    // 最早想出的 自解方法 都是 O(n)
        // 用了很多 String 的初始化啊，加法之类的，运行起来并不快
    public String reverseWords(String s) {
        String res = new String();
        String word = new String();
        int count = s.length();
        boolean inAWord = false;
        for (int i = 0; i < count; i++) {
            if (s.charAt(i) == ' ') {
                if (!inAWord) continue;
                else {
                    res = word + ' ' + res;
                    word = new String("");
                    inAWord = !inAWord;
                }
            } else {
                word += s.charAt(i);
                if (!inAWord) inAWord = !inAWord;
            }
        }
        if (!word.isEmpty()) {
            res = word + ' ' + res;
        }
        return res.substring(0, res.length() - 1);
    }

    // 也是传统逻辑，但是是用的 char[] 的数据结构，字符串的操作用了 StringBuilder
    // 时间性能大幅度提升
    public String reverseWords3(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        StringBuilder sb = new StringBuilder();
        while (charArray[left] == ' ') left++;
        while (charArray[right] == ' ') right--;
        while (left <= right) {
            int startOfWord = right;
            while (startOfWord >= left && charArray[startOfWord] != ' ') startOfWord--;
            for (int i = startOfWord + 1; i <= right; i++) sb.append(charArray[i]);
            if (startOfWord > left) sb.append(' ');
            while (startOfWord >= left && charArray[startOfWord] == ' ') startOfWord--;
            right = startOfWord;
        }
        return sb.toString();
    }

    // 翻转再翻转
        // 说实话，其实如果非要用这种方法的话，Java 就不太好了，用 C++ 是最好
    public String reverseWords2(String s) {
        return null;
    }
        // 我把 C++ 的方法写在下面吧
    /*
一下是 leetcode 大神的原地做法
其中一些细节非常值得好好体会
思路是先一个整体的翻转，再逐个翻转单词
操作细节：
    整体翻转
    通过左右两个指针除去左右的空格
    单词逐个翻转，两个指针，找到单词，然后 reverse 函数
    一个精髓之处在于处理中间冗余空格：
        完全原地操作，覆盖冗余空格，tail i 两个指针，妙至毫巅 （上提，向前覆盖）
        覆盖的整个过程不会影响后面，但是前面得到了正确结果
字符串还是需要一些操作的
*/
//    string reverseWords(string s) {
//        reverse(s.begin(), s.end());                        //整体反转
//        int start = 0, end = s.size() - 1;
//        while (start < s.size() && s[start] == ' ') start++;//首空格
//        while (end >= 0 && s[end] == ' ') end--;            //尾空格
//        if (start > end) return "";                         //特殊情况
//
//        for (int r = start; r <= end;) {                    //逐单词反转
//            while (s[r] == ' '&& r <= end) r++;
//            int l = r;
//            while (s[l] != ' '&&l <= end) l++;
//            reverse(s.begin() + r, s.begin() + l);
//            r = l;
//        }
//
//        int tail = start;                                   //处理中间冗余空格
//        for (int i = start; i <= end; i++) {
//            if (s[i] == ' '&&s[i - 1] == ' ') continue;
//            s[tail++] = s[i];
//        }
//        return s.substr(start, tail - start);
//    }

    public String reverseWords4(String s) {
        s = s.trim();
        List<String> words = Arrays.asList(s.split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        System.out.println("Mu \n");
        System.out.println("Mu \\n");
        System.out.println("Mu \\\\\\n");
    }

}
