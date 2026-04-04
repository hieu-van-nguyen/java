package us.inest.lc150.two_pointers;

/*
 * https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, ans = 0;
        while (i < j) {
            int width = j - i;
            int area = width * Math.min(height[i], height[j]);
            ans = Math.max(area, ans);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return  ans;
    }
}
