package CyC2018.Leetcode.DataStructure.BitwiseOperation;

public class BO_swap {
    public void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b; // b = a ^ b ^ b = a
        a = a ^ b; // a = a ^ b ^ a = b
    }
}
