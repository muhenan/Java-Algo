package CyC2018.Leetcode.Algo.DynamicProgramming.Subsequence;

import java.util.*;

public class Leetcode_646_MaximumLengthofPairChain {
    /**
     * Solution 1
     * 可以用 LIS 的方法一，DP，时间复杂度平方，这里不写了
     * 思考 nlogn 的方法
     * */
    public int findLongestChain(int[][] pairs) {
        int result = 1;
        int length = pairs.length;
        if (length == 1) return result;

        // 三种写 Comparator 的方法

//        Arrays.sort(pairs, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] arr1, int[] arr2) {
//                return arr1[1] - arr2[1];
//            }
//        });

//        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));

        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));

        int max_right = pairs[0][1];
        for (int i = 1; i < length; i++) {
            if (pairs[i][0] > max_right) {
                max_right = pairs[i][1];
                result++;
            }
        }
        return result;
    }
}
