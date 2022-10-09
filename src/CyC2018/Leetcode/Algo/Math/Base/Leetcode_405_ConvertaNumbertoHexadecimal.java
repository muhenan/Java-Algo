package CyC2018.Leetcode.Algo.Math.Base;

import java.util.Dictionary;
import java.util.HashMap;

public class Leetcode_405_ConvertaNumbertoHexadecimal {


    /**
     * 16 进制这种其实是最简单的，因为 int 本来就是 2 进制的
     * 这道题就相当于让你把二进制的变成 16 进制的形式
     * */
    public String toHex(int num) {
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 0b1111]); // 这里这个 & 就是保留最后4位，其实就相当于 % 16
            num >>>= 4; // 因为考虑的是补码形式，因此符号位就不能有特殊的意义，需要使用无符号右移，左边填 0
        }
        return sb.reverse().toString();
    }


    /**
     * 官方方法
     * 循环八次
     * 找最高位
     * 不用 reverse 了
     * */
    public String toHex2(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 7; i >= 0; i --) {
            int val = (num >> (4 * i)) & 0xf;
            if (sb.length() > 0 || val > 0) {
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                sb.append(digit);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode_405_ConvertaNumbertoHexadecimal solu = new Leetcode_405_ConvertaNumbertoHexadecimal();
        solu.toHex(-1);
    }

//
//    public String toHex(int num) {
//        if (num == 0) return new String("0");
//        char[] dic = new char[16];
//        HashMap<Character, Character> xor = new HashMap<>();
//        xor.put('0', 'f');
//        xor.put('1', 'e');
//        xor.put('2', 'd');
//        xor.put('3', 'c');
//        xor.put('4', 'b');
//        xor.put('5', 'a');
//        xor.put('6', '9');
//        xor.put('7', '8');
//        xor.put('8', '7');
//
//        for (int i = 0; i <= 9; i++) dic[i] = (char)('0' + i);
//        for (int i = 10; i <= 15; i++) dic[i] = (char)(i - 10 + 'a');
//        StringBuffer result = new StringBuffer();
//        int old_num = num;
//        if (num < 0) num = -num;
//        while (num != 0 ) {
//            int reminder = num % 16;
//            result.append(dic[reminder]);
//            num /= 16;
//        }
//        if (old_num > 0) return result.reverse().toString();
//        else {
//            while (result.length() < 8) result.append('0');
//            result = result.reverse();
//            StringBuffer str = new StringBuffer();
//            for (int i = 0; i < 8; i++) {
//
//            }
//            return result.toString();
//        }
//    }
}
