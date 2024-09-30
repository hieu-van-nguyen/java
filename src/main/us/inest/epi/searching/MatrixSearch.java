package us.inest.epi.searching;

public class MatrixSearch {
    public boolean findElement(int[][] matrix, int e) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) { // not out of bounds
            if (matrix[row][col] == e) {
                return true; // found
            } else if (matrix[row][col] > e) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
