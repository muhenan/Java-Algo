package CyC2018.Leetcode.DataStructure.Graph;

/**
 * 并查集
 * 并查集可以动态地连通两个点，并且可以非常快速地判断两个点是否连通。
 *
 * 1. 冗余连接
 * */
public class Leetcode_684_RedundantConnection {
    /**
     * 并查集做法直接过，时间效率无敌
     * 找到最后重复 merge 的那条边即可
     * */
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int length = edges.length;
        parent = new int[length + 1];
        for (int i = 0; i < length + 1; i++) parent[i] = i;
        int result = -1;
        for (int i = 0; i < length; i++) {
            if (find(edges[i][1]) == find(edges[i][0])) result = i;
            else merge(edges[i][0], edges[i][1]);
        }
        return edges[result];
    }
    public int find(int x) { // 这里的 find 是直接找到跟节点，是路径压缩后的
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }
    public void merge(int i, int j) { // i 在 j 上
        parent[find(j)] = find(parent[i]);
    }
}
