package us.inest.lc150.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/course-schedule/description/
 */
public class CourseSchedule {
    private static int UNVISITED = 0;
    private static int VISITING = 1;
    private static int VISITED = 2;
    private int[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
            visited[i] = UNVISITED;
        }
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == UNVISITED && hasCycle(i, adj)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int node, Map<Integer, List<Integer>> adj) {
        visited[node] = VISITING;
        for (int nei : adj.get(node)) {
            if (visited[nei] == VISITING) return true;
            if (visited[nei] == UNVISITED && hasCycle(nei, adj)) return true;
        }
        visited[node] = VISITED;
        return false;
    }
}
