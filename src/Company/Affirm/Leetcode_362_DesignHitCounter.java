package Company.Affirm;

import java.util.ArrayList;
import java.util.List;


/**
 * 数组
 * 双端队列
 * 二分查找
 * */

public class Leetcode_362_DesignHitCounter {
}

class HitCounter {

    List<Integer> my_list = new ArrayList<>();
    public HitCounter() {
        my_list = new ArrayList<>();
    }

    public void hit(int timestamp) {
        my_list.add(timestamp);
    }

    public int getHits(int timestamp) {
        int length = my_list.size();
        if (timestamp <= 300) return length;

        /** Binary Search */
        int left = 0;
        int right = length - 1;
        int target = timestamp - 300;
        while (left <= right) { // 这里找的是大于 target 的第一个数，即 [2,301] 找的是 2
            int mid = (right - left) / 2 + left;
            if (my_list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid - 1; // 左边这个必须往前走，因为 int 的除法问题，如果这里没有 + 1 的话，可能会造成无限循环
            }
        }

        return length - left;
    }

}