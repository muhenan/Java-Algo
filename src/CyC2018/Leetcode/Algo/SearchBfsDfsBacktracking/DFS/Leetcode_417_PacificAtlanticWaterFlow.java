package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.DFS;

import java.util.*;

public class Leetcode_417_PacificAtlanticWaterFlow {
    /**
     * 自解方法，顺利通过，相等的这种情况困扰了很久
     * 最后采取的是一个极其耗时，但是逻辑清晰的方法
     *
     * 每次要算一个点的连通情况时，先初始化标记表，再开始 dfs，最后算出来以后把这次算的结果放到字典里，以后如果用到的话可以直接拿
     * */
    private int row, col;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // dfs 时要走的四个方向

    HashMap<Integer, Integer> results;

    boolean[][] visited;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        row = heights.length;
        col = heights[0].length;
        results = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                visited = new boolean[row][col];
                int tempRes = dfs(heights, r, c);
                results.put(getIndex(r,c), tempRes);
                if (tempRes == 3) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(r);
                    temp.add(c);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

    // 0 neither 1 left and up 2 right and down 3 both
    private int dfs (int[][] heights, int r, int c) {

        boolean[] res = new boolean[4];

        int index = getIndex(r,c);

        if (results.containsKey(index)) return results.get(index);

        visited[r][c] = true; // 标记自己

        for (int[] d : direction) { // 四个方向走

            int next_r = r + d[0];
            int next_c = c + d[1];

            if (next_c < 0 || next_r < 0) { // 界外
                res[1] = true;
                continue;
            }
            if (next_r >= row || next_c >= col) { // 界外
                res[2] = true;
                continue;
            }

            if (heights[next_r][next_c] > heights[r][c]) continue; // 低洼 旁边更高

            if (results.containsKey(getIndex(next_r, next_c))) { // 旁边的已经放进去了，即旁边的已经算过了
                res[results.get(getIndex(next_r, next_c))] = true;
                continue;
            }

            if (!visited[next_r][next_c]) { // 旁边的没遍历过，继续 dfs
                res[dfs(heights, next_r, next_c)] = true;
                continue;
            }

        }

        // 结果
        int ans = 0;
        if (res[3]) ans = 3;
        else if (res[2] && res[1]) ans = 3;
        else if (res[2]) ans = 2;
        else if (res[1]) ans = 1;
        return ans;
    }

    private int getIndex (int r, int c) {
        return r * col + c;
    }


    public static void main(String[] args) {
        Leetcode_417_PacificAtlanticWaterFlow solu =  new Leetcode_417_PacificAtlanticWaterFlow();
        solu.pacificAtlantic(new int[][]{{3,3,3,3,3,3},{3,0,3,3,0,3},{3,3,3,3,3,3}});
    }

    /**
     *
     * Cyc 方法，极其巧妙的方法，一定要反复学习，吸纳！！！
     *
     * 依旧是反向的思维
     *
     * 从高到低延伸到边界不好找
     * 那么就从边界从低向高延伸，只要能延伸过去就说明这个点可以到边界
     * 从四个边界往里延伸
     * 只要记录这个点能否到某一个边界即可
     * 最后再检查，这个点是不是两个边界都能到
     *
     * 反向思维！！！！！！！！！！！以退为进！！！！！
     *
     * 太强了，自愧不如！！！！
     *
     * 130 和 417 两个反向思维的思路，要反复学习！！！！
     *
     * */

    /**
    private int m, n;
    private int[][] matrix;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ret;
        }

        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, canReachP);
            dfs(i, n - 1, canReachA);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, canReachP);
            dfs(m - 1, i, canReachA);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachP[i][j] && canReachA[i][j]) {
                    ret.add(Arrays.asList(i, j));
                }
            }
        }

        return ret;
    }

    private void dfs(int r, int c, boolean[][] canReach) {
        if (canReach[r][c]) {
            return;
        }
        canReach[r][c] = true;
        for (int[] d : direction) {
            int nextR = d[0] + r;
            int nextC = d[1] + c;
            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n
                    || matrix[r][c] > matrix[nextR][nextC]) {

                continue;
            }
            dfs(nextR, nextC, canReach);
        }
    }*/



}
