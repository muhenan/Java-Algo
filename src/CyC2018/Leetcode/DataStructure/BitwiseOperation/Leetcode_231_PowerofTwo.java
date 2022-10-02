package CyC2018.Leetcode.DataStructure.BitwiseOperation;

public class Leetcode_231_PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (Integer.bitCount(n) == 1) return true;
        return false;
        /**
         * return n > 0 && Integer.bitCount(n) == 1; // 大于 0，并且只有一个 1
         * */
    }

    /**
     * 利用 1000 & 0111 == 0 这种性质，得到以下解法：
     * */
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0; // - 1 可以后面弄出一堆 1 来
    }
}
