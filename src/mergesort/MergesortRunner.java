package mergesort;

import java.util.Arrays;

public class MergesortRunner {

	public static void main(String[] args) {
		
		int[] numbers = {10, 5, 2, 1};
		Mergesort runner = new Mergesort();
		
		int[] result = runner.sort(numbers);
		
		System.out.println(Arrays.toString(result));

	}

}
