package Sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class findKthLargest {

    //215. 数组中的第K个最大元素
//    输入: [3,2,1,5,6,4] 和 k = 2
//    输出: 5



    //排序 ：时间复杂度 O(NlogN)，空间复杂度 O(1)

    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }



    //堆 ：时间复杂度 O(NlogK)，空间复杂度 O(K)。

    // 普通的优先队列是把最小的放在上面
    // 遍历数组所以有 O(N) ，但是进入堆的时候，每次查找的复杂度是 O(logk)
    // 所以最后时间复杂度 O(NlogK)，空间复杂度 O(K)
    public int findKthLargest2(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int val:nums){
            pq.add(val);
            if(pq.size() > k) pq.poll();
        }
        return pq.peek();
    }



    //快速选择 ：时间复杂度 O(N)，空间复杂度 O(1)

    //使用的外部空间是常数的
    //快速选择的时间复杂度是 O(N)

    public int findKthLargest3(int[] nums, int k){
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }


    private int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) ; // 先加，先往前走，再用
            while (a[--j] > a[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j); //因为 j 最后指的肯定是小于 l 的，所以最后是 j 和 l 换
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
