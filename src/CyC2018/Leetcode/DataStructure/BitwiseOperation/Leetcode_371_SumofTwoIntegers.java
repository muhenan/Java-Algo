package CyC2018.Leetcode.DataStructure.BitwiseOperation;

public class Leetcode_371_SumofTwoIntegers {
    /**
     * 亦或可以用于无进位加法
     * 这题的方法就是把无进位加法和纯进位加法分开算了
     * */
    public int getSum(int a, int b) {
        if (b == 0) return a;
        int noCarry = a ^ b; // 无进位得到的结果
        int carry = (a & b) << 1; // 所有的进位，进位一直往前进，终有一个时候没有进位了
        return getSum(noCarry, carry);
    }
}
