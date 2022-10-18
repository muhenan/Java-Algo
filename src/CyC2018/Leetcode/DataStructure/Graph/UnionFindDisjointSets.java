package CyC2018.Leetcode.DataStructure.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 并查集，路径压缩，秩 rank
 *
 * https://blog.csdn.net/weixin_38279101/article/details/112546053
 *
 */
public class UnionFindDisjointSets {

    private int[] parent;

    public UnionFindDisjointSets(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) { // 这里的 find 是直接找到跟节点，是路径压缩后的
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }

    /** 把 j 合并到 i 中 */
    public void merge(int i, int j) { // i 在 j 上
        parent[find(j)] = find(parent[i]);
    }
}
