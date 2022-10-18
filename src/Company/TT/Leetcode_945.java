package Company.TT;

import java.util.Arrays;

public class Leetcode_945 {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        boolean[] appear = new boolean[1000000];
        int result = 0;
        for (int num : nums) {
            if (!appear[num]) appear[num] = true;
            else {
                int temp = num;
                while (appear[temp]) {
                    temp++;
                    result++;
                }
                appear[temp] = true;
            }
        }
        return result;
    }


    /**
     * 直接变成前一个数加一就好了，因为前一个数已经是最小的了
     * */
    public int minIncrementForUnique2(int[] A) {
        // 先排序
        Arrays.sort(A);
        int move = 0;
        // 遍历数组，若当前元素小于等于它的前一个元素，则将其变为前一个数+1
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int pre = A[i];
                A[i] = A[i - 1] + 1;
                move += A[i] - pre;
            }
        }
        return move;
    }


    /**
     * 计数
     * 计数之后对于计数不是 1 ，每次都剩一个，然后其他的往后推
     * 最后到 max + 1 推个等差数列个
     * */
    public int minIncrementForUnique3(int[] A) {
        // counter数组统计每个数字的个数。
        //（这里为了防止下面遍历counter的时候每次都走到40000，所以设置了一个max，这个数据量不设也行，再额外设置min也行）
        int[] counter = new int[40001];
        int max = -1;
        for (int num: A) {
            counter[num]++;
            max = Math.max(max, num);
        }

        // 遍历counter数组，若当前数字的个数cnt大于1个，则只留下1个，其他的cnt-1个后移
        int move = 0;
        for (int num = 0; num <= max; num++) {
            if (counter[num] > 1) {
                int d = counter[num] - 1;
                move += d;
                counter[num + 1] += d;
            }
        }
        // 最后, counter[max+1]里可能会有从counter[max]后移过来的，counter[max+1]里只留下1个，其它的d个后移。
        // 设 max+1 = x，那么后面的d个数就是[x+1,x+2,x+3,...,x+d],
        // 因此操作次数是[1,2,3,...,d],用求和公式求和。
        int d = counter[max + 1] - 1;
        move += (1 + d) * d / 2;
        return move;
    }


    /**
     * 这个寻址，路径压缩的方法可以学一下
     * 这个也是我一直想的方法
     * 然后这个路径压缩和那个 union find 其实是一样的
     * */
    int[] pos = new int [80000];
    //https://leetcode.cn/problems/minimum-increment-to-make-array-unique/submissions/
    public int minIncrementForUnique4(int[] A) {
        Arrays.fill(pos, -1); // -1表示空位
        int move = 0;
        // 遍历每个数字a对其寻地址得到位置b, b比a的增量就是操作数。
        for (int a: A) {
            int b = findPos(a);
            move += b - a;
        }
        return move;
    }

    // 线性探测寻址（含路径压缩）
    private int findPos(int a) {
        int b = pos[a];
        // 如果a对应的位置pos[a]是空位，直接放入即可。
        if (b == -1) {
            pos[a] = a;
            return a;
        }
        // 否则向后寻址
        // 因为pos[a]中标记了上次寻址得到的空位，因此从pos[a]+1开始寻址就行了（不需要从a+1开始）。
        b = findPos(b + 1);
        pos[a] = b; // 寻址后的新空位要重新赋值给pos[a]哦，路径压缩就是体现在这里。
        return b;
    }
}
