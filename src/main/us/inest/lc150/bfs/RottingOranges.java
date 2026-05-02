package us.inest.lc150.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/rotting-oranges/description/
 */
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int numOfFreshOrange = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    numOfFreshOrange++;
                }
            }
        }
        q.add(new int[] {-1, -1});
        int minutes = -1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] curr = q.remove();
            if (curr[0] == -1) {
                minutes++;
                if (!q.isEmpty()) {
                    q.add(new int[] {-1, -1});
                }
            } else {
                for (int[] d : directions) {
                    int newRow = curr[0] + d[0];
                    int newCol = curr[1] + d[1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        numOfFreshOrange--;
                        q.add(new int[] {newRow, newCol});
                    }
                }
            }
        }
        return numOfFreshOrange == 0 ? minutes : -1;
    }
}
