package CyC2018.Leetcode.DataStructure.String;

import java.util.ArrayList;

public class Manacher {
    public String longestPalindrome(String s) {
        int start = 0, end = -1;
        StringBuffer t = new StringBuffer("#");
        for (int i = 0; i < s.length(); ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        t.append('#');
        s = t.toString();

        System.out.println(s);

        ArrayList<Integer> arm_len = new ArrayList<Integer>();
        int right = -1, j = -1;
        for (int i = 0; i < s.length(); ++i) {
            int cur_arm_len;
            if (right >= i) {
                int i_sym = j * 2 - i;
                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
                cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
            } else {
                cur_arm_len = expand(s, i, i);
            }
            arm_len.add(cur_arm_len);
            if (i + cur_arm_len > right) {
                j = i;
                right = i + cur_arm_len;
            }
            if (cur_arm_len * 2 + 1 > end - start) {
                start = i - cur_arm_len;
                end = i + cur_arm_len;
            }
            System.out.println("i is : " + i + " cur_arm_len " + cur_arm_len + " " + start + " " + right + " " + end);
            //System.out.println(i + '=' + cur_arm_len + '=' + start + '=' + right + '=' + end);
//            System.out.println(cur_arm_len);
//            System.out.println(start);
//            System.out.println(right);
//            System.out.println(end);
        }

        StringBuffer ans = new StringBuffer();
        for (int i = start; i <= end; ++i) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }

    public static void main(String[] args) {
        Manacher solu = new Manacher();
        String testStr = new String("axabababec");
        System.out.println(testStr);
        System.out.println(solu.longestPalindrome(testStr));
    }
}
