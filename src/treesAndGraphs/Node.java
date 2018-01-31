package treesAndGraphs;

import java.util.ArrayList;

public class Node {
    public int data;
    public ArrayList<Node> adjacent;
    public boolean marked;

    public Node(int data) {
        this.data = data;
        adjacent = new ArrayList<Node>();
    }
}