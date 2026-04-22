package us.inest.lc150.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/walls-and-gates/
 */
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        int EMPTY = Integer.MAX_VALUE;
        int m = rooms.length;
        int n = rooms[0].length;
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            for (int[] d : directions) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if ( r < 0 || r >= m || c < 0 || c >= n || rooms[r][c] != EMPTY) continue;;
                rooms[r][c] = 1 + rooms[cell[0]][cell[1]];
                queue.add(new int[]{r, c});
            }
        }
    }
}
