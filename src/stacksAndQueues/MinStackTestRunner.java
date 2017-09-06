package stacksAndQueues;

import static org.junit.Assert.*;
import org.junit.Test;

// 3.2 tests
public class MinStackTestRunner {
		
	@Test 
	public void MinTest() {
		MinStack stack = new MinStack();
		// 10,7,8,7,2,3,2,1,10
		
		// push block
		stack.Push(10);
		if (stack.Min() != 10) {
			fail("Expected 10 to be the minimum, but it is not");
		}
		
		stack.Push(7);
		
		if (stack.Min() != 7) {
			fail("Expected 7 to be the minimum, but it is not.");
		}
		
		stack.Push(8);
		if (stack.Min() != 7) {
			fail("Expected 7 to be the minimum, but it is not");
		}
		
		stack.Push(7);
		if (stack.Min() != 7) {
			fail("Expected 7 to be the minimum, but it is not");
		}
		
		stack.Push(2);
		if (stack.Min() != 2) {
			fail("Expected 2 to be the minimum, but it is not");
		}
		
		stack.Push(3);
		if (stack.Min() != 2) {
			fail("Expected 2 to be the minimum, but it is not.");
		}
		
		stack.Push(2);
		if (stack.Min() != 2) {
			fail("Expected 2 to be the minimum, but it is not");
		}
		
		stack.Push(1);
		if (stack.Min() != 1) {
			fail("Expected 1 to be the minimum, but it is not");
		}
		
		stack.Push(10);
		if (stack.Min() != 1) {
			fail("Expected 1 to be the minimum, but it is not");
		}
		
		// pop block
		
		stack.Pop(); // 10
		if (stack.Min() != 1) {
			fail("Expected 1 to be the minimum, but it is not");
		}
		
		stack.Pop(); // 1
		if (stack.Min() != 2) {
			fail("Expected 2 to be the minimum, but it is not");
		}
		
		stack.Pop(); // 2
		if (stack.Min() != 2) {
			fail("Expected 2 to be the minimum, but it is not");
		}
		
		stack.Pop(); // 3 
		if (stack.Min() != 2) {
			fail("Expected 2 to be the minimum, but it is not");
		}
		
		stack.Pop(); // 2
		if (stack.Min() != 7) {
			fail("Expected 7 to be the minimum, but it is not");
		}
		
		stack.Pop(); // 7
		if (stack.Min() != 7) {
			fail("Expected 7 to be the minimum, but it is not");
		}
		
		stack.Pop(); // 8
		if (stack.Min() != 7) {
			fail("Expected 7 to be the minimum, but it is not");
		}
		
		stack.Pop(); // 7
		if (stack.Min() != 10) {
			fail("Expected 10 to be the minimum, but it is not");
		}
				
	}
		
}
