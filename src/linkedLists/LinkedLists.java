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
	
	// 2.5a 
	public static Node SumLists(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			throw new NullPointerException("One of the parameters to SumLists is null");
		}
		
		Node sum = new LinkedLists().SumListsInternal(head1, head2, 0, null);
		
		return sum;
	}
	
	private Node SumListsInternal(Node head1, Node head2, int carry, Node sum) {
		if (head1 == null && head2 == null) {
			return sum;
		}
		int value = 0;
		
		if (head1 != null && head2 != null) {
			value = head1.data + head2.data + carry;
		}
		
		else if (head1 != null) {
			value = head1.data + carry;
		}
		
		else if (head2 != null) {
			value = head2.data + carry;
		}
		
		carry = value >= 10 ? 1 : 0;
		
		if (sum == null) {
			sum = new Node(value % 10);
		}
		
		else {
			sum.appendToTail(value % 10);
		}
		
		sum = new LinkedLists().SumListsInternal(head1 != null ? head1.next : null, head2 != null ? head2.next : null, carry, sum);
		
		return sum;
	}
	
	// 2.5b
	public static Node SumListsReverse(Node head1, Node head2) {
		// Note: I skipped padding the lists with 0s, and just pass them in via the test initialization.
		
		if (head1 == null || head2 == null) {
			throw new NullPointerException("One of the parameters to SumListsReverse is null");
		}
		
		Pair<Node, Integer> result = new LinkedLists().SumListsReverseInternal(head1, head2);
		
		return result.getElement0();
		
	}
	
	private Pair<Node, Integer> SumListsReverseInternal(Node head1, Node head2) {
		if (head1 == null && head2 == null ) {
			return new Pair<Node, Integer>(null, 0);
		}
		
		Pair<Node, Integer> result = SumListsReverseInternal(head1 != null ? head1.next : null, head2 != null ? head2.next : null);
		int value = 0;
		int carry = 0;
		Node sum;
		
		if (head1 != null && head2 != null) {
			value = head1.data + head2.data + (int) result.getElement1();
		}
		
		else if (head1 != null) {
			value = head1.data + (int) result.getElement1();
		}
		
		else if (head2 != null) {
			value = head2.data + (int) result.getElement1();
		}
		
		carry = value >= 10 ? 1 : 0;
		
		if (result.getElement0() == null) {
			sum = new Node(value % 10);
		}
		else {
			sum = result.getElement0();
			sum = sum.appendToHead(value % 10);
		}
		
		return new Pair<Node, Integer>(sum, new Integer(carry));
		
	}

}
