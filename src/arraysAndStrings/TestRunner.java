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
		}
		
		assertTrue(true);
	}
	
	@Test
	public void urlifyTest() {
		String input = "Mr John Smith    ";
		int trueLength = 13;
		String output = ArraysAndStrings.urlify(input, trueLength);
		
		if(!output.equals("Mr%20John%20Smith")) {
			fail("String " + input + " is not urlified." + "Output contains: " + output);
		}
		
		assertTrue(true);
	}
	
	@Test
	public void isPermutationOfPalindromesTest(){
		String s = "Tactcoa";
		if (ArraysAndStrings.isPermutationOfPalindrome(s) == false) {
			fail("String: " + s + " is a permutation of a palindrome (taco cat), but "
					+ "method does not detect it.");
		}
		
		assertTrue(true);
		
	}
	
}
