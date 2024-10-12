package us.inest.epi.array;

public class ProductCalculation {
    public static int[] products(int[] arr) {
        int[] result = new int[arr.length];
        int[] prefixProducts = new int[arr.length];
        int[] suffixProducts = new int[arr.length];

        int prefixProduct = 1;
        for (int i = 0; i < arr.length; i++) {
            prefixProduct *= arr[i];
            prefixProducts[i] = prefixProduct; //prefixProduct[i] = a0 * a1 * ... * ai
        }

        int[] reverse_arr = reverse(arr);
        int suffixProduct = 1;
        for (int i = 0; i < reverse_arr.length; i++) {
            suffixProduct *= reverse_arr[i];
            suffixProducts[i] = suffixProduct; //suffixProduct[i] = ai * ... * an
        }
        suffixProducts = reverse(suffixProducts);

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                result[i] = suffixProducts[i + 1];
            } else if (i == arr.length - 1) {
                result[i] = prefixProducts[i - 1];
            } else {
                result[i] = prefixProducts[i - 1] * suffixProducts[i + 1];
            }
        }
        return result;
    }

    private static int[] reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }
}
