package us.inest.lc150.graph;

/*
 * https://leetcode.com/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {
    private int m, n;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, dfs(grid, visited, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(grid, visited, i - 1, j) +
                dfs(grid, visited, i + 1, j) +
                dfs(grid, visited, i, j - 1) +
                dfs(grid, visited, i, j + 1);
    }
}
