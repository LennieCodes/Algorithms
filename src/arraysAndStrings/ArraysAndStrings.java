package arraysAndStrings;

import java.util.*;

public class ArraysAndStrings {
	
	// 1.1
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
	
	// 1.2
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
	
	// 1.3
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
	
	// 1.4
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
	
	// 1.5
	public static boolean isOneEditAway(String s1, String s2) throws Exception {
		// immediately return false if length difference between strings is greater than 1.
		if (Math.abs(s1.length() - s2.length()) > 1){
			return false;
		}
		boolean editMade = false;
		// only operation is character replacement.
		if (s1.length() == s2.length()) {
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) == s2.charAt(i)) {
					continue;
				}
				if (editMade == true) {
					return false;
				}
				editMade = true;
			}
			return true;
		}
		// adding a character 
		else if (s1.length() < s2.length()) {
			int j = 0;
			for (int i = 0; i < s2.length(); i++) {
				if (s1.charAt(j) == s2.charAt(i)) {
					j++;
					continue;
				}
				if (editMade == true) {
					return false;
				}
				editMade = true;
			}
			return true;
		}
		// removing a character
		else if (s1.length() > s2.length()) {
			int j = 0;
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					j++;
					continue;
				}
				if (editMade == true) {
					return false;
				}
				editMade = true;
			}
			return true;
		}
		
		throw new Exception("Something went wrong. This shouldn't happen.");
		
	}

	// 1.6 
	public static String compress(String s1) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		StringBuilder result = new StringBuilder();
		Integer temp; 
		
		for (int i = 0; i < s1.length(); i++) {
			if ((i + 1) == s1.length() || s1.charAt(i) != s1.charAt(i + 1)) {
				temp = map.get(s1.charAt(i));
				result.append(s1.charAt(i));
				
				if (temp == null) {
					result.append(1);
				}
				else {
					result.append(map.get(s1.charAt(i)) + 1); 
				}
				
				map = new HashMap<Character, Integer>();
				continue;
			}
			
			if (map.get(s1.charAt(i)) == null) {
				map.put(s1.charAt(i), 1);
				continue;
			}
			
			temp = map.get(s1.charAt(i));
			map.put(s1.charAt(i), temp + 1);
			
		}
		
		return s1.length() <= result.toString().length() ? s1 : result.toString();		
		
	}
	
	// 1.7
	public static char[][] rotateMatrix(char[][] matrix) throws Exception {
		if (matrix.length == 0 || matrix[0].length != matrix.length) {
			throw new Exception("Matrix is either length 0, or not NxN matrix");
		}
		
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				
				char top = matrix[first][i];
				matrix[first][i] = matrix[last - offset][first]; // left -> top
				matrix[last - offset][first] = matrix[last][last - offset]; // bottom -> left
				matrix[last][last - offset] = matrix[i][last]; // right -> bottom
				
				matrix[i][last] = top; // top -> right
				
			}
		}
		
		return matrix;
	}
	
	// 1.8
	public static int[][] zeroMatrix(int[][] matrix) throws Exception {
		if (matrix.length == 0 || matrix.length == matrix[0].length) {
			throw new Exception("Matrix is either length 0, or not a MxN matrix");
		}
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					map.put(i, j); 
				}
			}
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer row = entry.getKey();
			Integer col = entry.getValue();
			
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][col] = 0;
			}
			
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[row][j] = 0;
			}	
		}
				
		return matrix;
	}
	
	// 1.9
	public static boolean isRotation(String s2, String s1) {
		if (s2.length() != s1.length()) {
			return false;
		}
		
		StringBuilder sb = new StringBuilder();
		int j = s2.length() - 1;
		
		for (int i = j; i >= 0; i--) {
			if (s2.charAt(i) == s1.charAt(j)) {
				j--;
				continue;
			}
			if (j != (s2.length() - 1)) {
				j++;
			}
		}
		
		for (int i = 0; i <= j; i++) {
			sb.append(s1.charAt(i));
		}
		
		return s2.contains(sb.toString());
	}
	
}
