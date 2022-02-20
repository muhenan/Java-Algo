package CyC2018.Leetcode.DataStructure.ArrayAndMatrix;

/*
* 几个关键的点：
* 1. 数组上快慢两个指针一遍遍历
* 2. 数组上快慢两个指针重复覆盖（原地覆盖，节省空间）
* （以上两个都是数组题的经典技巧和思想（注意经典的思想），一定要会用）
* */

public class Leetcode_283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        if (length <= 1) return;
        int index = 0;
        for (int i = 0; i < length; i++) if (nums[i] != 0) nums[index++] = nums[i];
        while (index < length) nums[index++] = 0;
        return;
    }
}
