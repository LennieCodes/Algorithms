package stacksAndQueues;

import java.util.EmptyStackException;


// 3.1 Design an array that can hold 3 stacks 
public class MultiStack {
	
	private class StackInfo {		
		public int capacity, topIndex1, 
		topIndex2, topIndex3, length1, length2, length3, arrayCapacity;
	
		public StackInfo(int size) {
			stackInfo.capacity = size / 3;			
			stackInfo.arrayCapacity = size;
			
			stackInfo.topIndex1 = -1;
			stackInfo.topIndex2 = (size / 3) - 1;
			stackInfo.topIndex3 = ((size / 3) * 2) - 1;
			
			stackInfo.length1 = 0;
			stackInfo.length2 = 0;
			stackInfo.length3 = 0;
		}
		
	}
	
	StackInfo stackInfo;
	private int[] stackArray;
		
	public MultiStack(int size) {
		stackInfo = new StackInfo(size);				
		stackArray = new int[size];
	}
	
	public void Push(int stackNum, int value) {
		switch (stackNum) {
			case 1:
				if (stackInfo.length1 == stackInfo.capacity) {
					stackArray = DoubleArrayAndCopy();
				}
				stackInfo.topIndex1 = stackInfo.topIndex1 + 1;
				stackArray[stackInfo.topIndex1] = value;
				stackInfo.length1++;
				break;
			case 2:
				if (stackInfo.length2 == stackInfo.capacity) {
					// double stack size and copy
				}
				stackInfo.topIndex2 = stackInfo.topIndex2 + 1;
				stackArray[stackInfo.topIndex2] = value;
				stackInfo.length2++;
				break;
			case 3:
				if (stackInfo.length3 == stackInfo.capacity) {
					// double stack size and copy
				}
				stackInfo.topIndex3 = stackInfo.topIndex3 + 1;
				stackArray[stackInfo.topIndex3] = value;
				stackInfo.length3++;
				break;
			default:
				break;
		}	
	}
	
	public int Pop(int stackNum) {
		int value = 0;
		
		switch (stackNum) {
			case 1:
				if (stackInfo.topIndex1 == -1) throw new EmptyStackException();
				value = stackArray[stackInfo.topIndex1];
				stackInfo.topIndex1 = stackInfo.topIndex1 - 1;
				stackInfo.length1--;
				break;
			case 2:
				if (stackInfo.topIndex2 == (stackInfo.arrayCapacity / 3) - 1) throw new EmptyStackException();
				value = stackArray[stackInfo.topIndex2];
				stackInfo.topIndex2 = stackInfo.topIndex2 - 1;
				stackInfo.length2--;
				break;
			case 3:
				if (stackInfo.topIndex3 == ((stackInfo.arrayCapacity / 3) * 2) - 1) throw new EmptyStackException();
				value = stackArray[stackInfo.topIndex3];
				stackInfo.topIndex3 = stackInfo.topIndex3 - 1;
				stackInfo.length3--;
				break;
			
			default: 
				break;
		}
		
		return value;
		
	}
	
	public int Peek(int stackNum) {
		switch (stackNum) {
			case 1:
				if (stackInfo.topIndex1 == -1) throw new EmptyStackException();
				return stackArray[stackInfo.topIndex1];
			case 2:
				if (stackInfo.topIndex2 == (stackInfo.arrayCapacity / 3) - 1) throw new EmptyStackException();
				return stackArray[stackInfo.topIndex2];
			case 3: 
				if (stackInfo.topIndex3 == ((stackInfo.arrayCapacity / 3) * 2) - 1) throw new EmptyStackException();
				return stackArray[stackInfo.topIndex3];
			default:
				break;
		}
		
		throw new UnsupportedOperationException("Operation passed into Peek is not supported");
	}
	
	public boolean IsEmpty(int stackNum) {
		switch (stackNum) {
			case 1:
				return stackInfo.topIndex1 == -1;
			case 2: 
				return stackInfo.topIndex2 == ((stackInfo.arrayCapacity / 3) - 1);
			case 3:
				return stackInfo.topIndex3 == ((stackInfo.arrayCapacity / 3) * 2) - 1;
			default:	
				break;
		}
		
		throw new UnsupportedOperationException("Operation passed into Peek is not supported");
	}
		
	private int[] DoubleArrayAndCopy() {
		int capacity = stackInfo.arrayCapacity * 2;
		int[] doubleArray = new int[capacity];
		
		// populate stack1:
		int j = 0;
		for (int i = 0; i < stackInfo.capacity; i++) {
			doubleArray[j] = stackArray[i];
			j++;
		}
		
		// populate stack2:
		j = stackInfo.capacity * 2;
		for (int i = stackInfo.capacity; i < (stackInfo.capacity * 2); i++) {
			doubleArray[j] = stackArray[i];
			j++;
		}
		
		// populate stack 3:
		j = stackInfo.capacity * 4;
		for (int i = (stackInfo.capacity * 2); i < stackInfo.arrayCapacity; i++) {
			doubleArray[j] = stackArray[i];
			j++;
		}
		
		Reinitialize(capacity);
		
		return doubleArray;
	}
	
	
	private void Reinitialize(int size) {
		stackInfo.capacity = size / 3;			
		stackInfo.arrayCapacity = size;
		// ERROR HERE - YOU CAN'T REINITIALIZE THESE VALUES - They hold TOP information for the original array, but TOP does need to be reset to account
		// for SHIFT in the second and 3rd array. 
		stackInfo.topIndex1 = -1;
		stackInfo.topIndex2 = (size / 3) - 1;
		stackInfo.topIndex3 = ((size / 3) * 2) - 1;
	}
}
