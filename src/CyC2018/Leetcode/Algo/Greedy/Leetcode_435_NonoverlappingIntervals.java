package CyC2018.Leetcode.Algo.Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
 *
 * 按区间的结尾进行排序
 *
 * (这样我们就能明确如何找局部最优了，按结尾排序后，两个相邻的重叠时，优先删右边的，即结尾大的)
 *
 * **/

public class Leetcode_435_NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        int length = intervals.length;
        if (length <= 1) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        int rightest = intervals[0][1];
        for (int i = 1; i < length; i++) {
            if (intervals[i][0] >= rightest) rightest = intervals[i][1];
            else result++;
        }
        return result;
    }

    /**
     * 使用 lambda 表示式创建 Comparator 会导致算法运行时间过长，如果注重运行时间，可以修改为普通创建 Comparator 语句
     * 试试证明用时只减了一点点，也没减到哪去
     * **/
    public int eraseOverlapIntervals2(int[][] intervals) {
        int result = 0;
        int length = intervals.length;
        if (length <= 1) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 实现 compare() 函数时避免使用 return o1[1] - o2[1]; 这种减法操作，防止溢出。
                // return o1[1] - o2[1];
                return (o1[1] < o2[1]) ? -1 : ((o1[1] == o2[1]) ? 0 : 1);
            }
        });
        int rightest = intervals[0][1];
        for (int i = 1; i < length; i++) {
            if (intervals[i][0] >= rightest) rightest = intervals[i][1];
            else result++;
        }
        return result;
    }
}
