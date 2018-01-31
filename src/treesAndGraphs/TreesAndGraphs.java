package treesAndGraphs;

import java.util.LinkedList;

public class TreesAndGraphs {

    // 4.1
    public static boolean pathExists(Node start, Node end) {
        if (start == end) {
            return true;
        }

        LinkedList<Node> queue = new LinkedList<Node>();

        start.marked = true;

        queue.add(start);

        Node node;

        while (queue.size() != 0) {
            node = queue.poll();
            if (node == end) {
                return true;
            }

            for (Node child : node.adjacent) {
                if (child.marked == false) {
                    child.marked = true;
                    queue.add(child);
                }
            }
        }

        return false;
    }

    public static Node CreateMinBST(int[] arr) {
        return null;
    }

    // Breadth First Search implementation
    public void Search(Node root) {
        if (root == null) {
            return;
        }

        LinkedList<Node> queue = new LinkedList<Node>();
        root.marked = true;
        queue.add(root);

        Node node;
        while (queue.size() != 0) {
            node = queue.poll();
            Visit(node);
            node.marked = true;

            for (Node child : node.adjacent) {
                if (child.marked == false) {
                    child.marked = true;
                    queue.add(child);
                }
            }
        }
    }

    public void Visit(Node node) {
        if (node != null) {
            System.out.println(node.data);
        }
    }

}