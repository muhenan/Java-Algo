package Company.TT;

import java.util.Scanner;

public class SocialNetwork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int m = sc.nextInt();
            MyUnionFindDisjointSets ds = new MyUnionFindDisjointSets(100001);
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                ds.merge(x, y);
            }
            System.out.println(ds.getMaxNetwork());
        }
    }
}


class MyUnionFindDisjointSets {

    private int[] parent;

    public MyUnionFindDisjointSets(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) { // 这里的 find 是直接找到跟节点，是路径压缩后的
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }

    /** j to i */
    public void merge(int i, int j) { // i 在 j 上
        parent[find(j)] = find(parent[i]);
    }

    public int getMaxNetwork() {
        int[] temp = new int[parent.length];
        for (int num : parent) temp[find(num)]++;
        int max = 0;
        for (int num : temp) max = Math.max(num, max);
        return max;
    }
}
