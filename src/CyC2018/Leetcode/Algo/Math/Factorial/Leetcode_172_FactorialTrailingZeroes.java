package CyC2018.Leetcode.Algo.Math.Factorial;

public class Leetcode_172_FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        /**
         * 只要是不断乘 5 乘上去的，一定都能多出一个零
         * */
        int k = 5;
        int result = 0;
        while (k <= n) {
            result += n / k; // 统计一共贡献了多少个 5
            k *= 5;
        }
        return result;
    }


    /**
     * 尾部的 0 由 2 * 5 得来，2 的数量明显多于 5 的数量，因此只要统计有多少个 5 即可。
     *
     * 对于一个数 N，它所包含 5 的个数为：N/5 + N/52 + N/53 + ...，其中 N/5 表示不大于 N 的数中 5 的倍数贡献一个 5，
     * N/52 表示不大于 N 的数中 52 的倍数再贡献一个 5 ...。
     * */
    public int trailingZeroes2(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes2(n / 5);
    }
    /**
     * 如果统计的是 N! 的二进制表示中最低位 1 的位置，只要统计有多少个 2 即可，该题目出自 编程之美：2.2 。
     * 和求解有多少个 5 一样，2 的个数为 N/2 + N/22 + N/23 + ...
     *
     * 因为奇数和奇数相乘，永远都是奇数，最后一位肯定是 1
     * 只有 2 推着这些数往左移
     * */
}
