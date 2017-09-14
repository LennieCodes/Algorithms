package stacksAndQueues;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

// 3.5 test
public class SortStackTestRunner {
	
	@Test
	public void SortTest() {
		int limit = 100;
		int[] initArr = Populate(limit);
		
		SortStack<Integer> stack = new SortStack<Integer>();
		
		for (int i = 0; i < initArr.length; i++) {
			stack.Push(initArr[i]);
		}
		
		stack = stack.Sort(stack);
		Arrays.sort(initArr);
		
		for (int i = 0; i < initArr.length; i++) {
			int value = (int) stack.Pop();
			
			if (value != initArr[i]) {
				fail("Sort Failure. Expected: " + initArr[i] +" But retrieved " + value);
			}
		}
	}
	
	private int[] Populate(int limit) {
		int[] arr = new int[limit];
		
		for (int i = 0; i < limit; i++) {
			arr[i] = (int) (Math.random() * 1000 + 1);
		}
		
		return arr;
	}
}
