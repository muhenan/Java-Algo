package CyC2018.Leetcode.DataStructure.StackAndQueue;

import java.util.Stack;

//public class Leetcode_232_ImplementQueueusingStacks {
//}

/**
 * 非常简单也非常经典的一个题目
 * 两个栈实现一个队列
 * 每个操作均摊时间复杂度为 O(1)
 * 换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间
 * **/

class MyQueue {

    private Stack<Integer> InStack;

    private Stack<Integer> OutStack;

    public MyQueue() {
        InStack = new Stack<>();
        OutStack = new Stack<>();
    }

    public void push(int x) {
        InStack.push(x);
    }

    public int pop() {
        if (OutStack.empty()) moveElementsFromInToOut();
        return OutStack.pop();
    }

    public int peek() {
        if (OutStack.empty()) moveElementsFromInToOut();
        return OutStack.peek();
    }

    public boolean empty() {
        return (InStack.empty() && OutStack.empty());
    }

    private void moveElementsFromInToOut() {
        while (!InStack.empty()) OutStack.push(InStack.pop());
    }
}
