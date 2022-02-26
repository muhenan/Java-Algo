package CyC2018.Leetcode.DataStructure.ArrayAndMatrix;

import java.util.HashMap;

/**
 * 方法一：看成好多链表环，测哪个环最长，走过的放到哈希表里，存和查都用哈希表
 *
 * 方法二：Cyc 方法，一样的思维，通过把 nums[i] 变成 -1 来标记走过了
 *          数据结构的改变让算法简单了很多，快了很多
 *
 * **/

public class Leetcode_565_ArrayNesting {
    public int arrayNesting(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        if (length <= 1) return length;
        int start = 0;
        int count = 0;
        int current = 0;
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(nums[i])) {
                start = nums[i];
                current = start;
                map.put(current, 0);
                count++;
                while ((current = nums[current]) != start) {
                    map.put(current, 0);
                    count++;
                }
                if (count > result) result = count;
                count = 0;
            }
        }
        return result;
    }

    public int arrayNesting2(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i; nums[j] != -1; ) {
                cnt++;
                int t = nums[j];
                nums[j] = -1; // 标记该位置已经被访问
                j = t;

            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
