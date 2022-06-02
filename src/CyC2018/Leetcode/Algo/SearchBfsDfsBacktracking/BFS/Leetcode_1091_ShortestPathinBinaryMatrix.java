package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.BFS;



import java.util.*;

/**
 * 尝试了直接暴力八方向 DFS 后，发现如果只是暴力的全方向 DFS 会造成无限循环，沿着几个 0 转圈的情况
 * 所以这道题变成了非要用 BFS 不可！！
 * */
public class Leetcode_1091_ShortestPathinBinaryMatrix {

    /**
     * 这里加入了 BFS 的一个重要思想：标记 ！！
     * 简而言之就是走过的点一定不再走了
     *
     * 在图里走，方向用小数组
     *
     * 走 BFS 要走一圈一圈走这种概念
     *
     * */
    public int shortestPathBinaryMatrix(int[][] grids) {
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}}; // 可能走的方向
        int n = grids.length;
        Queue<Node> queue = new LinkedList<>(); // 用一个队列搞 BFS，队列中存的是一个 pair
        queue.add(new Node(0, 0)); // 把第一个放进去
        int pathLength = 0; // 记录走了多长
        while (!queue.isEmpty()) { // 队列不空就继续向下走
            int size = queue.size(); // 这一轮要遍历多少个
            pathLength++; // 走一轮路径长度肯定加一
            while (size-- > 0) { // 开始走这一轮，或者说这一圈
                Node cur = queue.poll(); // 从队列中拿出一个 Node
                int currRow = cur.row, currCol = cur.col;
                if (grids[currRow][currCol] == 1) continue; // 如果是 1 直接跳过这个点了
                if (currRow == n - 1 && currCol == n - 1) return pathLength; // 如果到最后说明结束了，已经找到最短路径了
                grids[currRow][currCol] = 1; // 标记。这个点走完，要把自己标记掉，防止走回头路
                for (int[] d : direction) { // 八个方向走下一轮
                    int nowRow = currRow + d[0], nowCol = currCol + d[1];
                    if (nowRow < 0 || nowRow >= n || nowCol < 0 || nowCol >= n) continue; // 如果位置超出图 直接不走这个了
                    queue.add(new Node(nowRow, nowCol)); // 点合理，加入队列，下一轮再搞
                }
            }
        }
        return -1; // 如果没有找到路径，返回 -1，找不到
    }

    private class Node {
        int row;
        int col;
        Node(int r, int c) {
            row = r;
            col = c;
        }
    }
    /**
     * 我体会的 BFS 的模版：
     *
     * 1 弄一个队列，把第一个点放进去
     * 2 从队列中取一个点，把这个点的相邻的放到队列后面，把这个点标记成已遍历
     * 3 每弄这么一轮，就相当于路径走了 1，路径加一
     * */
}
