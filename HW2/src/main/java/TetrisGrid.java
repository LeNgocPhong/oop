//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
    private boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
        int cols = grid.length;
        int rows = grid[0].length;

        int nextRow = 0; // vị trí để ghi hàng hợp lệ

        // duyệt từ dưới lên
        for (int y = 0; y < rows; y++) {
            if (!isFullRow(y)) {
                // copy hàng y xuống hàng nextRow
                for (int x = 0; x < cols; x++) {
                    grid[x][nextRow] = grid[x][y];
                }
                nextRow++;
            }
        }

        // điền các hàng trống ở trên cùng
        for (int y = nextRow; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                grid[x][y] = false;
            }
        }
	}

    private boolean isFullRow(int y) {
        for (int x = 0; x < grid.length; x++) {
            if (!grid[x][y]) return false;
        }
        return true;
    }
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		// YOUR CODE HERE
        return grid;
	}
}
