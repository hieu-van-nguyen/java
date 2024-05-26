package us.inest.epi.array;

public class IncreasingTripletSequence {
    public static boolean increasingTriplet(int[] nums) {
        int first_num = Integer.MAX_VALUE;
        int second_num = Integer.MAX_VALUE;
        for (int num : nums) {
            if (first_num >= num) {
                first_num = num;
            } else if (second_num >= num) {
                second_num = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[] {2,1,5,0,4,6})); // true
        System.out.println(increasingTriplet(new int[] {5,4,3,2,1})); // false
        System.out.println(increasingTriplet(new int[] {1,2,3,4,5})); // true
    }
}
