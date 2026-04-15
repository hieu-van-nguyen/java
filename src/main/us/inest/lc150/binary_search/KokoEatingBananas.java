package us.inest.lc150.binary_search;

/*
 * https://leetcode.com/problems/koko-eating-bananas/description/
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int totalHours = 0;
            for (int pile : piles) {
                totalHours += Math.ceil((pile * 1.0) / mid);
            }
            if (totalHours <= h) {
                right = mid;
            } else {
                left  = mid + 1;
            }
        }
        return right;
    }
}
