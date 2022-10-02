package Problems;

public class Leetcode_6195 {
    int length;
    int[] my_dp_arr; // dp 数组
    public int deleteString(String s) {
        length = s.length();

        // For the situation, all the characters are same
        if (length == 1) return 1;
        boolean my_flag = true;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                my_flag = false;
                break;
            }
        }
        if (my_flag) return length;


        my_dp_arr = new int[length];
        return dp(s, 0);
    }
    private int dp (String s, int index) {
        if (index == length) return 0;
        if (my_dp_arr[index] != 0) return my_dp_arr[index];
        int currentLength = length - index;
        int temp = 0;
        for (int i = 1; i <= currentLength / 2; i++) {
            boolean flag = true;
            for (int iterator = 0; iterator < i; iterator++) {
                if (s.charAt(index + iterator) == s.charAt(index + i + iterator)) flag = true;
                else {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                temp = Math.max(temp, dp(s, index + i));
            }
        }
        my_dp_arr[index] = temp + 1;
        return my_dp_arr[index];
    }
}