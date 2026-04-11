package us.inest.lc150.matrix;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int size = m * n;
        int top = 0, left = 0, bottom = m - 1, right = n - 1;
        while (result.size() < size) {
            for (int i = left; i <= right && result.size() < size; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom && result.size() < size; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >=  left && result.size() < size; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >=  top && result.size() < size; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}
