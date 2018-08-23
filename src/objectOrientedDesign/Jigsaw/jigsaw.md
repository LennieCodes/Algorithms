# The problem.

Implement an NxN Jigsaw Puzzle. Design the data structures and explain an algorithm to solve the puzzle.
You can assume that you have a fitsWith method which, when passed two puzzle edges, returns true if the two edges belong together. 

## Object Oriented Design Questions:
1. Handle ambiguity. 
What does it mean to be a Jigsaw puzzle? If you're an NxN puzzle, suppose you are a 3x3 puzzle. The
center piece in this puzzle would fit with top, right, left and bottom pieces. Whereas the bottom left edge
would fit with a right and top piece. 

A puzzle is solved when all of the pieces have been moved to the done state. 

I'm making the assumption that I can change the fitsWith method a bit.

2. Define core objects. 
JigsawPuzzle, PuzzlePiece. 

3. Analyze relationships.
A JigsawPuzzle has an array of PuzzlePieces. Each puzzle piece has an ID attached to it (1-9, for our 3x3 example). If it's an NxN puzzle, then the max ID is N. Each puzzle piece has an array of piece IDs that it fits with. 

JigsawPuzzle can have a fitsWith() method that takes two puzzle pieces (A and B), checks to see if ID of A
if in B, if it is - then the ID of puzzle piece B is removed from A and the ID of puzzle piece A is removed from B. When a puzzlePiece has no more IDs in its' fitsWith array, it can be considered as solved. 

A puzzle pieces can be considered as solved if fitsWith array is empty. 

A puzzle is solved when no pieces have any elements in the fitsWith array.

1,2,3
4,5,6
7,8,9

Puzzle piece 5 fitsWith 2,4,6,8. If fitsWith is called with puzzlePiece 2 and 5, 2 is removed from 
5's fitsWith and 5 is removed from 2s fitsWith. Then the lengths of the fitsWith array on both
puzzlePieces is checked. if either one still has length, then the game continues. If neither have length,
iterate through all puzzle pieces in JigSawPuzzle array, checking fitsWith length. If all
fitsWith lengths have 0, the jigsaw puzzle is solved. (An improvement here would be to simply remove a puzzlePiece from the jigsawPuzzle array when its' fitsWith array is empty). 


4. Investigate actions. 

JigSawPuzzle has a fitsWith method that takes two puzzlePieces.  The algorithm for solving is described above. 

## Data structures:
```java

public class JigsawPuzzle {
  public boolean gameInProgress;
  public ArrayList<PuzzlePiece> pieceList; 
  
  public JigsawPuzzle(PuzzleConfiguration config) {
    this.gameInProgress = true;
    // initialize puzzle here. 
  }

  public void fitsWith(PuzzlePiece a, PuzzlePiece b) {
    boolean matchFound = false;
    for (int i = 0; i < b.fitsWithList.length; i++) {
      if (a.id == b.fitsWithList.get(i)) {
        b.fitsWithList.remove(i);
        matchFound = true;
        break;
      }
    }
    if (matchFound == true) {
      for (int i = 0; i < a.fitsWithList.length; i++) {
        if (b.id == a.fitsWithList.get(i)) {
          a.fitsWithList.remove(i);
          break;
        }
      }
    }
    if (a.fitsWithList.size() == 0 || b.fitsWithList.size() == 0) {
      cleanPieceList();
    }
    
    if (this.pieceList.size == 0) {
      this.gameInProgress = false; // end game.
    }
  }


  public void cleanPieceList() {
    public ArrayList<Integer> idsToRemove = new ArrayList<Integer>();
    for (int i = 0; i < this.pieceList.size(); i++) {
      if (this.pieceList.get(i).fitsWithList.size() == 0) {
        idsToRemove.add(i);
      }
    }
    for (int i = 0; i < idsToRemove.size(); i++) {
      this.pieceList.remove(idsToRemove.get(i));
    }
  } 
}

public class PuzzlePiece {
  public int id;
  public ArrayList<Integer> fitsWithList;
}

public class PuzzleConfiguration {
  // initialize puzzle here. 
}


```