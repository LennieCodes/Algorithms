package arraysAndStrings;

import java.util.Arrays;

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

}
