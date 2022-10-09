package CyC2018.Leetcode.Algo.Math.Others;

public class Leetcode_169_MajorityElement {
    /**
     * 非常像以前做过的一个打擂台的问题，秒过
     * */
    public int majorityElement(int[] nums) {
        int count = 0;
        int current = 0;
        for (int num:nums) {
            if (count == 0) {
                count++;
                current = num;
            } else if (current == num) count++;
            else {
                count--;
            }
        }
        return current;
    }

    /**
     * 排序方法这里就不写了，没必要
     *
     * 不过如果是比赛，可以直接排序，然后拿，因为比赛要求的是你过用最短的时间
     *
     * 时间效率肯定是会低，但是比赛中要求的是你快速过
     * */
}
