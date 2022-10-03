package Problems;

public class Leetcode_6194_MinimizeXOR {
    public int minimizeXor(int num1, int num2) {
        int OldNum1 = num1;
        int OneOfNum2 = Integer.bitCount(num2);
        int OneOfNum1 = Integer.bitCount(num1);
        int result = 0;

        /**
         * 把 num1 的尽可能高位的 1 都对上
         * （取最高位这件事这里直接用了 Integer.highestOneBit(num1) 函数）
         * 可以优化一下，找到第一个最高位的 1 之后，就不用每次都使用这个函数了，而是用 temp 右移，这样也不用改 num1 了
         * */
        for (int i = 0; i < OneOfNum2; i++) {
            int temp = Integer.highestOneBit(num1);
            result |= temp;
            num1 ^= temp;
        }

        /**
         * 如果需要补更多的 1
         * 往 num1 的尽可能靠右的 0 上面补
         * */
        if (OneOfNum1 < OneOfNum2) {
            int moreOne = 1;
            for (int i = 0; i < OneOfNum2 - OneOfNum1; i++) {
                while ((moreOne & OldNum1) != 0) moreOne <<= 1;
                result |= moreOne;
                moreOne <<= 1;
            }
        }


        return result;
    }


    /**
     * 大神解法，值得深入学习！
     * 如果 1 的个数相等，直接返回 num1
     * 如果 num2 的 1 少，那么尽量对 num1 的高位的 1，也就是低位的 1 尽量变成 0 （最低的 1 变成 0）
     * 反之，就要尽量让 num1 的低位的 0 变成 1 （最低的 0 变成 1）用先加再或的方法实现这个操作
     * */
    public int minimizeXor2(int num1, int num2) {
        int c1 = Integer.bitCount(num1);
        int c2 = Integer.bitCount(num2);
        for (; c2 < c1; ++c2) num1 &= num1 - 1; // 最低的 1 变成 0
        for (; c2 > c1; --c2) num1 |= num1 + 1; // 最低的 0 变成 1
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(Integer.highestOneBit(5));
    }
}

// 65 64 + 1
// 84 64 + 16 + 4
