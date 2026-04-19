package us.inest.lc150.dfs;

/*
 * https://leetcode.com/problems/flood-fill/description/
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currentColor = image[sr][sc];
        if (currentColor != color) {
            dfs(image, sr, sc, currentColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int currentColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
            return;
        }
        if (image[r][c] == currentColor) {
            image[r][c] = newColor;
            dfs(image, r - 1, c, currentColor, newColor);
            dfs(image, r + 1, c, currentColor, newColor);
            dfs(image, r, c - 1, currentColor, newColor);
            dfs(image, r, c + 1, currentColor, newColor);
        }
    }
}
