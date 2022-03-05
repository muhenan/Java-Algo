package CyC2018.Leetcode.Algo.Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 首先意识到这个题的话
 * 乱序的
 * 起码要走一遍才知道
 * 而且要找第几大的话
 * 我们知道时间复杂度最小顶多也就是到 n，也可能到不了，但 nlogn 应该还是简单的
 * **/
public class Leetcode_215_KthLargestElementinanArray {

    /**
     * 方法一：堆排序（Java 优先队列）
     * 时间复杂度 NlogN
     * 可以控制一下堆的容量为k，这样的话，时间复杂度 NlogK
     * **/
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int element: nums) pq.offer(element);
        int count = nums.length - k;
        while (count-- > 0) pq.poll();
        return pq.peek();
    }

    public int findKthLargest11(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k)  // 维护堆的大小为 K
                pq.poll();
        }
        return pq.peek();
    }

    /** 方法二：直接排序 **/
    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 方法三：使用快排的 partition 快速选择
     * 时间复杂度 n ，leetcode 的方法题解中加入 random 说明了为什么时间复杂度是线性
     * 我的方法没有加 random，所以我觉得我的方法还是更像 nlogk
     * **/
    public int findKthLargest3(int[] nums, int k) {
        int length = nums.length;
        k = nums.length - k;
        int low = 0, high = length - 1;
        while (low < high) {
            int indexOfPivot = partition(nums, low, high);
            if (indexOfPivot == k) break;
            else if (indexOfPivot < k) low = indexOfPivot + 1;
            else high = indexOfPivot - 1;
        }
        return nums[k];
    }

    /**
     * 自己的思维简单的方式
     * 注意这里是先走大的一边，如果大于或者等于都走，后走小的那边
     * 所以最后 high 和 low 相等的时候，一定是指着小的一个
     * **/
    public static int partition(int[] arr,int low,int high){
        int pivot = arr[low];
        int OldLow = low;
        while (low < high){
            while (arr[high] >= pivot && low < high) high--;
            while (arr[low] <= pivot && low < high) low++;
            if(low < high) swap(arr, low, high);
        }
        arr[OldLow] = arr[low];
        arr[low] = pivot;
        return high; // 最后 low 和 high 是相等的
    }

    /** swap 函数 **/
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode_215_KthLargestElementinanArray solu = new Leetcode_215_KthLargestElementinanArray();
        solu.findKthLargest3(new int[]{-1, 2, 0}, 2);
    }
}
