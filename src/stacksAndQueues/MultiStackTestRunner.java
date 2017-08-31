package stacksAndQueues;

import static org.junit.Assert.*;
import org.junit.Test;

// 3.1 tests
public class MultiStackTestRunner {
	
	@Test
	public void PushTest() {
		// It should ... push a value onto each stack and verify that the value is placed properly.
		int size = 12;
		MultiStack stack = new MultiStack(size);
				
		stack.Push(1, 1);
		stack.Push(2, 4);
		stack.Push(3, 9);
		
		stack.Push(1, 10);
		stack.Push(2, 7);
		stack.Push(3, 8);
		
		int[] stackArray = stack.GetInternalArray();
		
		// stack 1 tests
		if (stackArray[0] != 1) {
			fail("Expected value 1 in index 0, but value is:" + stackArray[0]);
		}
		
		if (stackArray[1] != 10) {
			fail("Expected value 10 in index 1, but value is:" + stackArray[0]);
		}
		
		// stack 2 tests
		if (stackArray[4] != 4) {
			fail("Expected Value 4 in index 4, but value is:" + stackArray[4]);
		}
		
		if (stackArray[5] != 7) {
			fail("Expected value 7 in index 5, but value is:" + stackArray[0]);
		}
		
		// stack 3 tests
		if (stackArray[8] != 9) {
			fail("Expected Value 9 in index 8, but value is:" + stackArray[8]);
		}
		
		if (stackArray[9] != 8) {
			fail("Expected value 8 in index 9, but value is:" + stackArray[0]);
		}
		
		System.out.println("\n PushTest results:");
		for (int i = 0; i < stackArray.length; i++) {
			if (i == stackArray.length - 1) {
				System.out.print(stackArray[i]);
				continue;
			}
			
			System.out.print(stackArray[i] + ",");
		}
	}
	
	@Test
	public void PopTest() {
		// It should ... pop a value from each stack and verify that the value is removed properly.
		int size = 12;
		MultiStack stack = new MultiStack(size);
		
		stack.Push(1, 1);
		stack.Pop(1);
		stack.Push(1, 10);
		// if you push a value on the stack and then pop it and then push another value on the stack and pop it, you can verify that this is working.
		
		stack.Push(2, 4);
		stack.Pop(2);
		stack.Push(2, 9);
		
		stack.Push(3, 7);
		stack.Pop(3);
		stack.Push(3, 2);
		
		int[] stackArray = stack.GetInternalArray();
		
		if (stackArray[0] != 10) {
			fail("Pop operation did not work on stack 1. Value in index 0 is:" + stackArray[0]);
		}
		
		if (stackArray[4] != 9) {
			fail("Pop operation did not work on stack 2. Value in index 4 is: " + stackArray[4]);
		}
		
		if (stackArray[8] != 2) {
			fail("Pop operation did not work on stack 2. Value in index 8 is: " + stackArray[4]);
		}
		
		System.out.println("\n PopTest results:");
		for (int i = 0; i < stackArray.length; i++) {
			if (i == stackArray.length - 1) {
				System.out.print(stackArray[i]);
				continue;
			}
			
			System.out.print(stackArray[i] + ",");
		}

	}
	
	@Test
	public void PeekTest() {
		// It should ... return the top of each stack.
		int size = 12; 
		MultiStack stack = new MultiStack(size);
		
		for (int i = 0; i < size / 3; i++) {
			stack.Push(1, i);
			stack.Push(2, i);
			stack.Push(3, i);
		}
		
		if (stack.Peek(1) != 3 || stack.Peek(2) != 3 || stack.Peek(3) != 3) {
			fail("Peek operation expected to return 3 for each stack, but did not.");
		}
		
		int[] stackArray = stack.GetInternalArray();
		
		System.out.println("\n PeekTest results:");
		for (int i = 0; i < stackArray.length; i++) {
			if (i == stackArray.length - 1) {
				System.out.print(stackArray[i]);
				continue;
			}
			
			System.out.print(stackArray[i] + ",");
		}
	}
	
	@Test
	public void IsEmptyTest() {
		// It should ... Test to see if each stack is empty.
		int size = 12;
		MultiStack stack = new MultiStack(size);
		
		for (int i = 0; i < size / 3; i++) {
			stack.Push(1, i);
			stack.Push(2, i);
			stack.Push(3, i);
		}
		
		if (stack.IsEmpty(1) || stack.IsEmpty(2) || stack.IsEmpty(3)) {
			fail("Stacks are not empty, but IsEmpty operation does not detect it.");
		}
		
		for (int i = 0; i < size / 3; i++) {
			stack.Pop(1);
			stack.Pop(2);
			stack.Pop(3);
		}
		
		if (stack.IsEmpty(1) != true || stack.IsEmpty(2) != true || stack.IsEmpty(3) != true) {
			fail("Stacks are Empty, but IsEmpty operation does not detect it");
		}
		
		for (int i = 0; i < size / 3; i++) {
			stack.Push(1, 0);
			stack.Push(2, 0);
			stack.Push(3, 0);
		}
		
		int[] stackArray = stack.GetInternalArray();
		
		System.out.println("\n IsEmptyTest results:");
		for (int i = 0; i < stackArray.length; i++) {
			if (i == stackArray.length - 1) {
				System.out.print(stackArray[i]);
				continue;
			}
			
			System.out.print(stackArray[i] + ",");
		}

	}
	
