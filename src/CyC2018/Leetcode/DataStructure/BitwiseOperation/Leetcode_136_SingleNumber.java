package CyC2018.Leetcode.DataStructure.BitwiseOperation;

/**
 * 这题就是给亦或准备的
 * 两个相同的数异或的结果为 0，对所有数进行异或操作，最后的结果就是单独出现的那个数。
 * */
public class Leetcode_136_SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int n : nums) result = result ^ n;
        return result;
    }
}
