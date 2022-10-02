package CyC2018.Leetcode.DataStructure.BitwiseOperation;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_190_ReverseBits {
    // you need treat n as an unsigned value
    /**
     * 用到了左移右移的操作
     * 看一个数的最后一位 用 & 1
     * 要保留一个数的最后一位，& 1 之后再用 0 来 ｜
     *
     * 判断最后一位是不是 1 ，不要用什么 % 2 这种处理整数的方法，用纯 BO 的方法
     * */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }
        return result;
    }


    // 更符合我的思路
    public int reverseBits2(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result |= (n & 1);
            if (i != 31) result <<= 1;
            n >>= 1;
        }
        return result;
    }

    /**
     * 如果该函数需要被调用很多次，可以将 int 拆成 4 个 byte，然后缓存 byte 对应的比特位翻转，最后再拼接起来。
     * */
    private static Map<Byte, Integer> cache = new HashMap<>();

    public int reverseBits3(int n) {
        int ret = 0;
        for (int i = 0; i < 4; i++) {
            ret <<= 8;
            ret |= reverseByte((byte) (n & 0b11111111));
            n >>= 8;
        }
        return ret;
    }

    private int reverseByte(byte b) {
        if (cache.containsKey(b)) return cache.get(b);
        int ret = 0;
        byte t = b;
        for (int i = 0; i < 8; i++) {
            ret <<= 1;
            ret |= t & 1;
            t >>= 1;
        }
        cache.put(b, ret);
        return ret;
    }
}
