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
    
    // 5.2
    public static String BinaryToString(double num) {
    	StringBuilder result = new StringBuilder(".");
    	do {
    		num = num * 2;
    		System.out.println(num);
    		if (num > 0 && num < 1) {
    			result.append("0");
    		} else {
    			result.append("1");
    			num = num - 1;
    		}
    	} while (num != 0 && result.length() <= 32);
    	
    	return result.length() <= 32 ? result.toString() : "Error";
    }

}