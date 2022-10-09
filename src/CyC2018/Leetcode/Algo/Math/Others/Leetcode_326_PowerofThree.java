package CyC2018.Leetcode.Algo.Math.Others;

public class Leetcode_326_PowerofThree {
    /**
     * 1. 最简单的一个一个试的方法不写了
     *
     * 2. 除三，每次都看能不能整除
     * */
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 3 != 0) return false;
            n /= 3;
        }
        return true;
    }

    /**
     * 用了一个 int 中最大的 3 的幂，用这个去模 n
     * */
    public boolean isPowerOfThree2(int n) {
        return n > 0 && (1162261467 % n == 0);
    }
}
