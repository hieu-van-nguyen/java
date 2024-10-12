package us.inest.epi.array;

public class CountNegativeNumbers {
    public static int countNegativeNumbers(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int count = 0;
        int i = 0; // start from the first row
        int j = columns - 1; // start from the last column
        while (i < rows && j >= 0) {
            if (matrix[i][j] < 0) {
                count += j + 1;
                //go to the next row
                i++;
            } else {
                //go to previous column
                j--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {-3, -2, -1, 1},
                {-2, 2, 3, 4},
                {4, 5, 7, 8}
        };
        System.out.println(countNegativeNumbers(matrix)); // 4
    }
}
