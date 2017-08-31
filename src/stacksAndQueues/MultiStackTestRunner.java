package stacksAndQueues;

import static org.junit.Assert.*;
import org.junit.Test;

public class MultiStackTestRunner {
	
	@Test
	public void PushTest() {
		// It should ... push a value onto each stack and verify that the value is placed properly.
	}
	
	@Test
	public void PopTest() {
		// It should ... pop a value from each stack and verify that the value is removed properly.
	}
	
	@Test
	public void PeekTest() {
		// It should ... return the top of each stack.
	}
	
	@Test
	public void IsEmptyTest() {
		// It should ... Test to see if each stack is empty.
	}
	
	@Test
	public void PushTestWithResize() {
		// It should ... add values to force a resize, and then push to each stack after the resize and see if values are placed properly. 
	}
	
	@Test 
	public void PopTestWithResize() {
		// It should ... add values to force a resize, then pop from each stack afte resize and see if values are displayed properly. 
	}
	
	@Test
	public void PeekTestWithResize() {
		// It should ... Peek to see the top of the stack after resize, and verify that the correct indexes are returned (because they will be shifted after resize)
	}
	
	@Test 
	public void IsEmptyTestAfterResize() {
		// It should ... add values to force a resize, remove elements from a stack and verify that a stack is empty. 
	}
	
}
