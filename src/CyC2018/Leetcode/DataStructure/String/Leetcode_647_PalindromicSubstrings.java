package CyC2018.Leetcode.DataStructure.String;

public class Leetcode_647_PalindromicSubstrings {

    // 判断一个字符串是否回文
    private boolean isPalindrome(String s, int start, int end) {
        int left = start;
        int right = end;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // 时间复杂度达到了恐怖的 n3 ，完全不可取！！不可理喻！
    public int countSubstrings(String s) {
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (isPalindrome(s, i, j)) count++;
            }
        }
        return count;
    }

}
