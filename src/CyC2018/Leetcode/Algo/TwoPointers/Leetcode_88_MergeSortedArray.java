package CyC2018.Leetcode.Algo.TwoPointers;

/**
 * 经典的两个数组，在一个原数组上来回覆盖的题目
 *
 * 这个题的经典之处在于
 * 沾点三指针了！！！！！！
 * 一个指着数组1，一个指着数组2，一个指着数组3 即合成的数组（实际上这个数组是在数组1上覆盖而来的）
 *
 * 注意这种覆盖的，是从后面开始弄的
 *
 * 当一个数组已经走到头时，接下来全赋另外一个数组
 * **/

public class Leetcode_88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index3 = m + n - 1;
        while (index3 >= 0) {
            if (index1 < 0) {
                nums1[index3--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[index3--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[index3--] = nums1[index1--];
            } else {
                nums1[index3--] = nums2[index2--];
            }
        }
    }
}
