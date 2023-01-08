package Problems;

import java.util.*;

/**
 * hard
 *
 * */

/**
 * 前缀和 简化计算
 *
 * 排序了
 * */
public class Leetcode_2448_MinimumCosttoMakeArrayEqual {

    public long minCost(int[] nums, int[] cost) {
        int N = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        // 去重，相同的数字可以合并cost
        for (int i = 0; i < N; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + cost[i]);
        }
        if (map.size() == 1) return 0;
        long ans = Long.MAX_VALUE;
        /**
         * 这里 List 里装的是 Map.Entry
         * */
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.size());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry);
        }
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return Integer.compare(o1.getKey(), o2.getKey()); // 其实就相当于 o1 - o2
            }
        });
        long tmp = 0;
        // 计算前缀和
        long[] costSums = new long[list.size() + 1];
        for (int j = 1; j <= list.size(); j++) {
            costSums[j] = costSums[j - 1] + list.get(j - 1).getValue();
        }
        // 计算都等于最后那个数的 cost
        for (int i = 0; i < list.size(); i++) {
            tmp += (long) (list.get(list.size() - 1).getKey() - list.get(i).getKey()) * list.get(i).getValue();
        }
        ans = Math.min(ans, tmp);

        // 计算等于各个数的情况，用前缀和
        for (int i = list.size() - 2; i >= 0; i--) {
            long right = (list.get(i + 1).getKey() - list.get(i).getKey()) * (costSums[list.size()] - costSums[i + 1]);
            long left = (list.get(i + 1).getKey() - list.get(i).getKey()) * costSums[i + 1];
            tmp = tmp - left + right;
            if (ans > tmp) {
                ans = tmp;
            }
        }
        return ans;
    }
}
