package us.inest.epi.array;

import java.util.ArrayList;
import java.util.List;

import static us.inest.epi.utils.ListUtil.displayMatrix;

public class PascalTriangle {
    public static List<List<Integer>> pascalTriangle(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int currentNum = 0 < j && j < i ? result.get(i - 1).get(j - 1) + result.get(i - 1).get(j) : 1;
                currentRow.add(currentNum);
            }
            result.add(currentRow);
        }
        return  result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = pascalTriangle(6);
        displayMatrix(result);
        System.out.println("Done");
    }
}
