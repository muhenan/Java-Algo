package CyC2018.Leetcode.Algo.DynamicProgramming.Bag01;

public class Leetcode_474_OnesandZeroes {

    /**
     * 自解方法，直接通过，已经基本掌握了 01背包DP！
     *
     * 最外层 for 循环只能取一次的材料
     * 内层 for 循环所有的可能的结果，并不断更新结果
     *
     * （答案基本和 Cyc 一样）
     *
     * */
    public int findMaxForm(String[] strs, int m, int n) { // m 0 ; n 1
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int SizeZero = countOfZero(str);
            int SizeOne = countOfOne(str);
            for (int i_zero = m; i_zero >= SizeZero; i_zero--) {
                for (int i_one = n; i_one >= SizeOne; i_one--) {
                    dp[i_zero][i_one] = Math.max(dp[i_zero][i_one], dp[i_zero - SizeZero][i_one - SizeOne] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int countOfOne (String str) {
        int result = 0;
        for (char c : str.toCharArray()) {
            if (c == '1') result++;
        }
        return result;
    }
    private int countOfZero (String str) {
        int result = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode_474_OnesandZeroes solu = new Leetcode_474_OnesandZeroes();
        solu.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
    }
}
