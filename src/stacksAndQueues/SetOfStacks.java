package stacksAndQueues;

import java.util.ArrayList;

// 3.3
public class SetOfStacks {
	
	private int threshold; 
	private ArrayList<MyStack<Integer>> stackList;
	
	public SetOfStacks(int threshold) {
		if (threshold < 1) throw new NullPointerException("Threshold must be greater than 0");
		
		this.threshold = threshold;
		stackList = new ArrayList<MyStack<Integer>>();
	}
	
	public void Push(Integer value) {
		
		if (stackList.isEmpty()) {
			MyStack<Integer> newStack = new MyStack<Integer>();
			newStack.push(value);
			stackList.add(newStack);
			return;
		}
		
		MyStack<Integer> stack = stackList.get(stackList.size() - 1);
		
		if (stack.GetLength() == threshold) {
			MyStack<Integer> newStack = new MyStack<Integer>();
			newStack.push(value);
			stackList.add(newStack);
			return;
		}
		
		stack.push(value);
	}
	
	public Integer Pop() {
		MyStack<Integer> stack = stackList.get(stackList.size() - 1);
		
		Integer value = stack.pop();
		
		if (stack.GetLength() == 0) {
			stackList.remove(stackList.size() - 1);
		}
		
		return value;
	}
	
	public Integer Peek() {
		MyStack<Integer> stack = stackList.get(stackList.size() - 1);
		return stack.peek();
	}
	
	public boolean IsEmpty() {
		return stackList.isEmpty();
	}
	
	public Integer PopAt(int index) {
		int zeroIndex = index - 1;
		MyStack<Integer> stack = stackList.get(zeroIndex);
		
		Integer value = stack.pop();
		
		if (stack.GetLength() == 0) {
			stackList.remove(zeroIndex);
		}
		
		return value;
	}
	
	public ArrayList<MyStack<Integer>> GetStackListInternal() {
		return stackList;
	}
	
	
}
