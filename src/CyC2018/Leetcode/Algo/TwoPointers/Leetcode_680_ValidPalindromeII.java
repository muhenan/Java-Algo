package CyC2018.Leetcode.Algo.TwoPointers;

public class Leetcode_680_ValidPalindromeII {
    /**
     * 遇到错误的地方时
     *      就测删掉左边的一个或者删掉右边的一个，剩的是不是回文
     * **/
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    /**
     * 单纯测一个字符串是不是回文，left 和 right 是我们自己带进去的
     * **/
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
