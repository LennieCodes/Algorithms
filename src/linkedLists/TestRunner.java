package linkedLists;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestRunner {

	@Test 
	public void RemoveDupesTest() {
		Node head = null;		
		int[] initArr = new int[] {2,2,4,5,2,8,5};
		int[] finalArr = new int[] {2,4,5,8};
		
		for (int i = 0; i < initArr.length; i++) {
			// should only be null on 0 index
			if (head == null) {
				head = new Node(initArr[i]);
				continue;
			}
			head.appendToTail(initArr[i]);
		}
		
		head = LinkedLists.RemoveDupes(head);
		
		int index = 0;
		while (head != null) {
			if (head.data != finalArr[index]) {
				fail("Linked List should be unique, but is not.");
			}
			
			index++;
			head = head.next;
		}
		
	}
	
	@Test
	public void FindKthToLastTest() {
		Node head = null;
		int[] initArr = new int[] {5, 6, 7, 8, 9};
		int k = 3; // 3rd to last
		
		for (int i = 0; i < initArr.length; i++) {
			if (head == null) {
				head = new Node(initArr[i]);
				continue;
			}
			head.appendToTail(initArr[i]);
		}
		
		head = LinkedLists.FindKthToLast(head, k);
		
		if (head.data != initArr[k-1]) {
			fail("Expected:" + initArr[k-1] + " But retrieved: " + head.data);
		}
		
	}
}