	@Test
	public void PushTestWithResize() {
		// It should ... add values to force a resize, and then push to each stack after the resize and see if values are placed properly. 
		int size = 12;
		MultiStack stack = new MultiStack(size);
		
		for (int i = 0; i <= size / 3; i++) {
			stack.Push(1, i);
			stack.Push(2, i);
			stack.Push(3, i);
		}
		
		int[] stackArray = stack.GetInternalArray();
		
		if (stackArray[4] != 4) {
			fail("stack 1 did not resize properly");
		}
		
		if (stackArray[8] != 0) {
			fail("stack 2 did not resize properly");
		}
		
		if (stackArray[16] != 0) {
			fail("stack 3 did not resize properly");
		}
		
		stack.Push(1, 10);
		stack.Push(2, 7);
		stack.Push(3, 8);
		
		if (stackArray[5] != 10) {
			fail("Expected value 10 in index 5, but value is:" + stackArray[5]);		
		}
		
		if (stackArray[13] != 7) {
			fail("Expected value 7 in index 13, but value is:" + stackArray[13]);
		}
		
		if (stackArray[21] != 8) {
			fail("Expected value 8 in index 21, but value is:" + stackArray[21]);
		}
		
		System.out.println("\n PushTestWithResize results:");
		for (int i = 0; i < stackArray.length; i++) {
			if (i == stackArray.length - 1) {
				System.out.print(stackArray[i]);
				continue;
			}
			
			System.out.print(stackArray[i] + ",");
		}

	}
	
	@Test 
	public void PopTestWithResize() {
		// It should ... add values to force a resize, then pop from each stack after resize and see if values are displayed properly. 
		int size = 12;
		MultiStack stack = new MultiStack(size);
		
		for (int i = 0; i <= size / 3; i++) {
			stack.Push(1, i);
			stack.Push(2, i);
			stack.Push(3, i);
		}
		
		stack.Pop(1);
		stack.Pop(2);
		stack.Pop(3);
		
		stack.Push(1, 10);
		stack.Push(2, 13);
		stack.Push(3, 15);
		
		int[] stackArray = stack.GetInternalArray();
		
		if (stackArray[4] != 10) {
			fail("Pop operation did not work on stack 1. Expected top to be 10, but value in index 4 is:" + stackArray[4]);
		}
		
		if (stackArray[12] != 13) {
			fail("Pop operation did not work on stack 2. Expected top to be 13, but value in index 12 is:" + stackArray[12]);
		}
		
		if (stackArray[20] != 15) {
			fail("Pop operation did not work on stack 3. Expected top to be 15, but value in index 20 is:" + stackArray[20]);
		}
		
		System.out.println("\n PopTestWithResize results:");
		for (int i = 0; i < stackArray.length; i++) {
			if (i == stackArray.length - 1) {
				System.out.print(stackArray[i]);
				continue;
			}
			
			System.out.print(stackArray[i] + ",");
		}

	}
	
	@Test
	public void PeekTestWithResize() {
		// It should ... Peek to see the top of the stack after resize, and verify that the correct indexes are returned (because they will be shifted after resize)
		int size = 12;
		MultiStack stack = new MultiStack(size);
		
		for (int i = 0; i <= size / 3; i++) {
			stack.Push(1, i);
			stack.Push(2, i);
			stack.Push(3, i);
		}
		
		if (stack.Peek(1) != 4 || stack.Peek(2) != 4 || stack.Peek(3) != 4) {
			fail("Peek operation expected to return 4 for each stack, but did not.");
		}
		
		int[] stackArray = stack.GetInternalArray();
		
		System.out.println("\n PeekTestWithResize results:");
		for (int i = 0; i < stackArray.length; i++) {
			if (i == stackArray.length - 1) {
				System.out.print(stackArray[i]);
				continue;
			}
			
			System.out.print(stackArray[i] + ",");
		}

	}
	
	@Test 
	public void IsEmptyTestAfterResize() {
		// It should ... add values to force a resize, remove elements from a stack and verify that a stack is empty.
		int size = 12;
		MultiStack stack = new MultiStack(size);
		
		for (int i = 0; i <= size / 3; i++) {
			stack.Push(1, i);
			stack.Push(2, i);
			stack.Push(3, i);
		}
		
		if (stack.IsEmpty(1) || stack.IsEmpty(2) || stack.IsEmpty(3)) {
			fail("Stacks are not empty, but IsEmpty operation does not detect it.");
		}
		
		for (int i = 0; i <= size / 3; i++) {
			stack.Pop(1);
			stack.Pop(2);
			stack.Pop(3);
		}
		
		if (stack.IsEmpty(1) != true || stack.IsEmpty(2) != true || stack.IsEmpty(3) != true) {
			fail("Stacks are Empty, but IsEmpty operation does not detect it");
		}
		
		for (int i = 0; i <= size / 3; i++) {
			stack.Push(1, 0);
			stack.Push(2, 0);
			stack.Push(3, 0);
		}

		int[] stackArray = stack.GetInternalArray();		
		System.out.println("\n IsEmptyTestWithResize results:");
		for (int i = 0; i < stackArray.length; i++) {
			if (i == stackArray.length - 1) {
				System.out.print(stackArray[i]);
				continue;
			}
			
			System.out.print(stackArray[i] + ",");
		}
		
	}
	
}
