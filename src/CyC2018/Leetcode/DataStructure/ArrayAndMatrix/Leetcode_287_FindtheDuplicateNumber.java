package CyC2018.Leetcode.DataStructure.ArrayAndMatrix;

//题目要求：你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间！

/**
 * 如果没有任何要求的话，我想到的最简单的方法是计数，时间空间复杂度都是线性，不符合常量的空间复杂度
 *
 * 空间复杂度常量的话，我们考虑在原数组上操作
 *
 *  方法 1 ：参考 645 来回交换，如果两个位置都不对都能换的话，就换到正确的位置，这样的话，都换完了，最后走一遍就知道哪个重复了
 *          时间复杂度 O(N)
 *          4ms
 *
 *  方法 2 ：二分查找的方法
 *          这里还搞二分查找的思想感觉有点强行了，不太适用，时间复杂度达到了 NlogN，总体而言我不推荐
 *          做法就是弄个 mid 然后全局找 小于 mid 的个数，如果比预计的多了，说明重复的数是小于 mid 的
 *                                                  如果比预计的少或者正常，...大于 mid
 *  方法 3 ：快慢指针（链表环）
 *          时间复杂度 O(N)
 *          首先，由于这种特殊形势，你要知道 如果你 nums[nums[i]] 这样的找下去，就像一个链表一样
 *          而且这个链表有环，这个链表是一个棒棒糖形状的，即从一个直路走进一个环里，环的交点处，说明被指了两次，就是重复的数
 *
 *          如何找到链表环的结点呢？
 *                  想象：
 *                      当慢指针走到 结点 时，我们认为慢指针走了 a ，也就是直线的长度的 a
 *                      此时快指针就在圈里走了 a 了，假设这时候快指针距离慢指针的距离是 b
 *                      那么慢指针再走 b，快指针也就走了 2b 这个时候刚好追上，在环里相遇了
 *                      这时我们知道 快指针再走 a 就到结点了，怎么量这个 a 呢，从起点再走一个慢指针，这时快慢的都是一格一格的走，都走 a 的时候刚好在结点相遇
 *           6ms
 *
 *
 * **/

public class Leetcode_287_FindtheDuplicateNumber {

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int findDuplicate(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) swap(nums, i, nums[i] - 1);
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) return nums[i];
        }
        return 0;
    }

    public int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
