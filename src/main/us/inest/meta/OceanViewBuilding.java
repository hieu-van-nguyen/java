package us.inest.meta;

import java.util.Stack;

public class OceanViewBuilding {
    // https://leetcode.com/problems/buildings-with-an-ocean-view/
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxHeight = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (maxHeight < heights[i]) {
                stack.add(i);
                maxHeight = heights[i];
            }
        }
        int[] answer = new int[stack.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}
