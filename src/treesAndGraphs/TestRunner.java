package treesAndGraphs;


import static org.junit.Assert.*;
import org.junit.Test;

import jdk.jfr.Timestamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

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

    @Test
    public void inOrderSuccessorTest() {
        /*
            How to construct this test?
            1. Build out a tree structure
            2. Pass in a left leaf (function should know to look at parent)
            3. Pass in a right leaf (function should know to look at root)
            4. Pass in max node (function should know to look at root and return max node)
            5. Pass in Node with right siblings. Function should know to look at left-most node in right subtree.
        */

        BinaryTree tree = new BinaryTree(8);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(10);
        TreeNode n8 = new TreeNode(14);
        TreeNode n9 = new TreeNode(13);
        TreeNode result = null;

        // root level
        tree.add(tree.getRoot(), n1, "left");
        tree.add(tree.getRoot(), n7, "right");
        // left subtree
        tree.add(n1, n2, "left");
        tree.add(n1, n3, "right");
        tree.add(n3, n4, "left");
        tree.add(n3, n5, "right");
        tree.add(n4, n6, "left");
        // right subtree
        tree.add(n7, n8, "right");
        tree.add(n8, n9, "left");

        // left leaf successor test.
        result = TreesAndGraphs.findInOrderSuccessor(n2);
        if (result != n1) {
            fail("left leaf successor is:" + n1.data + " but method returned:" + result.data);
        }

        // right leaf successor test.
        result = TreesAndGraphs.findInOrderSuccessor(n5);
        if (result != tree.getRoot()) {
            fail("right leaf successor is:" + tree.getRoot() + " but method returned:" + result.data);
        }

        // max node successor
        result = TreesAndGraphs.findInOrderSuccessor(n8);
        if (result != n8) {
            fail("max node successor is itself, but method did not detect it");
        }

        // mid node successor test
        result = TreesAndGraphs.findInOrderSuccessor(n1);
        if (result != n6) {
            fail("mid node success is:" + n6.data + " but method returned:" + result.data);
        }

    }

    @Test
    public void buildOrderTest() {
        /*
            How to setup this test?
            The method inputs an array of projects and a list of dependencies.
            Setup the expected output and see if method returns that output string.

            Also, you need to setup a test where no possible build order is found. Send that into
            the function and make sure that it reports that successfully as well.
        */
        ArrayList<ProjectNode> projects = new ArrayList<ProjectNode>();
        projects.add(new ProjectNode("A"));
        projects.add(new ProjectNode("B"));
        projects.add(new ProjectNode("C"));
        projects.add(new ProjectNode("D"));
        projects.add(new ProjectNode("E"));
        projects.add(new ProjectNode("F"));

        HashMap<String, String[]> dependencies = new HashMap<String, String[]>();
        dependencies.put("F", null);
        dependencies.put("E", null);
        dependencies.put("C", new String[] {"D"});
        dependencies.put("D", new String[] {"A","B"});
        dependencies.put("A", new String[] {"F"});
        dependencies.put("B", new String[] {"F"});
        String[] expectedOutput = new String[] {"F","A","B","D","C","E"};
        String[] output = TreesAndGraphs.findBuildOrder(projects, dependencies);

        for (int i = 0; i < expectedOutput.length; i++) {
            if (expectedOutput[i] != output[i]) {
                fail("Expected build order at index:" + i
                + " to be:" + expectedOutput[i] + "but instead output contains:" + output[i] );
            }
        }
    }

    @Test
    public void firstCommonAncestorTest() {
        BinaryTree tree = new BinaryTree(8);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(10);
        TreeNode n8 = new TreeNode(14);
        TreeNode n9 = new TreeNode(13);
        TreeNode result = null;


        // root level
        tree.add(tree.getRoot(), n1, "left");
        tree.add(tree.getRoot(), n7, "right");
        // left subtree
        tree.add(n1, n2, "left");
        tree.add(n1, n3, "right");
        tree.add(n3, n4, "left");
        tree.add(n3, n5, "right");
        tree.add(n4, n6, "left");
        // right subtree
        tree.add(n7, n8, "right");
        tree.add(n8, n9, "left");

        result = TreesAndGraphs.findFirstCommonAncestor(n3, n8);

        if (result == null || result != tree.getRoot()) {
            fail("Expected: " + tree.getRoot().data + " but retrieved: " + result.data);
        }
    }

    @Test 
    public void bstSequencesTest() {
        /* 
            1. Call permutations on an array of 3 elements, then prepend the "head" to every result of that operation.
            2. Call BSTSequences() passing in head. The result will be an array of elements. 
            3. Check to see if that array is equal. If it isn't fail. 
        */ 
        int head = 3;
        int[] initArr = new int[] {1,2,4};

        ArrayList<LinkedList<Integer>> testSequenceLists = Permutations.permute(initArr);
        for (LinkedList<Integer> list : testSequenceLists) {
            list.addFirst(head);
        }

        // create tree to pass into test
        BinaryTree tree = new BinaryTree(head);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        tree.add(tree.getRoot(), n1, "left");
        tree.add(tree.getRoot(), n3, "right");
        tree.add(n1, n2, "left");

        ArrayList<LinkedList<Integer>> sequenceLists = TreesAndGraphs.bstSequences(tree.getRoot());
        for (LinkedList<Integer> list : sequenceLists) {
            list.addFirst(head);
        }

        for (int i = 0; i < testSequenceLists.size(); i++) {
            LinkedList<Integer> testList = testSequenceLists.get(i);
            LinkedList<Integer> resultList = sequenceLists.get(i);

            for (int j = 0; j < testList.size(); j++) {
                if (testList.get(j) != resultList.get(j)) {
                    fail("Sequence lists do not match.");
                }
            }
        }
    }

    @Test
    public void checkSubtreeTest() {
        BinaryTree tree = new BinaryTree(8);
        BinaryTree tree2 = new BinaryTree(10);
        BinaryTree tree3 = new BinaryTree(10);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(10);
        TreeNode n8 = new TreeNode(14);
        TreeNode n9 = new TreeNode(13);

        // Nodes for Tree 2. 
        TreeNode s1 = new TreeNode(14);
        TreeNode s2 = new TreeNode(13);

        // Nodes for Tree 3.
        TreeNode t1 = new TreeNode(14);
        TreeNode t2 = new TreeNode(13);

        // root level - tree 1
        tree.add(tree.getRoot(), n1, "left");
        tree.add(tree.getRoot(), n7, "right");
        // left subtree
        tree.add(n1, n2, "left");
        tree.add(n1, n3, "right");
        tree.add(n3, n4, "left");
        tree.add(n3, n5, "right");
        tree.add(n4, n6, "left");
        // right subtree
        tree.add(n7, n8, "right");
        tree.add(n8, n9, "left");

        // tree 2
        tree2.add(tree2.getRoot(), s1, "right");
        tree2.add(s1, s2, "left");

        // tree 3 - same nodes but structurally different from tree 2. 
        tree3.add(tree3.getRoot(), t1, "left");
        tree3.add(t1, t2, "right");

        if (TreesAndGraphs.checkSubtree(tree.getRoot(), tree2.getRoot()) == false) {
            fail("Tree 2 is a subtree of Tree 1, but method does not detect it");
        }

        if (TreesAndGraphs.checkSubtree(tree.getRoot(), tree3.getRoot()) == true) {
            fail("Tree 3 is not a subtree of Tree 1, but method does not detect it");
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

