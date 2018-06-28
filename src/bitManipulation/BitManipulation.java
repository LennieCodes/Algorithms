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
    	ArrayList<Integer> sequenceList = CreateSequences(num);
    	return FindLongestSequence(sequenceList);
    }
    
    private static ArrayList<Integer> CreateSequences(int num) {
    	/*
    	 * We need for the sequence to always start with a 0. Look for 0. If first value is not equal to 0,
    	 * then add counter to arraylist (will be 0). Then flip it to a 1. Now it's going to count 1s.
    	 * This code *should* get you the sequence you're looking for.   
    	 */
    	
    	ArrayList<Integer> sequenceList = new ArrayList<Integer>();
    	int counter = 0;
    	int lookingFor = 0;
    	
    	for (int i = 0; i < Integer.BYTES * 8; i++) {
    		if ((num & 1) != lookingFor) {
    			System.out.println("Adding: " + counter + " to Sequence List");
    			sequenceList.add(counter);
    			lookingFor = num & 1;
    			counter = 1;
    		}
    		else {
    			counter++;
    		}
    		
    		num = num >>> 1;
    	}
    	
    	return sequenceList;
    	
    }
    
    private static int FindLongestSequence(ArrayList<Integer> sequenceList) {
    	// 11011101111 -> [0, 4, 1, 3, 1, 2]
    	// 100 -> [2, 1] -> max = 2. 
    	int max = 0;
    	int candidate = 0;
    	if ( sequenceList.get(0) > 0) {
    		max = 1 + sequenceList.get(1);
    	}
    	for (int i = 1; i < sequenceList.size(); i++) {
    		// looking at an index that represents 0
    		if (i % 2 == 0) { 
    			if (sequenceList.get(i) == 1 && i + 1 < sequenceList.size()) {
    				candidate = sequenceList.get(i - 1) + 1 + sequenceList.get(i + 1);
    				if (candidate > max) {
    					max = candidate;
    				}
    			} 
    			else if (i + 1 < sequenceList.size()) {
    				candidate = Math.max(sequenceList.indexOf(i - 1) + 1, sequenceList.indexOf(i + 1) + 1);
    				if (candidate > max) {
    					max = candidate;
    				}
    			}
    			else {
    				candidate = sequenceList.indexOf(i - 1) + 1;
    				if (candidate > max) {
    					max = candidate;
    				}
    			}
    		}
    	}
    	return max;
    }
    
    

}