package CyC2018.Leetcode.DataStructure.BitwiseOperation;

public class Leetcode_693_BinaryNumberwithAlternatingBits {
    /**
     * 自解用了个正则表达式的方法，效率极低
     * */
    public boolean hasAlternatingBits(int n) {
        String BStr = Integer.toBinaryString(n);
        return BStr.matches("(10)*1?");
    }

    /** 循环的方式也不写了，那是最简单的方式 */

    /**
     * 用到右移
     * 亦或之后全是 1
     * 加一之后再 & 应该全是 0
     *
     * 时间效率最高！
     * */
    public boolean hasAlternatingBits2(int n) {
        int allOne = n ^ (n >> 1);
        return (allOne & (allOne + 1)) == 0;
    }
}
