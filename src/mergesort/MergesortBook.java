package mergesort;

public class MergesortBook {
	private int[] numbers;
    private int[] helper;

    private int number;
    
    public int[] sort(int[] values) {
        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        mergesort(0, number - 1);
        return numbers;
    }
	    
    private void mergesort(int low, int high) {
    	System.out.println("mergesort called with low: " + low + " high: " + high );
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            System.out.println("middle is:" + middle);
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }
	    
    private void merge(int low, int middle, int high) {
    	System.out.println("merge function called with low: " + low
    			+ " Middle: " + middle +  " high: " + high);
	        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i]; // if 1st array less than 2nd array, store 1st value.
                i++;
            } else {
                numbers[k] = helper[j]; // otherwise, store 2nd value. 
                j++; 
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            System.out.println(numbers[k] + ",");
            k++;
            i++;
        }
        
        

    }
}
