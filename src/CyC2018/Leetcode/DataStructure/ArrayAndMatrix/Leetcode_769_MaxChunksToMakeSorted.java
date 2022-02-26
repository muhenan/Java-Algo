package CyC2018.Leetcode.DataStructure.ArrayAndMatrix;

/**
 * 方法一：自解方法，一遍遍历，记录 high 和 low 找出一个一个的小分区，每找出一个 count++
 *
 * 方法二：力扣官方方法
 *          这里提到了一个非常精髓的思想，就是，我们的目的是前 k （索引） 个数中最大的是 k，这样我们就找到了一个块
 *          就是这个意思，前 k （索引） 里最大的是 k 说明这前面没有比 k 大的
 *          我们只要判断当前的最大值是不是等于 index 即可，这样的话我们就找到了一个块
 * **/

public class Leetcode_769_MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int result = 0;
        int length = arr.length;
        boolean isLowOk = false;
        boolean isHighOk = false;
        int low = -1;
        int high = -1;
        for (int i = 0; i < length; i++) {
            if (low == -1) low = i;
            if (arr[i] > high) high = arr[i];
            if (arr[i] == low) isLowOk = true;
            if (high == i) isHighOk = true;
            if (isLowOk && isHighOk) {
                result++;
                isLowOk = false;
                isHighOk = false;
                low = -1;
                high = -1;
            }
        }
        return result;
    }


    public int maxChunksToSorted2(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if (max == i) ans++;
        }
        return ans;
    }

}
