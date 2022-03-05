package CyC2018.Leetcode.Algo.Sort;

import java.util.*;

public class Leetcode_347_TopKFrequentElements {
    /**
     * 桶排序
     * 这道题的思维其实不难，就是桶排序，计数就完了
     * 不过用到了很多高级数据结构的复杂操作，这是个困难的点，通过本题，学习 Java 的高级数据结构的操作
     * 方法一：堆排序（控制堆容量）
     * 方法二：桶排序
     * **/

    /**
     * 方法一：堆排序（控制堆容量）
     * 使用堆（优先队列的方式）
     * 时间复杂度 Nlogk，凡是用到堆排序的，时间复杂度就朝着 nlogn去了
     * **/
    public int[] topKFrequent1(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });

        // key都以正确都方式放入堆
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.poll();
                pq.add(key);
            }
        }

        // 取出最小堆中的元素
        int result[] = new int[k];
        int i = 0;
        while (!pq.isEmpty()) result[i++] = pq.poll();
        return result;
    }

    /**
     * 方法二：桶排序（变相的桶排序）
     * 可以认为是用了两次桶排序
     * 第一次是传统的统计了值和出现的次数
     * 第二次是把出现次数一样的数字放到了桶里
     *
     * 最传统的桶排序只是对这个数组按顺序排大小
     * 而这个涉及排序各个数字出现的次数
     * 所以不是传统的桶排序
     *
     * 时间复杂度线性 n！！！！
     *
     * */
    public int[] topKFrequent2(int[] nums, int k) {
        // 计数：使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] lists = new List[nums.length + 1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(lists[i] == null){
                lists[i] = new ArrayList();
            }
            lists[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        int result[] = new int[k];
        int sizeOfResult = 0;
        for(int i = lists.length - 1; i >= 0 && sizeOfResult < k; i--){
            if(lists[i] == null) continue;
            for(Integer number : lists[i]){
                result[sizeOfResult++] = number;
            }
        }
        return result;
    }

}
