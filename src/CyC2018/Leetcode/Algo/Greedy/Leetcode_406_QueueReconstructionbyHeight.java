package CyC2018.Leetcode.Algo.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 我们算法大概的思想就是，把元素一个一个的 insert 进一个 List 里
 * 所以的话，时间复杂度难逃 n2
 *
 * 至于怎么插入呢，这就涉及一个先排序的问题，先把原始的数组做一个排序
 * 这里我们就需要思考，关于 insert 这件事，插进去以后，无论你插进去什么，插进去的这个都不会对前面造成影响
 * 只会对后面的造成影响，所以我们考虑先插入高的，后插入矮的，因为这样的话，你插入的这个对前后都不会有影响
 * 所以我们排序的时候，根据高度降序排序，那个前面有多少人这个元素当然是升序，因为前面人多的站后面呗
 *
 * **/

public class Leetcode_406_QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) return new int[0][0];
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) queue.add(p[1], p); // 这里的这个插入就是，如果要插入的 index 上已经有元素了，那么这个元素会把之前的顶到后面去
        return queue.toArray(new int[queue.size()][]);
    }
}
