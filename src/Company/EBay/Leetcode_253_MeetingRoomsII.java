package Company.EBay;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * 首先是一个二维数组的排序
 *
 * 然后是优先队列，小跟堆的使用
 *
 * 时间复杂度，排序就 nlogn 了，后面往优先队列里放元素又 nlogn
 * */
public class Leetcode_253_MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int length = intervals.length;
        pq.offer(intervals[0][1]);
        for (int i = 1; i < length; i++) {
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }


    /**
     * 网友的方法，其实时间复杂度没有提高，还是 nlogn
     * 全转成了一维数据，可能会好一些
     * 哦，最后的是对的，因为给 end 也排序了，按最小 end 来的
     * 挺可以的，最后的优化成 O(N) 了
     * */
    /**
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }**/
}
