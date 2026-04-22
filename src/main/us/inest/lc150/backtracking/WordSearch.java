package us.inest.lc150.backtracking;

/*
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {
    private int m;
    private int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(board, word, i, j, 0, new boolean[m][n])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, String word, int r, int c, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || board[r][c] != word.charAt(index)) {
            return false;
        }
        visited[r][c] = true;
        boolean found = check(board, word, r - 1, c, index + 1, visited)
                        || check(board, word, r + 1, c, index + 1, visited)
                        || check(board, word, r, c - 1, index + 1, visited)
                        || check(board, word, r, c + 1, index + 1, visited);
        visited[r][c] = false;
        return found;
    }
}
