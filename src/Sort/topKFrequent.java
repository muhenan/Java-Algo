package Sort;

import java.util.*;

public class topKFrequent {

    // 使用堆（优先队列的方式）
    // 时间复杂度 Nlogk
    public int[] topKFrequent1(int[] nums, int k) {


        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        /*
        * Java HashMap  基本用法
        * containKey
        * put
        * get
        * keySet
        * */
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }


        // 遍历map，用最小堆保存频率最大的k个元素
        /*
        * 使用堆，还是最小堆
        * remove 是取出并且 pop 掉
        *
        * 重载了比较器
        * 当两者要比较时，比较是他们在 map 中 value 即频率
        * 但重载的结果依旧是小堆
        *
        * */
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
                pq.remove();
                pq.add(key);
            }
        }


        // 取出最小堆中的元素
        int result[] = new int[k];
        //List<Integer> res = new ArrayList<>();
        int i = 0;
        while (!pq.isEmpty()) {
            //res.add(pq.remove());
            result[i++] = pq.remove();
        }
        return result;
    }


    // 桶排序
    // 变相的桶排序
    /*
    * 可以认为是用了两次桶排序
    * 第一次是传统的统计了值和出现的次数
    * 第二次是把出现次数一样的数字放到了桶里
    *
    * 最传统的桶排序只是对这个数组按顺序排大小
    * 而这个涉及排序各个数字出现的次数
    * 所以不是传统的桶排序
    *
    * */
    public int[] topKFrequent2(int[] nums, int k) {

        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
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

        List<Integer>[] lists = new List[nums.length+1];
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
        for(int i = lists.length - 1;i >= 0 && sizeOfResult < k;i--){
            if(lists[i] == null) continue;
            for(Integer number : lists[i]){
                result[sizeOfResult++] = number;
            }
        }
        return result;
    }


}
