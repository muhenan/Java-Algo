package CyC2018.Leetcode.DataStructure.String;

public class Leetcode_696_0011 {
    public int countBinarySubstrings(String s) {
        int length = s.length();
        if (length <= 1) return 0;
        int preLen = 0, curLen = 1, count = 0;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) curLen++;
            else {
                preLen = curLen;
                curLen = 1;
            }

            if (preLen >= curLen) count++;
        }
        return count;
    }
}
