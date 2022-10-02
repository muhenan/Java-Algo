package CyC2018.Leetcode.DataStructure.BitwiseOperation;

public class Leetcode_461_HammingDistance {

    /**
     * 用亦或，把不同的数都找出来，然后统计有多少个 1
     * */

    /**
     * 统计 1
     * 用了 & 1 然后右移的方法
     * */
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0) {
            if ((z & 1) == 1) count++;
            z = z >> 1;
        }
        return count;
    }

    /**
     * 使用 z&(z-1) 去除 z 位级表示最低的那一位
     * */
    public int hammingDistance2(int x, int y) {
        int z = x ^ y;
        int cnt = 0;
        while (z != 0) {
            z &= (z - 1);
            cnt++;
        }
        return cnt;
    }

    /**
     * 直接使用 Integer.bitcount() 来统计 1 个的个数。
     * */
    public int hammingDistance3(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
