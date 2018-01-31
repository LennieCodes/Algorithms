package treesAndGraphs;


import static org.junit.Assert.*;
import org.junit.Test;

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
}

