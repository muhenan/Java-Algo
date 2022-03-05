package CyC2018.Leetcode.Algo.DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_241_DifferentWaystoAddParentheses {
    /** divide and conquer 分治
     * 分的话，从各个运算符开始分，分成左右两个，然后去递归调用这个函数
     * 关于 string char 的各种操作，还是要好好学习！
     * **/
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ways = new ArrayList<>();
        if (expression.charAt(0) == '-') expression = '0' + expression;
        int length = expression.length();
        for (int i = 0; i < length; i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) ways.add(Integer.valueOf(expression));
        return ways;
    }
}
