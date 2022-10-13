package Company.EBay;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CustomStack {

    /**
     * 首先题目非常非常简单，就是关于 List 的使用而已
     * 过不是问题
     *
     * 问题是时间效率
     *
     * 这里的 push 弄的不好，时间复杂度变成 O(N) 了
     *
     * 改成从后面 push 的，也就是 push back 的，就好很多
     * 整个题目就完全通了
     *
     * 至此，已经能做到前面两个是 O(1) 最后一个是 O(k) 了
     *
     * 现在思考如何将最后的 O(k) 优化成 O(1)
     *
     * */

    int maxSize;
    List<Integer> list;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        list = new ArrayList<>();
    }

    public void push(int x) {
        if (list.size() == maxSize) return;
        else {
            list.add(0, x); // add from prior
        }
    }

    public int pop() {
        if (list.size() == 0) return -1;
        int top = list.get(0);
        list.remove(0);
        return top;
    }

    public void increment(int k, int val) {
        if (list.size() < k) {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) + val);
            }
        } else {
            for (int i = 1; i <= k; i++) {
                list.set(list.size() - i, list.get(list.size() - i) + val);
            }
        }
    }


    /**
     * 加一个辅助的数据
     * 记录这里要 increment 多少
     * pop 的时候，这个 increment 要传递到前面一个
     * 这样得到了，最后的 increment 的时间复杂度 也是 O(1)
     * */
    /**
    int n;
    int[] inc;
    Stack<Integer> stack;
    public CustomStack(int maxSize) {
        n = maxSize;
        inc = new int[n];
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.size() < n)
            stack.push(x);
    }

    public int pop() {
        int i = stack.size() - 1;
        if (i < 0)
            return -1;
        if (i > 0)
            inc[i - 1] += inc[i];
        int res = stack.pop() + inc[i];
        inc[i] = 0;
        return res;
    }

    public void increment(int k, int val) {
        int i = Math.min(k, stack.size()) - 1;
        if (i >= 0)
            inc[i] += val;
    }*/
}
