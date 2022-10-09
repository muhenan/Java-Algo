package CyC2018.Leetcode;

import java.util.*;

public class JavaDSandF {



    public static void main(String[] args) {
        int[][] intervals;
        int[] arr = new int[]{2,1,3};
        intervals = new int[][]{{1,2}, {2,1}, {0,3}};
        /**
         * Arrays 的 sort 默认就是从小到大
         * */
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                /** 正常左减右就是从小到大 */
//                return o1[1] - o2[1];
                return o2[1] - o1[1];
            }
        });
        System.out.println();


        //Arrays.sort(arr);

        List my_list = new ArrayList<>();
        for (int ele:arr) my_list.add(ele); // 先 int[] to List 然后再各种操作

        System.out.println();

        Collections.sort(my_list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        System.out.println();

        Collections.reverse(my_list);

        System.out.println();


//        PriorityQueue<Integer> pq = new PriorityQueue<>(2, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        pq.offer(4);
//        pq.offer(1);
//        pq.offer(2);
//        pq.offer(0);
//        System.out.println();

//        pq.remove(2);
//        pq.offer(3);

//        que.add(d);
//        if (que.size() > YOUR_LIMIT)
//            que.poll();
        System.out.println();
    }
}
