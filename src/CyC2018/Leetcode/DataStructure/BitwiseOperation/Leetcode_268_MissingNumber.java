package CyC2018.Leetcode.DataStructure.BitwiseOperation;

public class Leetcode_268_MissingNumber {
    /**
     * 简单方法就不提了，这里是 BO 方法
     * 全部亦或一遍，再和不缺的情况全部亦或一遍，缺少的那个就出来了
     * */
    public int missingNumber(int[] nums) {
        int result = 0; // 0 和其他数亦或不影响其他数
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            result = result ^ i ^ nums[i];
        }
        result = result ^ length;
        return result;
    }
}
