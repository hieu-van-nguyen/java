package us.inest.epi.searching;

public class FindDuplicates {
    public Integer findDuplicates(int[] arr) {
        // create a bit vectors with 32000 bits, where each bit represents an integer
        BitSet bs = new BitSet(32000);

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int pos = num - 1; // number is store at position (number - 1)
            if (bs.get(pos)) {
                return num;
            } else {
                bs.set(pos);
            }
        }

        return null; // no duplicate
    }

    class BitSet {
        int[] bitset;

        public BitSet(int size) {
            bitset = new int[(size >> 5) + 1];
        }

        public boolean get(int pos) {
            int wordNumber = pos >> 5;
            int bitNumber = pos % 32;
            return (bitset[wordNumber] & (1 << bitNumber)) != 0;
        }

        public void set(int pos) {
            int wordNumber = pos >> 5;
            int bitNumber = pos % 32;
            bitset[wordNumber] |= 1 << bitNumber;
        }
    }
}
