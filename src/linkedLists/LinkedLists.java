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
		if (head == null || head.next == null) {
			return head;
		}
		
		Pair<Node, Integer> result = new LinkedLists().FindKthToLastInternal(head.next, k);
		
		return result.getElement0();
	}
	
	private Pair<Node, Integer> FindKthToLastInternal(Node head, int k) {
		if (head.next == null) {
			return new Pair<Node, Integer>(head, new Integer(1));
		}
		
		Pair<Node, Integer> runner = FindKthToLastInternal(head.next, k);
		int counter = (int) runner.getElement1() + 1;
		
		if (counter == k) {
			return new Pair<Node, Integer>(head, new Integer(counter));
		}
		
		return new Pair<Node, Integer>(runner.getElement0(), new Integer(counter));
	}
	
	
	
	// 2.3
	public static void DeleteNode(Node n) {
		
	}
	
	// 2.4
	public static Node Partition(Node head) {
		return head;
	}

}
