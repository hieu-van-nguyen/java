package us.inest.epi.graph;

import us.inest.utils.Graph;
import us.inest.utils.GraphNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphSearch {
    boolean search(Graph g, GraphNode start, GraphNode end) {
        Set<GraphNode> visited = new HashSet<GraphNode>();
        if (start == end) {
            return true;
        }
        Queue<GraphNode> q = new LinkedList<GraphNode>();
        q.add(start);
        // BFS
        while (!q.isEmpty()) {
            GraphNode u = q.remove();
            if (u != null) {
                if (!visited.contains(u)) {
                    visited.add(u);
                    for (GraphNode v : u.children) {
                        if (!visited.contains(v)) {
                            if (v == end) {
                                return true;
                            } else {
                                visited.add(v);
                                q.add(v);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
