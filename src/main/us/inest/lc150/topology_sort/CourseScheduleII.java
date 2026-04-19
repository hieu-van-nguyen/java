package us.inest.lc150.topology_sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/course-schedule-ii/
 */
public class CourseScheduleII {
    private static int UNVISITED = 1;
    private static int VISITING = 2;
    private static int VISITED = 3;

    private boolean isPossible;
    private int[] visited;
    private Map<Integer, List<Integer>> adjList;
    private List<Integer> topoLogicalOrder;

    private void init(int numCourses) {
        this.isPossible = true;
        this.visited = new int[numCourses];
        this.adjList = new HashMap<>();
        this.topoLogicalOrder = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            this.visited[i] = UNVISITED;
        }
    }

    private void dfs(int node) {
        if (!this.isPossible) {
            return;
        }
        this.visited[node] = VISITING;
        for (int neighbor : this.adjList.get(node)) {
            if (this.visited[neighbor] == UNVISITED) {
                dfs(neighbor);
            } else if (this.visited[neighbor] == VISITING) {
                this.isPossible = false;
                return;
            }
        }
        this.visited[node] =  VISITED;
        this.topoLogicalOrder.add(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        init(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int dest = prerequisite[0];
            int src = prerequisite[1];
            adjList.get(src).add(dest);
        }
        for (int i = 0; i < numCourses; i++) {
            if (this.visited[i] == UNVISITED) {
                dfs(i);
            }
        }
        int[] order;
        if (this.isPossible) {
            order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = this.topoLogicalOrder.get(numCourses - 1 - i);
            }
        } else {
            order = new int[0];
        }
        return order;
    }
}
