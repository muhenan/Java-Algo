package CyC2018.Leetcode.DataStructure.Graph;

import java.util.*;

/**
 * 拓扑排序
 *
 * 常用于在具有先序关系的任务规划中。
 * */
public class Leetcode_207_CourseSchedule {
    /**
     * 这道题实际可以变成，有向图是否存在环
     *
     * 如果图 GG 中存在环（即图 GG 不是「有向无环图」），那么图 GG 不存在拓扑排序。
     * */

    /**
     * 拓扑排序
     * https://leetcode.cn/problems/course-schedule/solution/ke-cheng-biao-by-leetcode-solution/
     *
     * 拓扑排序，通过放到 stack 里来得到拓扑排序
     * 如果节点完全没访问过，是白色
     * 访问了，但不完全，即没有放到 stack 里，是黄色
     * 放到栈里了，是绿色
     *
     * 优化
     *
     * 由于我们只需要判断是否存在一种拓扑排序，而栈的作用仅仅是存放最终的拓扑排序结果，因此我们可以只记录每个节点的状态，而省去对应的栈。
     * */
    List<List<Integer>> edges;
    int[] visited; // 记录各个节点的状态
    boolean valid = true; // 全局变量，表示最终结果

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /** Build Graph */
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        /** 走 DFS，搞拓扑排序 */
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) { // 如果是 0，即如果节点是完全没访问过的情况，才走 DFS
        if (!valid) return;
        visited[u] = 1; // 既然是 0 的，那么进来了先变成 1
        for (int v: edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
            } else if (visited[v] == 1) { // 这就情况就是 dfs 又走回去了，这就出现环了，要终止了
                valid = false;
                return;
            }
        }
        visited[u] = 2; // 结束了变成 2
    }
    /**
     * 先来个自解方法，变成一个有向图，走 BFS
//     * */
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        /** Build Graph */
//        int lines = prerequisites.length;
//        HashMap<Integer, List<Integer>> my_graph = new HashMap<>();
//        for (int i = 0; i < lines; i++) {
//            int start = prerequisites[i][0];
//            if (!my_graph.containsKey(start)) {
//                List<Integer> arr = new LinkedList<>();
//                arr.add(prerequisites[i][1]);
//                my_graph.put(start, arr);
//            } else {
//                my_graph.get(start).add(prerequisites[i][1]);
//            }
//        }
//        /** BFS */
//        boolean[] appeard = new boolean[numCourses];
//        for (int i = 0; i < numCourses; i++) {
//            if (!my_graph.containsKey(i)) continue;
//            Queue<Integer> my_queue = new LinkedList<>();
//            my_queue.add(i);
//            while (!my_queue.isEmpty()) {
//                int value = my_queue.poll();
//                appeard[value] = true;
//                List<Integer> my_list = my_graph.getOrDefault(value, null);
//                if (my_list == null) {
//                    continue;
//                }
//                int length = my_list.size();
//                for (int j = 0; j < length; j++) {
//                    if (appeard[my_list.get(j)]) return false;
//                    else {
//                        my_queue.add(my_list.get(j));
//                    }
//
//                }
//            }
//        }
//        return true;
//    }


    public static void main(String[] args) {
        Leetcode_207_CourseSchedule solu = new Leetcode_207_CourseSchedule();
        solu.canFinish(2, new int[][]{{1,0}});
    }
}
