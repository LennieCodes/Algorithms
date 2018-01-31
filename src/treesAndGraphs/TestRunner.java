package treesAndGraphs;


import static org.junit.Assert.*;
import org.junit.Test;

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
        ArrayList<Integer> list = new ArrayList<Integer>();

        Node root = TreesAndGraphs.CreateMinBST(initArr);
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

    // this will print a binary search tree in sorted, ascending order
    public void inOrderMinBSTTraversal(TreeNode node, ArrayList<Integer> list) {
        if (node != null) {
            inOrderMinBSTTraversal(node.left);
            list.add(node.data);
            inOrderMinBSTTraversal(node.right);
        }
    }

}

