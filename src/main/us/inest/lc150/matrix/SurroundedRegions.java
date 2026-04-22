package us.inest.lc150.matrix;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        List<int[]> border = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            border.add(new int[] {i, 0});
            border.add(new int[] {i, n - 1});
        }
        for (int i = 0; i < n; i++) {
            border.add(new int[] {0, i});
            border.add(new int[] {m - 1, i});
        }
        for (int[] b : border) {
            dfs(board, m, n, b[0], b[1]);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int m, int n, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'E';
        dfs(board, m, n, r - 1, c);
        dfs(board, m, n, r + 1, c);
        dfs(board, m, n, r, c - 1);
        dfs(board, m, n, r, c + 1);
    }
}
