package CyC2018.Leetcode.DataStructure.BitwiseOperation;

public class Leetcode_338_CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }

    /**
     * 有点 DP 的思想，通过查表，不用每次都重复算
     * 用到了 i & (i - 1) 去掉最右的一个 1
     * 去掉这个之后，剩的内容 ret 数组里肯定已经保存里，拿出来用然后加一即可
     * */
    public int[] countBits2(int num) {
        int[] ret = new int[num + 1];
        for(int i = 1; i <= num; i++){
            ret[i] = ret[ i & (i - 1)] + 1;
        }
        return ret;
    }
}
