package Problems;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_1521 {
    /**
     * 集合里面存的，永远都是 从这个 r 往左，各个区间，按位与的结果
     * 算法看起来是 n2 的
     * 但为什么是 On 呢
     * 是因为第二个 for 是有个常数次数的
     * 第二个 for 循环的次数是 set 的 size
     * 从 r 往左按位与，结果中的 1 肯定会越来越少（因为按位与会导致，0 不可能变成 1，1 可能会变成 0）
     * 所以比如值最多 31 位，那么即使 r 是 31 个 1，到任何 l 按位与的结果也顶多 31 种，最多每次少 1 个 1 嘛，你最多少 31 个
     * 所以说 set 的 size 有个最大值 比如 31 ，所以算法不会超过 n * 31
     *
     *
     * 关键是认识到，按位与，值只会越来越小，只会让原有的某些 1 变成 0
     *
     *
     * */
    public int closestToTarget(int[] arr, int target) {
        Set<Integer> my_set = new HashSet<>();
        my_set.add(arr[0]);
        int result = Math.abs(arr[0] - target);
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            Set<Integer> new_set = new HashSet<>();
            new_set.add(arr[i]);
            result = Math.min(result, Math.abs(arr[i] - target));
            for (Integer ele : my_set) {
                int value = ele.intValue() & arr[i];
                new_set.add(value);
                result = Math.min(result, Math.abs(value - target));
            }
            my_set = new_set;
        }
        return result;
    }
}
