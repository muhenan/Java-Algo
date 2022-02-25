package CyC2018.Leetcode.DataStructure.ArrayAndMatrix;

// 和 LinkedList 里的 23 有想通之处，从那道题可以得到很多启发
// 那题到 O(nklogk) 极限了，这题我们探寻更好的解法

import Array.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 方法一：直接排序
 *      时间复杂度 n2 * logn2 = n2 * 2 * logn = O(n2logn)
 *
 * 方法二：优先队列维护最小（加归并思想）
 *      注意这里我们只是要找到最小的即可，这种题目的话，自然想到用优先队列最小堆来维护最小
 *      这个的一个之前你没有的思想就是，你要维护一个复杂优先队列，就和 23 一样，这个优先队列的元素并不只是数
 *      这个元素还带着各种其他附加的东西，比如什么指针，比如是数组里的第几个，等等信息，构建一个复杂的数组
 *      第一次先把第一列，放进去，构成 pq，取出第一个后，从取出的这个后面补一个，这样保证了最小的肯定在新的 pq 里
 *
 *      时间复杂度：klogn
 *
 *      这个优先队列的长度是 n，一共存取了 k 次
 *
 * 方法三：二分查找
 *      太过高端的二分查找，今天的我并不能很好的理解
 *      二分查找的核心就是，一个 left，一个 right，不断的夹逼，不断的夹逼，最后找到要查找的值
 *      这里我们夹逼的依据是比这个数小的数有多少个
 *
 *      每次对于「猜测」的答案 mid，计算矩阵中有多少数不大于 mid ：
 *      如果数量不少于 k，那么说明最终答案 x 不大于 mid；
 *      如果数量少于 k，那么说明最终答案 x 大于 mid。
 *
 *      这里又有个非常关键的点，就是不小于这件事，不小于 mid 的有 5 个，那么说明 mid 就是第 5 小的！！！
 *      比如 1 1 2 2 3 4 5 6 9 里面的 3
 *
 *      关于这里的找，left mid right 给出了，然后去找那个 num 的时候
 *      不用在意是找到时候是 (left, mid] 还是 [left, mid]
 *      因为这里的找可以认为是整个从矩阵里找的，这点非常舒服！
 *
 *      时间复杂度 O(n)
 *
 *
 * **/

//写在最后
//        上述三种解法
//        第一种没有利用矩阵的性质，所以时间复杂度最差；
//        第二种解法只利用了一部分性质（每一行是一个有序数列，而忽视了列之间的关系）；
//        第三种解法则利用了全部性质，所以时间复杂度最佳。
//
//        这也启示我们要认真把握题目中的条件与性质，更有利于我们解题。

public class Leetcode_378_KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] sortedArr = new int[n * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sortedArr[index++] = matrix[i][j];
            }
        }
        Arrays.sort(sortedArr); // logn
        return sortedArr[k - 1];
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        int i = 0;
        while (i < k - 1) {
            int[] min = pq.poll();
            if (min[2] != n - 1) pq.offer(new int[]{matrix[min[1]][min[2] + 1], min[1], min[2] + 1});
            i++;
        }
        return pq.poll()[0];
    }

    public int kthSmallest3(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1; // 如果这样，那么说明不小于 mid 的太少了，少于 k 个，那么说明 mid 一定比正确答案小 （这个加一是 matrix[row][col] > mid 带来的）
            }
        }
        return left;
    }
    public boolean check(int[][] matrix, int mid, int k, int n) {
        int row = n - 1;
        int col = 0;
        int num = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                num += row + 1; // 这里是竖着算的，直接把这一列的，上面的都算进来
                col++;
            } else {
                row--;
            }
        }
        return num >= k;
    }

    // 方法 3 简化一下代码，一个函数解决问题
    public int kthSmallest31(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int row = n - 1;
            int col = 0;
            int num = 0;
            while (row >= 0 && col < n) {
                if (matrix[row][col] <= mid) {
                    num += row + 1; // 这里是竖着算的，直接把这一列的，上面的都算进来
                    col++;
                } else {
                    row--;
                }
            }
            if (num >= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
