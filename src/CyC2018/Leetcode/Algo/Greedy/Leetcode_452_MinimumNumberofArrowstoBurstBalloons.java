package CyC2018.Leetcode.Algo.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode_452_MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        int length = points.length;
        if (length <= 1) return length;
        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));
        int result = 1;
        int low = points[0][1];
        for (int i = 1; i < length; i++) {
            if (points[i][0] <= low) continue;
            result++;
            low = points[i][1];
        }
        return result;
    }
}
