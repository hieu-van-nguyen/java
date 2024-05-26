package us.inest.epi.utils;

import java.util.List;

public class ListUtil {
    public static void displayList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void displayMatrix(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> row = matrix.get(i);
            displayList(row);
        }
    }
}
