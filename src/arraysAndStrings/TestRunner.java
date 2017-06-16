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
	
	@Test
	public void isOneEditAwayTest() throws Exception {
		String t1 = "paleee", t2 = "pale", t3 = "bale", t4 = "ple", t5 = "bake";
		
		if (ArraysAndStrings.isOneEditAway(t1, t2) == true) {
			fail(t1 + " and" + t2 + " are not 1 edit away, but method does not detect it");
		}
		
		if (ArraysAndStrings.isOneEditAway(t2, t3) == false) {
			fail(t2 + " and" + t3 + " are 1 edit away, but method does not detect it");
		}
		
		if (ArraysAndStrings.isOneEditAway(t2, t4) == false) {
			fail(t2 + " and" + t4 + " are 1 edit away, but method does not detect it");
		}
		
		if (ArraysAndStrings.isOneEditAway(t4, t2) == false) {
			fail(t4 + " and" + t2 + " are 1 edit away, but method does not detect it");
		}
		
		if (ArraysAndStrings.isOneEditAway(t2, t5) == true) {
			fail(t2 + " and" + t5 + " are not 1 edit away, but method does not detect it");
		}
		
		assertTrue(true);
		
	}
	
	@Test
	public void compressionTest() {
		String s1 = "aabcccccaaa", s2 = "a2b1c5a3", s3 = "aabbcc", s4 = "AAbcccCCaaa", s5 = "A2b1c3C2a3";
		String result = ArraysAndStrings.compress(s1);

		if (!result.equals(s2)) {
			fail(s2 + " is not the result of compress call on: " + s1);
		}
		
		result = ArraysAndStrings.compress(s3);
		if (!(result.equals(s3))) {
			fail("Expected original string because lengths are same, but compress call returned: " + result);
		}
		
		if (!(ArraysAndStrings.compress(s4).equals(s5))) {
			fail(s5 + " is not the result of compress call on " + s4);
		}
		
	}
	
	@Test
	public void rotateMatrixTest() {
		
		
		// ArraysAndStrings.rotateMatrix();
	}
	
	@Test
	public void isRotationTest() {
		String s2 = "waterbottle";
		String s1 = "erbottlewat";
		
		if (ArraysAndStrings.isRotation(s2, s1) == false) {
			fail("String: "+ s2 + " is a rotation of String: " + s1 + " but method isRotation did not detect it");
		}
		
		assertTrue(true);
	}
	
}
