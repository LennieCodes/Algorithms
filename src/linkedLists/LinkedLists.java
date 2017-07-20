package linkedLists;

public class LinkedLists {
	
	// 2.1
	public static Node RemoveDupes(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		Node current = head;
		while (current != null) {
			Node runner = current;
			while (runner != null) {
				if (runner.next != null && runner.next.data == current.data) {
					runner.next = runner.next.next;
				}
				runner = runner.next;
			}
			current = current.next;
		}
		
		return head;
		
	}
	
	// 2.2
	public static Node FindKthToLast(Node head, int k) {
		return head;
	}
	
	// 2.3
	public static void DeleteNode(Node n) {
		
	}
	
	// 2.4
	public static Node Partition(Node head) {
		return head;
	}

}
