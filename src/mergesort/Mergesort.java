package mergesort;

import java.util.Arrays;

public class Mergesort {
	private int[] numbers;
	private int[] helper;
	
	public int[] sort(int[] values) {
		this.numbers = values;
		// suppose values = {10, 5, 2, 1} Task is to implement mergesort.
		// what do i do? first step would be recursively split them down right all the way, right?
		int length = values.length;
		this.helper = new int[length];
		System.out.println("mergesort init call:" + 0 + "," + (length-1));
		mergesort(0, length-1);
		return this.numbers;
	}
	
	private void mergesort(int low, int high) {
		if (low < high) {
			// int middle = (int) Math.floor((high - low) / 2); it should get floored.
			// TODO: find out why line 17 works but floor doesn't. 
			int middle =  low + ((high - low) / 2); 

			System.out.println("mergesort 1 call:" + low + "," + middle);
			mergesort(low, middle); // second call returns 0,0. which means if it returns back
			// you're on the frame before they become singular, so you have access to 0 and 1. 
			// low and middle. 
			// mergesort compares 10 to 2, then 10 to 1 to build the new array.
			// right now, with low and middle, you have access to the 0 and 1 element. 
			// you need access to 2 and 1 as well.
			System.out.println("mergesort 2 call:" + low + "," + middle);
			mergesort(middle + 1, high);
			// mergeSort(middle + 1, high); // +1 because you want to target the 3rd element as low.
			// 2, 3 3 - 2 = 1 / 2 = 0 so middle is 0. 
			
			merge(low, middle, high); 
			
		}
	}
	
	private void merge(int low, int middle, int high) {
		System.out.println("merge call with low: " + low + " middle: " + middle + " high:" + high);
		// this should be 0, 0, 1. 
		// copy into helper array because numbers will contain sorted result. 
		// this is wrong, helpers only needs frame that you're executing sort on.
		for (int i = low; i <= high; i++) {
			this.helper[i] = this.numbers[i];
		}
		
		// k is used to keep track of position in numbers array.
		// i and j are used in helper array to compare elements.
		
		int i = low, j = middle + 1, k = low;
		// inputarray = {10, 5, 2, 1}
		// it's <= because you want to include middle and high in the comparison. 
		while (i <= middle && j <= high) {
			if (this.helper[i] <= this.helper[j]) {
				this.numbers[k] = this.helper[i];
				i++;
			}
			else {
				this.numbers[k] = this.helper[j];
				j++;
			}
			k++; // moves index to next position in returned array.
		}		
		// copy items that weren't sorted back into array. 
		
		while (i <= middle) {
			System.out.println("value of i: " + i);
            numbers[k] = helper[i];
            k++;
            i++;
        }
		
		System.out.println("end of merge call: " + Arrays.toString(this.numbers));
		// need to have an array that you will return, the final products.
		// you need to compare low and middle, if you need to swap, move them into final array
		// that you will return. 
	}
	
	
	

}
