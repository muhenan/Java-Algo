package CyC2018.Leetcode.Algo.Math;

/**
 * 每一个数都可以分解成素数的乘积
 * 每一个数都可以分解成素数的乘积，例如 84 = 2^2 * 3^1 * 5^0 * 7^1 * 110 * 130 * 170 * …
 * （最小的质数是 2，1 不是质数）
 *
 * 整除
 * 令 x = 2m0 * 3m1 * 5m2 * 7m3 * 11m4 * …
 *
 * 令 y = 2n0 * 3n1 * 5n2 * 7n3 * 11n4 * …
 *
 * 如果 x 整除 y（y mod x == 0），则对于所有 i，mi <= ni。
 * 就是 y 那边的东西肯定比 x 多
 *
 * x 和 y 的最大公约数为
 * x 和 y 的最小公倍数为
 * x 和 y 的最大公约数为：gcd(x,y) = 2min(m0,n0) * 3min(m1,n1) * 5min(m2,n2) * ...
 * gcd 相当于取 && 的部分
 * x 和 y 的最小公倍数为：lcm(x,y) = 2max(m0,n0) * 3max(m1,n1) * 5max(m2,n2) * ...
 * lcm 相当于取 || 的部分
 * */
public class MathOverview {
    /**
     * GCD 辗转相除法
     * 如果大的能整除小的，那么小的就是 gcd
     * 如果不能，那么 big = k * small + reminder
     * 这种情况下，GCD 最大不会超过 reminder，找 gcd(small, reminder)
     *
     * 函数的思路，如果右边这个小的是 0 ，那么左边这个就是结果了
     * 如果不是，那么让小的这个来左边当大的，用 a % b 找到一个比 b 更小的 reminder 当右边的
     * */
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b); // a % b must less than b, so make the right one smaller
    }

    /**
     * 不必多说，如果一个是 ab，另一个是 ac
     * 那么 gcd 就是 a
     * lcm 就是 abac / a = abc
     * */
    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    /**
     * 对于 a 和 b 的最大公约数 f(a, b)，有：
     *
     * 如果 a 和 b 均为偶数，f(a, b) = 2*f(a/2, b/2);
     * 如果 a 是偶数 b 是奇数，f(a, b) = f(a/2, b);
     * 如果 b 是偶数 a 是奇数，f(a, b) = f(a, b/2);
     * 如果 a 和 b 均为奇数，f(a, b) = f(b, a-b);
     * 乘 2 和除 2 都可以转换为移位操作。
     * */

    public int gcd2(int a, int b) {
        if (a < b) {
            return gcd2(b, a); // 确保把小的放右边
        }
        if (b == 0) {
            return a;
        }
        boolean isAEven = isEven(a), isBEven = isEven(b);
        if (isAEven && isBEven) {
            return 2 * gcd2(a >> 1, b >> 1); // 或许这里也可以变成位移？
        } else if (isAEven && !isBEven) {
            return gcd(a >> 1, b);
        } else if (!isAEven && isBEven) {
            return gcd2(a, b >> 1);
        } else {
            return gcd2(b, a - b); // 都是奇数这里就用了辗转相减了
        }
    }

    private boolean isEven(int a) {
        return a % 2 == 0;
    }
}
