package CyC2018.Leetcode.DataStructure.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 不多说，纯纯拓扑排序了，纯纯
 * */
public class Leetcode_210_CourseScheduleII {
    /**
     * DFS 拓扑排序，直接顺利通过
     * */
    List<List<Integer>> graph;
    boolean valid = true;
    List<Integer> result;
    int[] colors;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int length = prerequisites.length;
        colors = new int[numCourses];
        result = new ArrayList<>();
        graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge:prerequisites) {
            graph.get(edge[0]).add(edge[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (colors[i] == 0)
                dfs(i);
        }
        if (!valid) return new int[]{};
        else return result.stream().mapToInt(i->i).toArray();
    }
    private void dfs(int i) {
        if (!valid) return;
        colors[i] = 1;
        for (Integer ele:graph.get(i)) {
            if (colors[ele] == 0) {
                dfs(ele);
            } else if (colors[ele] == 1) {
                valid = false;
                return;
            }
        }
        colors[i] = 2;
        result.add(i);
    }
}
