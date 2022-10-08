package CyC2018.Leetcode.Algo.Math.gcd_lcm;

public class Leetcode_204_CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int[] primes = new int[n + 2];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (i != 2 && i % 2 == 0) continue; // 不加这行的时候超时，加了之后以超长的时间过了，算是一点点奇数筛的思想
            boolean isPrime = true;
            int sqrt = (int)Math.sqrt(i);
            for (int j = 0; j < count && primes[j] <= sqrt; j++) {
                if (i % primes[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primes[count++] = i;
        }
        return count;
    }

    /**
     * 埃拉托斯特尼筛法在每次找到一个素数时，将能被素数整除的数排除掉。
     * 速度快了很多
     * */
    public int countPrimes2(int n) {
        boolean[] notPrimes = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrimes[i]) {
                continue;
            }
            count++;
            // 从 i * i 开始，因为如果 k < i，那么 k * i 在之前就已经被去除过了
            for (long j = (long) (i) * i; j < n; j += i) {
                notPrimes[(int) j] = true;
            }
        }
        return count;
    }



    /**
     * 检测一个数是不是质数
     * sqrt(n) 的时间复杂度
     * */
    boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) { // 可以提前算一个 sqrt 然后放在这
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
