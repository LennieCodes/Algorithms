package bitManipulation;

public class BitManipulation {

    // 5.1
    public static int Insertion(int n, int m, int i, int j) {
        boolean bitIs1 = false;
        for (int k = 0; i <= j; i++) {
            bitIs1 = BitHelper.getBit(m, k);
            n = BitHelper.updateBit(n, i, bitIs1);
            k++;
        }

        return n;
    }

}