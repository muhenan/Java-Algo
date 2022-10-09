package CyC2018.Leetcode.Algo.Math.Others;

public class Leetcode_367_ValidPerfectSquare {
    /** 超时 */
    public boolean isPerfectSquare(int num) {
        for (int i = 1; i <= num; i++) {
            int value = i * i;
            if (value == num) return true;
            if (value > num) return false;
        }
        return false;
    }

    /**
     * 平方序列：1,4,9,16,..
     *
     * 间隔：3,5,7,...
     *
     * 间隔为等差数列，使用这个特性可以得到从 1 开始的平方序列。
     * */
    /** 生成平方数，不用乘的方式了，用加的方式生成平方数 */
    public boolean isPerfectSquare2(int num) {
        int subNum = 1;
        while (num > 0) {
            num -= subNum;
            subNum += 2;
        }
        return num == 0; // 如果刚好减到 0，就是完全平方数
    }



    /** 二分查找 看中间这个数是不是 */
    public boolean isPerfectSquare3(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
