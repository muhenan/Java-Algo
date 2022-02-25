package CyC2018.Leetcode.DataStructure.ArrayAndMatrix;

// 方法一：哈希表，计数。缺的少的一目了然。时间复杂度线性。

// 方法二：一直交换，交换到只有一个位置不对的时候停，如果两个位置不对就发生交换
//          最后返回的时候，重复的靠数组的 value 找到，缺少的靠应该等于什么得到，这个非常精髓，可以看看代码里的注释

public class Leetcode_645_SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int res[] = new int[2];
        int table[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            table[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            table[nums[i] - 1]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if(table[i] > 1) res[0] = i + 1;
            else if(table[i] == 0) res[1] = i + 1;
        }
        return res;
    }


    public int[] findErrorNums2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1}; // 这个数应该是 i + 1，但是这个数不是，说明缺少了 i + 1
            }
        }
        return null;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
