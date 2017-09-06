package stacksAndQueues;

import stacksAndQueues.MyStack;

// 3.2
public class MinStack {
	private MyStack<Integer> InternalMinStack;
	private MyStack<Integer> InternalStack;
	
	public MinStack() {
		InternalMinStack = new MyStack<Integer>();
		InternalStack = new MyStack<Integer>();
	}
	
	public void Push(Integer item) {
		if (InternalMinStack.isEmpty() == true
				|| (int) item <= (int) InternalMinStack.peek()) {
			InternalMinStack.push(item);
		}
		
		InternalStack.push(item);
	}
	
	public Integer Pop() {
		if ((int) InternalMinStack.peek() == (int) InternalStack.peek()) {
			InternalMinStack.pop();
		}
		
		return InternalStack.pop();
	}
	
	public Integer Min() {
		return InternalMinStack.peek();
	}
	
	
	public boolean IsEmpty() {
		return InternalStack.isEmpty();
	}
	
	public Integer Peek() {
		return InternalStack.peek();
	}
	
	
	
}
