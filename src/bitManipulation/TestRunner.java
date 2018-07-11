package bitManipulation;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestRunner {
    @Test
    public void InsertionTest() {
        int n = 1024;
        int m = 19; 
        int i = 2;
        int j = 6;

        int result = BitManipulation.Insertion(n, m, i, j);

        if (result != 1100) {
            fail("Bit Insertion did not produce expected value of 1100, or 10001001100");
        }
    }
    
    @Test 
    public void BinaryToStringTest() {
    	double val = .375;
    	String result = BitManipulation.BinaryToString(val);
    	
    	if (!result.equals(".011")) {
    		fail("Expected: .011 but method returned:" + result);
    	}
    }
    
    @Test
    public void FlipBitToWinTest() {
    	int num = 1775; // 11011101111
    	int result = BitManipulation.FlipBitToWin(num);
    	
    	if (result != 8) {
    		fail("The bit representation of 1775 can have a sequence of 8 1s, but method returned:" + result);
    	}
    }
    
    @Test
    public void DebuggerTest() {
    	int num = 14;
    	boolean result = BitManipulation.Debugger(num);
    	
    	if (result == true) {
    		fail("You failed to understand what the code does");
    	}
    }
    
    @Test
    public void ConversionTest() {
    	int a = 29;
    	int b = 15;
    	
    	int result = BitManipulation.Conversion(a, b);
    	
    	if (result != 2) {
    		fail("Expected number of bits necessary for conversion to equal 2, but conversion returned:" + result);
    	}
    }
    
    @Test
    public void PairwiseSwapTest() {
    	int num = 115;
    	int bitSwapped = 179;
    	
    	int result = BitManipulation.PairwiseSwap(num);
    	
    	if (result != bitSwapped) {
    		fail("Expected result to equal:" + bitSwapped + " but method returned:" + result);
    	}
    }
}