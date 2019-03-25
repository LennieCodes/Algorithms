package recursionAndDynamic;

import java.util.ArrayList;


public class RecursionAndDynamic {
	// 8.1 - book assisted
	public static int countWays(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWays(n-3) + countWays(n-2) + countWays(n-1);
		}
	}
	// 8.2 - book assisted, though I did figure out the algorithm on how this works. 
	public static ArrayList<Point> findPath(boolean[][] grid) {
		
		if (grid == null || grid.length == 0) return null;
		ArrayList<Point> path = new ArrayList<Point>();
		
		if (getPathRecursive(grid, grid.length - 1, grid[0].length -1, path)) {
			return path;
		}
		
		return null;
		
	}
	
	public static boolean getPathRecursive(boolean[][] grid, int row, int col, ArrayList<Point> path) {
		// check for out of bounds
		if (col < 0 || row < 0 || !grid[row][col]) {
			return false;
		}
		
		boolean isAtOrigin = (row == 0) && (col == 0);
		
		if (isAtOrigin || getPathRecursive(grid, row, col - 1, path) || getPathRecursive(grid, row - 1, col, path)) {
			Point p = new Point(row, col);
			path.add(p);
			return true;
		}
		
		return false;
	}
}

