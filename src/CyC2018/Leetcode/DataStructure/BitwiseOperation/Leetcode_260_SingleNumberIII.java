package CyC2018.Leetcode.DataStructure.BitwiseOperation;

public class Leetcode_260_SingleNumberIII {
    /**
     * 用到的性质：
     * n&(-n) 得到 n 的位级表示中最低的那一位 1。
     * -n 得到 n 的反码加 1，也就是 -n=~n+1。
     * 例如对于二进制表示 10110100，-n 得到 01001100，
     * 相与得到 00000100。
     * */

    /**
     * 先全部亦或一遍，最后得到的答案是 n = a ^ b
     * 通过 n&(-n) 得到 n 的位级表示中最低的那一位 1，也就 a 和 b 从右数第一个不同的位
     * 通过找到的这个最右不同位，再结合 nums 数组，把 a b 区分出来
     * */
    public int[] singleNumber(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n ^= num;
        }
        int bit = n & (-n);
        int x = 0, y = 0; // 假设 x 是有 bit 那位，y 是没有的
        for (int num : nums) {
            if ((num & bit) == 0) {
                /**
                 * 如果这里 & 是 0，那么这个数肯定不是 x，可能 y，也可能是没用的数
                 * 全部 ^ 即可，没用的数肯定是两个，所以会自己消掉，最后剩下的就是 y
                 * */
                y ^= num;
            } else x ^= num; // 反之亦然，得到 x
        }
        return new int[]{x, y};
    }
}
