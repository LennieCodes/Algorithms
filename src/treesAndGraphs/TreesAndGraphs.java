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

    // 4.2
    public static TreeNode CreateMinBST(int[] arr, TreeNode node) {
        int middle = (int) (arr.length / 2);
        int[] left = new int[middle];
        int[] right = new int[middle];
        if (node == null) {
            node = new TreeNode(arr[middle]);
        }
        // copy left side into new array. 
        for (int i = 0; i < middle; i++) {
            left[i] = arr[i];
        }
        // copy right side into new array
        int j = 0;
        for (int i = middle + 1; i < arr.length; i++) {
            right[j] = arr[i];
            j++;
        }

        if (left.length > 1) {
            node.left = CreateMinBST(left, node.left);
        }

        if (right.length > 1) {
            node.right = CreateMinBST(right, node.right);
        }

        if (left.length == 1) {
            node.left = new TreeNode(left[0]);
        }
        if (right.length == 1) {
            node.right = new TreeNode(right[0]);
        }

        return node;
    }

    // 4.4 - Book Assisted
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        int heightDiff = left - right;
        if (Math.abs(heightDiff) > 1) {
            return false;
        }
        else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        int max = Math.max(left, right);

        return max + 1;
    }

    // 4.5
    public static boolean isBinarySearchTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        boolean newMaxFound = searchForNewMax(root.left, root.data, false);
        boolean newMinFound = searchForNewMin(root.right, root.data, false);

        if (newMaxFound == true || newMinFound == true) {
            return false;
        }

        else {
            return isBinarySearchTree(root.left) && isBinarySearchTree(root.right);
        }
    }

    private static boolean searchForNewMax(TreeNode node, int currentMax, boolean newMaxFound) {
        if (node != null && newMaxFound != true) {
            newMaxFound = (searchForNewMax(node.left, currentMax, newMaxFound) 
                || searchForNewMax(node.right, currentMax, newMaxFound));
            if (newMaxFound == true || node.data > currentMax) { return true; }
        }
        return newMaxFound;
    }

    private static boolean searchForNewMin(TreeNode node, int currentMin, boolean newMinFound) {
        if (node != null && newMinFound != true) {
            newMinFound = (searchForNewMin(node.left, currentMin, newMinFound)
                || searchForNewMin(node.right, currentMin, newMinFound));
            if (newMinFound == true || node.data <= currentMin) { return true; }
        }
        return newMinFound;
    }

    // 4.6
    public static TreeNode findInOrderSuccessor(TreeNode n) {
        throw new UnsupportedOperationException();
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