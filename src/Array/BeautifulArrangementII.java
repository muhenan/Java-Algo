package Array;

public class BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        int res[] = new int[n];
        boolean high = false;
        int small = 1;
        int big = n;
        int i = 0;
        for(i = 0; i < n && k > 1; i++){
            //System.out.println("k is " + k);
            if(high) res[i] = big--;
            else res[i] = small++;
            high = !high;
            k--;
        }
        while (i < n){
            if(high) res[i++] = big--;
            else res[i++] = small++;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 8;
        int k = 3;
        BeautifulArrangementII test = new BeautifulArrangementII();
        int result[] = test.constructArray(n,k);
        System.out.println("hello everybody");
        for(int i : result) System.out.println(i);
    }
}
