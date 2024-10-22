package Problems;

public class SnowflakeOA {
    public static void main(String[] args) {
        int[][] dp = new int[5][5];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.println(dp[i][j]);
            }
        }
    }
}
