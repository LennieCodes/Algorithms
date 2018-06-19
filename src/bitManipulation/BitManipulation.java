package bitManipulation;

import java.util.ArrayList;

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
    
    // 5.3
    public static int FlipBitToWin(int num) {
    	/* 
    	 * How do you tackle this problem? 
    	 * 
    	 * 
    	 * 
    	 */
    	ArrayList<Integer> sequenceList = CreateSequences(num);
    	return FindLongestSequence(sequenceList);
    }
    
    private static ArrayList<Integer> CreateSequences(int num) {
    	/*
    	 * The plan: Iterate through every bit, counting the bit changes. 
    	 */
    	// 11011101111
    	ArrayList<Integer> sequenceList = new ArrayList<Integer>();
    	int counter = 0;
    	int lookingFor = 0;
    	
    	for (int i = 0; i < Integer.BYTES * 8; i++) {
    		if ((num & 1) == lookingFor) {
    			sequenceList.add(counter);
    			lookingFor = num & 1;
    			counter = 0;
    		}
    		
    		counter++;
    		num = num >>> 1;
    	}
    	
    	return sequenceList;
    	
    }
    
    private static int FindLongestSequence(ArrayList<Integer> sequenceList) {
    	for (int i = 0; i < sequenceList.size(); i++) {
    		System.out.println((Integer) sequenceList.indexOf(i));
    	}
    	
    	throw new UnsupportedOperationException();
    }
    
    

}