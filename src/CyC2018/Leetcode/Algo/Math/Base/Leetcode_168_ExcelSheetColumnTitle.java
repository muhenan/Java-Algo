package CyC2018.Leetcode.Algo.Math.Base;

public class Leetcode_168_ExcelSheetColumnTitle {
    /**
     * 这个有一点点 tricky
     *
     * 并不是超级超级简单，这个涉及到一个 0 的问题
     * 转换一下思路，把所有的数值都减一之后再算，把 A 看成 0，这就讲得通了
     * */
    public String convertToTitle(int columnNumber) {
        StringBuffer result = new StringBuffer();
        while (columnNumber != 0) {
            result.append((char)((columnNumber - 1) % 26 + 'A'));
            columnNumber = (columnNumber - 1) / 26;
        }
        return result.reverse().toString();
    }


    /**
     * Cyc 方法
     *
     * 因为是从 1 开始计算的，而不是从 0 开始，因此需要对 n 执行 -1 操作。
     *
     * 直接用的 String，而且还用了加号，没有我们酷
     *
     * 时间效率爆炸，String 带 加号这种方法万万不可取！！！太慢了！！
     * */
    public String convertToTitle2(int n) {
        if (n == 0) {
            return "";
        }
        n--;
        return convertToTitle(n / 26) + (char) (n % 26 + 'A');
    }
}
