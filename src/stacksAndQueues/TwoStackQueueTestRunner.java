package stacksAndQueues;

import static org.junit.Assert.*;
import org.junit.Test;

public class TwoStackQueueTestRunner {
	
	@Test
	public void AddAndRemoveTest() {
		// it should ... Add and Remove values from the Queue.
		int[] initArr = new int[] {6,7,1};
		int[] initArr2 = new int[] {8,9,5};
		TwoStackQueue<Integer> queue = new TwoStackQueue<Integer>();
		
		for (int i = 0; i < initArr.length; i++) {
			queue.Add(initArr[i]);
		}
		
		// singular remove - causes popStack to be populated. 
		int value = (int) queue.Remove();
		if (value != initArr[0]) {
			fail("Expected " + initArr[0] + "but retrieved:" + value);
		}
		
		// adding items to pushStack.
		for (int i = 0; i < initArr2.length; i++) {
			queue.Add(initArr2[i]);
		}
		
		// multi remove. - will remove 7, 1 from popStack.
		for (int i = 1; i < initArr.length; i++) {
			value = (int) queue.Remove();
			if (value != initArr[i]) {
				fail("Expected " + initArr[i] + "but retrieved:" + value);
			}
		}
		// multi remove - will shift values in pushStack to popStack and then remove them.
		for (int i = 0; i < initArr2.length; i++) {
			value = (int) queue.Remove();
			if (value != initArr2[i]) {
				fail("Expected " + initArr2[i] + "but retrieved:" + value);
			}

		}
	}
	
	@Test
	public void PeekTest() {
		// it should ... test for the first value in the Queue.
		int[] initArr = new int[] {3,7,1};
		TwoStackQueue<Integer> queue = new TwoStackQueue<Integer>();
		
		for (int i = 0; i < initArr.length; i++) {
			queue.Add(initArr[i]);
		}
		
		int value = (int) queue.Peek();
		
		if (value != initArr[0]) {
			fail("Expected " + initArr[0] + "but retrieved:" + value);
		}
	}
	
	@Test
	public void IsEmptyTest() {
		// it should ... verify that the queue is empty.
		int[] initArr = new int[] {3,7,1};
		TwoStackQueue<Integer> queue = new TwoStackQueue<Integer>();
		
		for (int i = 0; i < initArr.length; i++) {
			queue.Add(initArr[i]);
		}
		
		if (queue.IsEmpty()) {
			fail("Queue is not empty but IsEmpty() method did not detect it.");
		}
		
		for (int i = 0; i < initArr.length; i++) {
			queue.Remove();
		}
		
		if (!queue.IsEmpty()) {
			fail("Queue is empty but IsEmpty() method did not detect it");
		}
	}
	
}
