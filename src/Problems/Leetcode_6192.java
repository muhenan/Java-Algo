package Problems;

public class Leetcode_6192 {
    public int commonFactors(int a, int b) {
        int result = 0;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) result++;
        }
        return result;
    }
}
