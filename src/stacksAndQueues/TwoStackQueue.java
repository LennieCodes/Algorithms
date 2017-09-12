package stacksAndQueues;

// 3.4
public class TwoStackQueue<T> {
	
	private MyStack<T> pushStack;
	private MyStack<T> popStack;
	
	public TwoStackQueue() {
		pushStack = new MyStack<T>();
		popStack = new MyStack<T>();
	}
	
	public void Add(T item) {
		pushStack.push(item);
	}
	
	public T Remove() {
		if (popStack.isEmpty()) {
			ShiftValues(); // repopulate popStack.
		}
		
		T item = popStack.pop();
						
		return item;		
	}
	
	public T Peek() {
		if (popStack.isEmpty() && !pushStack.isEmpty()) {
			ShiftValues();
		}
		return popStack.peek();
	}
	
	public boolean IsEmpty() {
		if (!popStack.isEmpty()) {
			return false;
		}
		else if (popStack.isEmpty() && !pushStack.isEmpty()) {
			return false;
		}
		return true;
	}
		
	private void ShiftValues() {
		while (!pushStack.isEmpty()) {
			popStack.push(pushStack.pop());
		}
	}
	

}
