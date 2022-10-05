package Problems;

import java.util.*;

public class Leetcode_2406 {
    public int minGroups(int[][] intervals) {
        int length = intervals.length;
        if (length == 1) return 1;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        List<int[]> my_list = new ArrayList<>();
        my_list.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < length; i++) {
            int size = my_list.size();
            int index = -1;
            int min_gap = Integer.MAX_VALUE;
            for (int j = 0; j < size; j++) {
                if (intervals[i][0] > my_list.get(j)[1]) {
                    if (intervals[i][0] - my_list.get(j)[1] < min_gap) {
                        min_gap = intervals[i][0] - my_list.get(j)[1];
                        index = j;
                    }
                }
            }
            if (index == -1) {
                my_list.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                my_list.get(index)[0] = Math.min(my_list.get(index)[0], intervals[i][0]);
                my_list.get(index)[1] = intervals[i][1];
            }
        }
        return my_list.size();
    }


    public int minGroups2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int[] p : intervals) {
            if (!pq.isEmpty() && pq.peek() < p[0]) pq.poll();
            pq.offer(p[1]);
        }
        return pq.size();
    }

    int[][] temp = { { 2,9 }, { 5, 7 }};
    public static void main(String[] args) {
        Leetcode_2406 solu = new Leetcode_2406();
        solu.minGroups(solu.temp);
    }
}
