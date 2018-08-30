# The Problem
Othello is played as follows: Each Othello piece is white on one side and black on the other. When a piece is surrounded by its opponents on both the left and right sides, or both the top and bottom, it is said to be captured and its' color is flipped. On your turn, you must capture at least one of your opponent's pieces. The game ends when either user has no more valid moves. The win is assigned to the person with the most pieces. Implement the object-oriented design for Othello. 

## Object Oriented Design Questions
1. Handle Ambiguity. 

There are a lot of mistakes with the description above. Othello is played on an 8x8 grid. Black gets 32 chips and White gets 32 chips. The game ends when both Black and White have placed all their chips on the board. The winner is the player with the most chips on the board of their color. 

Also a note on captures: Lets say you have a white Othello chip 
in the center, and there is a black Othello chip on the bottom left square adjacent to the white chip. If black plays an Othello chip to the top right - then white's chip gets captured. Example:

XXB
XWX
BXX

The center white chip will get captured in this situation. 

Additionally, lets say you have: BWWWB. If this happens, 3
white chips get converted to black: BBBBB. 

2. Define core objects.
```Game```

3. Analyze relationships.
```Game```

The ```Game``` object has an NxN string array called board, which keeps track of all the board positions. A position, for example
would be board[0][1] which refers to row 0, col 1. 


## Object Oriented Design
```java
public class Game {
  // 0 = black, 1 = white. 
  public int[][] board; 
  public int blackUnused;
  public int whiteUnused;
  public int currentPlayer;
  
  public Game() {
    this.blackUnused = 32;
    this.whiteUnused = 32;
    this.currentPlayer = 0;
    this.board = new int[8][8];
    this.startGame();
  }

  public void startGame() {
    while (this.checkIfFinished() == false) {
      if (this.playerCanCapture(this.currentPlayer)) {
        this.placePieceOnBoard(this.currentPlayer);
      }
      this.currentPlayer = this.currentPlayer == 0 ? 1 : 0;
    }
  }

  public boolean checkIfFinished() {
    /* iterate through board, check if there is anymore space 
    available to place chips */
  }

  public boolean playerCanCapture(int currentPlayer) {
    /* Check to see if valid moves exist for current player*/
  }

  public void placePieceOnBoard(int currentPlayer) {
    /* place piece on board, then decrement counter. */ 
  }
}

```