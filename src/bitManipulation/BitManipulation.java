package bitManipulation;

public class BitManipulation {

    // 5.1
    public static int Insertion(int n, int m, int i, int j) {
    	int allOnes = ~0; // sequence of 1s.
    	int left = allOnes << (j + 1);	
    	int right = ((1 << i) - 1);
    	int mask = left | right;
    	
    	int n_cleared = n & mask;
    	int m_shifted = m << i;
    	
    	return n_cleared | m_shifted;
    }
    
    // 5.2
    public static String BinaryToString(double num) {
    	StringBuilder result = new StringBuilder(".");
    	do {
    		num = num * 2;
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