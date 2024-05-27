package us.inest.epi.utils;

public class ArrayUtil {
    public static void display(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("[]");
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
