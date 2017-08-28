package stacksAndQueues;

import java.util.EmptyStackException;

// 3.1 Design an array that can hold 3 stacks 
public class MultiStack {
	
	private static class StackInfo {		
		public static int capacity1, capacity2, capacity3, topIndex1, 
		topIndex2, topIndex3, length1, length2, length3;
	}
	
	
	private int[] stackArray;
	private int capacity;
	private int topIndex;
	
	public MultiStack(int size) {
		// what if you get something that doesn't divide by 3? 
		StackInfo.capacity1 = size / 3;
		StackInfo.capacity2 = size / 3;
		StackInfo.capacity3 = size / 3;
		
		StackInfo.topIndex1 = -1;
		StackInfo.topIndex2 = -1;
		StackInfo.topIndex3 = -1;
		
		StackInfo.length1 = 0;
		StackInfo.length2 = 0;
		StackInfo.length3 = 0;
		
		stackArray = new int[size];
	}
	
	public void Push(int stackNum, int value) {
		switch (stackNum) {
			case 1:
				if (StackInfo.length1 == StackInfo.capacity1) {
					// double stack size and copy
				}
				StackInfo.topIndex1 = StackInfo.topIndex1 + 1;
				stackArray[StackInfo.topIndex1] = value;
				break;
			case 2:
				if (StackInfo.length2 == StackInfo.capacity2) {
					// double stack size and copy
				}
				StackInfo.topIndex2 = StackInfo.topIndex2 + 1;
				stackArray[StackInfo.topIndex2] = value;
				break;
			case 3:
				if (StackInfo.length3 == StackInfo.capacity3) {
					// double stack size and copy
				}
				StackInfo.topIndex3 = StackInfo.topIndex3 + 1;
				stackArray[StackInfo.topIndex3] = value;
				break;
			default:
				break;
		}	
	}
	
	public int Pop() {
		if (topIndex == -1) throw new EmptyStackException();
		
		int value = stackArray[topIndex];
		topIndex = topIndex - 1;
		
		return value;
	}
	
	public int Peek() {
		if (topIndex == -1) throw new EmptyStackException();
		
		return stackArray[topIndex];
	}
	
	public boolean IsEmpty() {
		return topIndex == -1;
	}
	
	private int[] DoubleSizeAndCopy() {
		capacity = capacity * 2;
		int[] doubleArray = new int[capacity];
		
		for (int i = 0; i < stackArray.length; i++) {
			doubleArray[i] = stackArray[i];
		}
		
		return doubleArray;
	}
		
}
