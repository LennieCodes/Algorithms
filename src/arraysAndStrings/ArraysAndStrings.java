package arraysAndStrings;

import java.util.*;

public class ArraysAndStrings {
	
	
	public static boolean isUnique(String value) {
		if (value.length() == 0 || value.length() == 1) {
			return true;
		}
		
		char[] valueArray = value.toCharArray();
		// TODO find out why valueArray.length doesnt work
		boolean[] containerArray = new boolean[128]; 
		
		for(int i = 0; i < valueArray.length; i++) {
			if (i == 0) {
				containerArray[valueArray[i]] = true;
			}
			if (containerArray[valueArray[i]] == true) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public static boolean isPermutation(String one, String two) {
		if (one.length() != two.length()){
			return false;
		}
		char[] s1 = one.toCharArray(); 
		char[] s2 = two.toCharArray();
		Arrays.sort(s1);
		Arrays.sort(s2);
		if (Arrays.equals(s1, s2)) {
			return true;
		}
		return false;
	}
	
	public static String urlify(String input, int trueLength) {
		char[] output = input.toCharArray();
		int spaceCount = 0;
		int spacesSeen = 0;
		int trueEnd = trueLength - 1;
		for (int i = 0; i < trueLength; i++) {
			if (output[i] == ' ') {
				spaceCount++;
			}
		}
		for (int i = trueLength - 1; i >= 0; i--) {
			if (output[i] == ' ') {
				for (int k = trueEnd; k > i; k--) {
					output[k+2] = output[k];
				}
				trueEnd += 2;
				output[i] = '%';
				output[i + 1] = '2';
				output[i + 2] = '0';
				spacesSeen++;
				if (spacesSeen == spaceCount) {
					String outputStr = new String(output);
					return outputStr;
				}
			}
		}
		
		return "An Error Occurred";
	}
	
	public static boolean isPermutationOfPalindrome(String s) {
		char[] arr = s.toLowerCase().toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		boolean hasSeenOdd = false;
		for (int i = 0; i < arr.length; i++) {
			if (map.get(arr[i]) == null) {
				map.put(arr[i], 1);
				continue;
			}
			int value = map.get(arr[i]) + 1;
			map.put(arr[i], value);
		}
		
		for (int val : map.values()) {
			if (val % 2 == 1 ) {
				if (hasSeenOdd == true) {
					return false;
				}
				hasSeenOdd = true;
			}
		}
		return true;
	}

}
