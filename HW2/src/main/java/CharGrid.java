// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
        int rows = grid.length;
        int cols = grid[0].length;

        int minRow = rows, maxRow = -1;
        int minCol = cols, maxCol = -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == ch) {
                    if (i < minRow) minRow = i;
                    if (i > maxRow) maxRow = i;
                    if (j < minCol) minCol = j;
                    if (j > maxCol) maxCol = j;
                }
            }
        }

        if (maxRow == -1) return 0; // không tìm thấy

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus(int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isPlusCenter(i, j)) {
                    count++;
                }
            }
        }
        return count;
	}

    private boolean isPlusCenter(int r, int c) {
        char ch = grid[r][c];

        int up = countDir(r, c, -1, 0, ch);
        int down = countDir(r, c, 1, 0, ch);
        int left = countDir(r, c, 0, -1, ch);
        int right = countDir(r, c, 0, 1, ch);

        // phải có ít nhất 1 ký tự ở mỗi nhánh
        if (up > 0 && down > 0 && left > 0 && right > 0) {
            // tất cả nhánh cùng chiều dài
            return (up == down && down == left && left == right);
        }
        return false;
    }

    private int countDir(int r, int c, int dr, int dc, char ch) {
        int count = 0;
        int i = r + dr, j = c + dc;
        while (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == ch) {
            count++;
            i += dr;
            j += dc;
        }
        return count;
    }
	
}
