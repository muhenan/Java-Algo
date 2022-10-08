package CyC2018.Leetcode.DataStructure.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_785_IsGraphBipartite {
    /**
     * 走一个 BFS
     *
     * 并且考虑到可能不止一个连通分量
     * */
    public boolean isBipartite(int[][] graph) {
        int length = graph.length;
        HashMap<Integer, Boolean> my_map = new HashMap<>();
        Queue<Integer> my_queue = new LinkedList<>();
        boolean[] appeared = new boolean[length];
        for (int j = 0; j < length; j++) {
            if (graph[j].length == 0) {
                appeared[j] = true;
                continue;
            }
            if (appeared[j]) continue;
            my_queue.add(j);
            appeared[j] = true;
            my_map.put(j, true);
            while (!my_queue.isEmpty()) {
                int value = my_queue.poll();
                boolean color = my_map.get(value);
                for (int i = 0; i < graph[value].length; i++) {
                    if (my_map.containsKey(graph[value][i])) {
                        if (color == my_map.get(graph[value][i])) return false;
                    } else {
                        my_map.put(graph[value][i], !color);
                        my_queue.add(graph[value][i]);
                        appeared[graph[value][i]] = true;
                    }
                }
            }

        }
        return true;
    }


    /**
     * Cyc DFS 递归方法，快乐很多
     * */
    public boolean isBipartite2(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {  // 处理图不是连通的情况
            if (colors[i] == -1 && !isBipartite(i, 0, colors, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean isBipartite(int curNode, int curColor, int[] colors, int[][] graph) {
        if (colors[curNode] != -1) {
            return colors[curNode] == curColor;
        }
        colors[curNode] = curColor;
        for (int nextNode : graph[curNode]) {
            if (!isBipartite(nextNode, 1 - curColor, colors, graph)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode_785_IsGraphBipartite solu = new Leetcode_785_IsGraphBipartite();
        solu.isBipartite(new int[][]{{1},{0,3},{3},{1,2}});
    }
}
