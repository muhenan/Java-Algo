package CyC2018.Leetcode.Algo.DynamicProgramming.Fabonacci;

/**
 * 问题描述： 有 N 个不同信封一一对应  个不同的信件，现将这 N 个信件打乱，随机放入 N 个信封里面
 * 问：任何的信都没被正确装入的可能的情况数
 * */

/**
 * 要得到 dp[i] 时，有两种情况
 * 前面 i - 1 个全部错排了，或者前面 i - 1 个中有一个没错排
 *
 * dp[i] = dp[i - 1] * (i - 1) + dp[i - 2] * (i - 1)
 * */

public class wrong_letters {
    public static void main(String[] args) {
    }
}
