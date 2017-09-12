package stacksAndQueues;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

// 3.3 tests
public class SetOfStacksTestRunner {
	@Test
	public void PushTest() {
		// it should ... push values onto the stack, forcing a new stack to be created, then print the array list to see verify that a new stack was created.
		int threshold = 3;
		int[] inputArr = new int[] {3,6,2,1,7,2,9,3,2};
		SetOfStacks stack = new SetOfStacks(threshold);
		
		for (int i = 0; i < inputArr.length; i++) {
			stack.Push(inputArr[i]);
		}
		
		ArrayList<MyStack<Integer>> stackList = stack.GetStackListInternal();
		
		assert(stackList.size() == 3);
		
		for (int i = inputArr.length - 1; i >= 0; i--) {
			Integer value = stack.Pop();
			if ((int) value != inputArr[i]) {
				fail("Expected value: " + inputArr[i] + " but value popped is: " + value);
			}
		}		
	}
	@Test
	public void PopTest() {
		// it should ... create a second stack, and verify that after popping off all the values, the stack is removed.
		int threshold = 3;
		int[] inputArr = new int[] {3,6,2,1,7,2,9,3,2};
		SetOfStacks stack = new SetOfStacks(threshold);
		
		for (int i = 0; i < inputArr.length; i++) {
			stack.Push(inputArr[i]);
		}
		
		ArrayList<MyStack<Integer>> stackList = stack.GetStackListInternal();
		
		assert(stackList.size() == 3);
		
		for (int i = inputArr.length - 1; i >= (inputArr.length / 3); i--) {
			Integer value = stack.Pop();
			if ((int) value != inputArr[i]) {
				fail("Expected value: " + inputArr[i] + " but value popped is: " + value);
			}
		}
		
		assert(stackList.size() == 1);
	}
	
	@Test
	public void PopAtTest() {
		// it should ... create 3 stacks, then pop values off the stacks.
		int threshold = 3;
		int[] inputArr = new int[] {3,6,2,1,7,2,9,3,2};
		SetOfStacks stack = new SetOfStacks(threshold);
		
		for (int i = 0; i < inputArr.length; i++) {
			stack.Push(inputArr[i]);
		}
		
		Integer s1val = stack.PopAt(1);
		Integer s2val = stack.PopAt(2);
		Integer s3val = stack.PopAt(3);
		
		assert((int) s1val == inputArr[2]);
		assert((int) s2val == inputArr[5]);
		assert((int) s3val == inputArr[8]);
		
	}
	@Test
	public void PopAtDeletionTest() {
		// it should ... create 3 stacks, and fully remove the values from stack 2 - and verify that stack 2 has been removed successfully from the stackList.
		int threshold = 3;
		int[] inputArr = new int[] {3,6,2,1,7,2,9,3,2};
		int[] finalArr = new int[] {3,6,2,9,3,2};
 		SetOfStacks stack = new SetOfStacks(threshold);
		
		for (int i = 0; i < inputArr.length; i++) {
			stack.Push(inputArr[i]);
		}
		
		ArrayList<MyStack<Integer>> stackList = stack.GetStackListInternal();
		
		assert(stackList.size() == 3);
		
		for (int i = 0; i < inputArr.length / 3; i++) {
			stack.PopAt(2);
		}
		
		assert(stackList.size() == 2);
		
		for (int i = finalArr.length - 1; i >= 0; i--) {
			Integer value = stack.Pop();
			if ((int) value != finalArr[i]) {
				fail("Expected value: " + finalArr[i] + " but value popped is: " + value);
			}
		}
		
		
	}
	

}
