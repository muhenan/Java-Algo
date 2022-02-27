package CyC2018.Leetcode.Algo.TwoPointers;

/**
 *
 * 一般返回两个数的时候，有时候可以想双指针
 *
 * 非常简单的题目，两个指针从两头往中间夹逼
 *
 * ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
 *
 * 安全起见！这种涉及乘除的，以后为了防止溢出，都用 long 来声明变量！！！（debug了半天最后发现是溢出了。。。）
 *
 * **/

public class Leetcode_633_SumofSquareNumbers {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (int) Math.sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) return true;
            else if (sum > c) right--;
            else left++;
        }
        return false;
    }
}
