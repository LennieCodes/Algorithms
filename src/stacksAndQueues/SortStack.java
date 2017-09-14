package stacksAndQueues;

import java.util.EmptyStackException;

// 3.5 
public class SortStack<Integer> {
	private static class StackNode<Integer> {
		private Integer data;
		private StackNode<Integer> next;
		
		public StackNode(Integer data) {
			this.data = data;
		}
	}
	
	private StackNode<Integer> top;
		
	public Integer Pop() {
		if (top == null) throw new EmptyStackException();
		Integer item = top.data;
		top = top.next;
		return item;
	}
	
	public void Push(Integer item) {
		StackNode<Integer> t = new StackNode<Integer>(item);
		t.next = top;
		top = t;
	}
	
	public Integer Peek() {
		if (top == null) throw new EmptyStackException();
		return top.data;
	}
	
	public boolean IsEmpty() {
		return top == null;
	}
	
	public SortStack<Integer> Sort(SortStack<Integer> stack) {
		if (stack.IsEmpty()) {
			throw new EmptyStackException();
		}
		
		SortStack<Integer> tempStack = new SortStack<Integer>();

		while (!stack.IsEmpty()) {
			Integer value = stack.Pop();
			if (tempStack.IsEmpty() || (int) tempStack.Peek() <= (int) value) {
				tempStack.Push(value);
			}
			else {
				while(!tempStack.IsEmpty() && (int) tempStack.Peek() > (int) value) {
					stack.Push(tempStack.Pop());
				}
				tempStack.Push(value);
			}
		}
		while (!tempStack.IsEmpty()) {
			stack.Push(tempStack.Pop());
		}
		
		return stack;
	}

}
