package Company.TT;

import java.math.BigInteger;
import java.util.Scanner;

public class pathsOnAGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int my_m = sc.nextInt();
        int my_n = sc.nextInt();
        sc.close();
        BigInteger[][] dp = new BigInteger[my_m + 1][my_n + 1];
        for (int i = 0; i <= my_n; i++) dp[0][i] = new BigInteger("1");
        for (int i = 0; i <= my_m; i++) dp[i][0] = new BigInteger("1");
        for (int r = 1; r <= my_m; r++)
            for (int c = 1; c <= my_n; c++) {
                dp[r][c] = dp[r - 1][c].add(dp[r][c - 1]);
            }
        System.out.println(dp[my_m][my_n]);
    }
}
