package CyC2018.Leetcode.DataStructure.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

// 有点无语的一道题目，用 队列 实现 栈，这样的话，每次存的时间复杂度都是 O(n)

public class Leetcode_225_ImplementStackusingQueues {
}

class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        int cnt = queue.size();
        while (cnt-- > 1) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
