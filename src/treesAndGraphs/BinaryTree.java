package treesAndGraphs;

public class BinaryTree {
    private TreeNode root;

    public BinaryTree(int data) {
        this.root = new TreeNode(data);
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public void add(TreeNode parent, TreeNode child, String orientation) {
        if (orientation.equals("left")) {
            parent.left = child;
        }
        else {
            parent.right = child;
        }
    }
}