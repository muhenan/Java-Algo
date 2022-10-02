package CyC2018.Leetcode.DataStructure.BitwiseOperation;

public class Leetcode_476_NumberComplement {
    /**
     * 问题的关键是，这里和去反不同，取反是把全部的位取反
     * 这里的取反是不算前导 0 的
     * */
//    public int findComplement(int num) {
//        return ~num;
//        //return 0;
//    }

    /**
     * 对于 00000101，找到一个掩码 00000111 与其亦或即可得到答案
     *
     *
     * 可以各种字符串操作，但是好像又太耗时
     * */
    public int findComplement(int num) {
        /**
         * 这个 mask 把一个 1 放在最左边
         * 这里最左边指的是左边第二位，因为如果左边第一位是 1 ，就说明这个是负数了，右移的时候左边会补 1
         * 然后就是一直和这个数 & ，右移，直到找到 num 的最左边一位
         * 找到后把 mask 左移一位再减一，搞出全是 1，这就是我们最后要找的 mask
         * */
        int mask = 1 << 30;
        while ((mask & num) == 0) mask >>= 1;
        mask <<= 1;
        mask -= 1;
        return num ^ mask;
    }

    /**
     * 可以利用 Java 的 Integer.highestOneBit() 方法来获得含有首 1 的数。
     * */
    public int findComplement2(int num) {
        int mask = Integer.highestOneBit(num);
        mask = (mask << 1) - 1;
        return num ^ mask;
    }

    /**
     *
     * 对于 10000000 这样的数要扩展成 11111111，可以利用以下方法：
     *
     * mask |= mask >> 1    11000000
     * mask |= mask >> 2    11110000
     * mask |= mask >> 4    11111111
     *
     *
     * */
    /**
     * num 是个正数，所以一定要 1 <= num < 2^31
     * 也就是左边边一位肯定不能是 1
     * 所以这个掩码最多就是 31 位 1 即可，因为第一位肯定是 0
     * */
    public int findComplement3(int num) {
        int mask = num;
        mask |= mask >> 1;
        mask |= mask >> 2;
        mask |= mask >> 4;
        mask |= mask >> 8;
        mask |= mask >> 16; // 所以这里完全可以写右移 15 ，当然 16 也没关系
        return (mask ^ num);
    }

    public static void main(String[] args) {
        Leetcode_476_NumberComplement solu = new Leetcode_476_NumberComplement();
        System.out.println(Integer.toBinaryString(solu.findComplement(5)));
    }
}
