package CyC2018.Leetcode.DataStructure.BitwiseOperation;

public class Leetcode_342_PowerofFour {
    public boolean isPowerOfFour(int n) {
        // must more than 0
        // 最简单的循环版本
        if (n <= 0) return false;
        if (Integer.bitCount(n) != 1) return false;
        while (n > 0) {
            if (n == 1) return true;
            n >>= 2;
        }
        return false;
    }

    /**
     * 1. 大于 0
     * 2. 只有一个 1
     * 3. 用一个掩码去测，是不是有这样一个 1 （根据题目构建自己的这个掩码）
     *      & 掩码，可以用来测是不是有这样的 1
     * */
    public boolean isPowerOfFour2(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0b01010101010101010101010101010101) != 0;
    }

    /**
     * 也可以使用正则表达式进行匹配。
     *
     * 1. 用到了 Integer.toString 以各种不同的进制形式
     * 2. string.matches 正则表达式匹配 "10*" 1 后面都是 0，或者啥也没有
     * */
    public boolean isPowerOfFour3(int num) {
        return Integer.toString(num, 4).matches("10*");
    }
}
