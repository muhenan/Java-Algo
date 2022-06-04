package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.DFS;

import java.util.HashSet;
import java.util.Set;

/**
 * 连通分量数目
 *
 * 差不多都是一个意思了
 * */
public class Leetcode_547_FriendCircles {
    // 自解方法，轻松通过，先算了连通分量的个数，即有线相连，至少两个
    // 期间记录了连通的个数，最后返回 ans + (row - nodes.size())
    private int row, col;
    private Set<Integer> nodes;
    public int findCircleNum(int[][] isConnected) {
        row = isConnected.length;
        col = isConnected[0].length;
        int ans = 0;
        nodes = new HashSet<>();
        for (int i = 0; i < row; i++){
            for (int j = i + 1; j < col; j++) {
                if (isConnected[i][j] == 1) {
                    dfs(isConnected, i);
                    ans++;
                }
            }
        }
        return ans + (row - nodes.size());
    }

    private void dfs (int[][] isConnected, int num) {
        nodes.add(num);
        for (int i = 0; i < col; i++) {
            if (isConnected[num][i] == 1 && num != i) {
                isConnected[num][i] = 0;
                isConnected[i][num] = 0;
                dfs(isConnected, i);
            }
        }
        return;
    }


    /**
     * Cyc 方法
     * 记录便利是用了一个布尔数组 boolean[] hasVisited = new boolean[n];
     * 只要没遍历过就 circleNum++;
     * 大大提高了效率
     * */
/**
    private int n;

    public int findCircleNum(int[][] M) {
        n = M.length;
        int circleNum = 0;
        boolean[] hasVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!hasVisited[i]) {
                dfs(M, i, hasVisited);
                circleNum++;
            }
        }
        return circleNum;
    }

    private void dfs(int[][] M, int i, boolean[] hasVisited) {
        hasVisited[i] = true;
        for (int k = 0; k < n; k++) {
            if (M[i][k] == 1 && !hasVisited[k]) {
                dfs(M, k, hasVisited);
            }
        }
    }


 */

    public static void main(String[] args) {
        Leetcode_547_FriendCircles solu = new Leetcode_547_FriendCircles();
        int[][] graph = {{1,1,1},{1,1,1},{1,1,1}};
        solu.findCircleNum(graph);
    }
}
