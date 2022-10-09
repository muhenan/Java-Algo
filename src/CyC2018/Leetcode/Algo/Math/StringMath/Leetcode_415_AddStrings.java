package CyC2018.Leetcode.Algo.Math.StringMath;

public class Leetcode_415_AddStrings {
    public String addStrings(String num1, String num2) {
        int indexFirst = num1.length() - 1;
        int indexSecond = num2.length() - 1;
        char[] firstArr = num1.toCharArray();
        char[] secondArr = num2.toCharArray();
        int carry = 0;
        StringBuffer str = new StringBuffer();
        while (carry != 0 || indexFirst >= 0 || indexSecond >= 0) {
            if (indexFirst >= 0) carry += firstArr[indexFirst--] - '0';
            if (indexSecond >= 0) carry += secondArr[indexSecond--] - '0';
            str.append((char)((carry % 10) + '0')); // Java 这里 int 和 char 的转换比较奇怪，要把 int 变成 char，要自己加 (char) 强转
            carry = carry / 10;
        }
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        Leetcode_415_AddStrings solu = new Leetcode_415_AddStrings();
        solu.addStrings("11", "123");
    }
}
