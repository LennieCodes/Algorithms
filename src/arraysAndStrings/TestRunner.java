package arraysAndStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRunner {
	
	@Test
	public void isUniqueTest() {
		String value = "Thisisatest";
		
		if(ArraysAndStrings.isUnique(value) == true) {
			fail("String: " + value + " is not unique, but method does not detect it");
		}
		
		assertTrue(true);
	}
	
	@Test
	public void isPermutationTest() {
		String one = "top";
		String two = "pot";
		
		if(ArraysAndStrings.isPermutation(one, two) == false) {
			fail("String: " + one + " String: " + two 
					+ "are permutations but method does not detect it");
		};
		
		assertTrue(true);
	}
	
}
