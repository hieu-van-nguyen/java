package us.inest.lc150.bit_manipulation;

/*
 * https://leetcode.com/problems/reverse-bits/
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        int power = 31;
        while (n != 0) {
            result += (n & 1) << power;
            power--;
            n >>>= 1;
        }
        return result;
    }
}
