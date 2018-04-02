package treesAndGraphs;

import java.util.Random;

// 4.11 - book assisted
public class RandomTreeNode {
  private int data;
  public RandomTreeNode left;
  public RandomTreeNode right;
  private int size = 0;

  public RandomTreeNode(int d) {
    data = d;
    size = 1;
  }

  public RandomTreeNode getRandomNode() {
    int leftSize = left == null ? 0 : left.size();
    Random random = new Random();
    int index = random.nextInt(size);
    if (index < leftSize) {
      return left.getRandomNode();
    } else if (index == leftSize) {
      return this;
    } else {
      return right.getRandomNode();
    }
  }

  public void insertInOrder(int d) {
    if (d <= data) {
      if (left == null) {
        left = new RandomTreeNode(d);
      } else {
        left.insertInOrder(d);
      }
    } else {
      if (right == null) {
        right = new RandomTreeNode(d);
      } else {
        right.insertInOrder(d);
      }
    }
    size++;
  }

public int size() { return size; }
public int data() { return data; }

}