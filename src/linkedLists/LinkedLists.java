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
		if (n == null || n.next == null) {
			return;
		}
		
		while (n != null) {
			n.data = n.next.data;
			
			if (n.next.next == null) {
				n.next = null;
			}
			
			n = n.next;
		}
	}
	
	// 2.4
	public static Node Partition(Node head, int pivot) {
		if (head == null || head.next == null) {
			throw new NullPointerException("head is null");
		}
		
		Node partA = null;
		Node partB = null;
		Node runner = head;
		
		while (runner != null) {
			if (runner.data < pivot) {
				if (partA != null) {
					partA.appendToTail(runner.data);
				}
				else {
					partA = new Node(runner.data);
				}
			}
			else {
				if (partB != null) {
					partB.appendToTail(runner.data);
				}
				else {
					partB = new Node(runner.data);
				}
			}
			runner = runner.next;
		}
		
		runner = head;
		
		while (partA != null) {
			runner.data = partA.data;
			runner = runner.next;
			partA = partA.next;
		}
		
		while (partB != null) {
			runner.data = partB.data;
			runner = runner.next;
			partB = partB.next;
		}
		
		return head;
	}

}
