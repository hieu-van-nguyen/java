package us.inest.epi.math;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generatePascalTriangle(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> currentRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int value = (j == 0 || j == i) ? 1
                        : pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j);
                currentRow.add(value);
            }
            pascalTriangle.add(currentRow);
        }
        return pascalTriangle;
    }
}
