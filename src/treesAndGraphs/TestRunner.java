package treesAndGraphs;


import static org.junit.Assert.*;
import org.junit.Test;

import jdk.jfr.Timestamp;

import java.util.ArrayList;

public class TestRunner {
    @Test 
    public void pathExistsTest() {
        // init
        Node root = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        /* setup relationship
            0: 1
            1: 2
            2: 0, 3
            3: 2
        */
        root.adjacent.add(one);
        one.adjacent.add(two);
        two.adjacent.add(root);
        two.adjacent.add(three);
        three.adjacent.add(two);

        if (!TreesAndGraphs.pathExists(root, three)) {
            fail("Path between root and three exists, but method does not detect it");
        }

    }

    @Test
    public void pathDoesNotExistTest() {
        Node root = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node six = new Node(6);

        root.adjacent.add(one);
        one.adjacent.add(two);
        two.adjacent.add(root);
        two.adjacent.add(three);
        three.adjacent.add(two);

        if (TreesAndGraphs.pathExists(root, six)) {
            fail("Path between root and six does not exist - result should not be true");
        }

    }

    @Test
    public void createMinBSTTest() {
        int[] initArr = new int[] {2,4,6,8,9,10,20};
        //int[] initArr = new int[] {2,4,6};
        ArrayList<Integer> list = new ArrayList<Integer>();

        TreeNode root = TreesAndGraphs.CreateMinBST(initArr, null);
        inOrderMinBSTTraversal(root, list);

        int value;
        for (int i = 0; i < initArr.length; i++) {
            value = list.get(i);
            if (initArr[i] != value) {
                fail("Expected:" + initArr[i] + " but result list contains:" + value);
            }
        }

        /*
            How to structure this test? 
            I mean you have to iterate through this tree with one of the known methods
            and see if it lines up right?
            
            visit could just add the value to an array, and then you compare final
            array to initarray, if they're the same, you know you got it right. 

        */
    }

    @Test 
    public void isBalancedTest() {
        BinaryTree tree = new BinaryTree(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);

        tree.add(tree.getRoot(), n1, "left");
        tree.add(n1, n2, "right");

        if (TreesAndGraphs.isBalanced(tree.getRoot())) {
            fail("Tree is not balanced, but method does not detect it");
        }
    }

    @Test 
    public void isBSTTest() {
        
        //  test to see if function correctly determines that tree is not BST.
        
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(10);
        TreeNode n5 = new TreeNode(20);


        BinaryTree tree1 = new BinaryTree(8);
        tree1.add(tree1.getRoot(), n1, "left");
        tree1.add(tree1.getRoot(), n4, "right");
        tree1.add(n1, n2, "left");
        tree1.add(n1, n3, "right"); // should make func fail
        tree1.add(n4, n5, "right");

        if (TreesAndGraphs.isBinarySearchTree(tree1.getRoot()) == true) {
            fail("tree1 is not a binary search tree, but method does not detect it");
        }

        // test to see if function correctly determines that tree is BST 

        n3 = new TreeNode(6);
        BinaryTree tree2 = new BinaryTree(8);
        tree2.add(tree2.getRoot(), n1, "left");
        tree2.add(tree2.getRoot(), n4, "right");
        tree2.add(n1, n2, "left");
        tree2.add(n1, n3, "right"); 
        tree2.add(n4, n5, "right");

        if (TreesAndGraphs.isBinarySearchTree(tree2.getRoot()) == false) {
            fail("tree2 is a binary search tree, but method does not detect it.");
        }

    }

    // this will print a binary search tree in sorted, ascending order
    public void inOrderMinBSTTraversal(TreeNode node, ArrayList<Integer> list) {
        if (node != null) {
            inOrderMinBSTTraversal(node.left, list);
            list.add(node.data);
            inOrderMinBSTTraversal(node.right, list);
        }
    }

}

