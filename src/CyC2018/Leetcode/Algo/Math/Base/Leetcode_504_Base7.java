package CyC2018.Leetcode.Algo.Math.Base;

public class Leetcode_504_Base7 {
    public String convertToBase7(int num) {
        if (num == 0) return new String("0");
        int old_num = num;
        if (num < 0) num = -num;
        StringBuffer result = new StringBuffer();
        while (num != 0) {
            int reminder = num % 7;
            result.append(reminder);
            num /= 7;
        }
        if (old_num < 0) result.append('-');
        return result.reverse().toString();
    }

    /**
     * 直接 Java 的进制转换函数
     * */
//    public String convertToBase7(int num) {
//        return Integer.toString(num, 7);
//    }
}
