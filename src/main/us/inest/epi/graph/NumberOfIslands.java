package us.inest.epi.graph;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    DFS(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void DFS(char[][] grid, int i, int j) {
        // check if it is out of bound or water
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0'; // visited
        DFS(grid, i - 1, j); // up
        DFS(grid, i + 1, j); // down
        DFS(grid, i, j - 1); // left
        DFS(grid, i, j + 1); // right
    }
}
