package us.inest.lc150.backtracking;

import java.util.*;

/*
 * https://leetcode.com/problems/n-queens/description/
 */
public class NQueens {
    private int size;
    List<List<String>> solutions;
    public List<List<String>> solveNQueens(int n) {
        size = n;
        solutions = new ArrayList<>();
        char[][] emptyBoard = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                emptyBoard[i][j] = '.';
            }
        }
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), emptyBoard);
        return solutions;
    }

    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<>();
        for (char[] row : state) {
            board.add(new String(row));
        }
        return board;
    }

    private void backtrack(
            int row,
            Set<Integer> diagonals,
            Set<Integer> antiDiagonals,
            Set<Integer> cols,
            char[][] state
    )   {

        if (row == size) {
            solutions.add(createBoard(state));
            return;
        }
        for (int col = 0; col < size; col++) {
            int diagonal = col - row;
            int antiDiagonal = col + row;
            if (diagonals.contains(diagonal) || antiDiagonals.contains(antiDiagonal) || cols.contains(col)) continue;
            diagonals.add(diagonal);
            antiDiagonals.add(antiDiagonal);
            cols.add(col);
            state[row][col] = 'Q';
            backtrack(row + 1, diagonals, antiDiagonals, cols, state);
            diagonals.remove(diagonal);
            antiDiagonals.remove(antiDiagonal);
            cols.remove(col);
            state[row][col] = '.';
        }
    }
}
