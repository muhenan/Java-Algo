package CyC2018.Leetcode.DataStructure.BitwiseOperation;

/**
 * x ^ 0s = x      x & 0s = 0      x | 0s = x
 * x ^ 1s = ~x     x & 1s = x      x | 1s = 1s
 * x ^ x = 0       x & x = x       x | x = x
 * */


/**
 *
 * 更多性质和运算：
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E4%BD%8D%E8%BF%90%E7%AE%97.md#leetcode-%E9%A2%98%E8%A7%A3---%E4%BD%8D%E8%BF%90%E7%AE%97
 *
 * */


/**
 * a + b 相当于
 *
 * (a^b) + (a&b)*2 ：可以认为是不进位加进位
 * (a^b) 就是把不进位的，原位置的数拿到了
 * (a&b)*2 是拿到进位，并向左已一下，即找到了所有的进位
 *
 * (a&b) +(a|b) ：相当于在原地的进位，加上在原地的进位和不进位
 * (a&b) 把进位保存下来，在原地
 * (a|b) 把进位和不进位都保存下来，在原地
 * 加的时候该进位的自然会向左进位了
 *
 * */
public class BO_Overview {

    public static void main(String[] args) {
        int a = 11;
        System.out.println(Integer.toBinaryString(a));
    }
}
