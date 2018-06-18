package bitManipulation;

public class BitManipulation {

    // 5.1
	// this method needs to be revised entirely. 
    public static int Insertion(int n, int m, int i, int j) {
    	int mLength = Integer.valueOf(m).toString().getBytes().length;
    	System.out.println(mLength);
    	boolean bitIs1 = false;
        for (int k = mLength - 1; i <= j; i++) {
            bitIs1 = BitHelper.getBit(m, k);
            System.out.println("bitIs1 value:" + bitIs1);
            n = BitHelper.updateBit(n, i, bitIs1);
            k--;
        }

        return n;
    }

}