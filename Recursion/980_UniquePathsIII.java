import java.util.*;

class Solution {

    int result = 0;
    int emptyCells = 0;
    int rows, cols;

    public int uniquePathsIII(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        int startRow = 0, startCol = 0;

        // count empty cells + find start
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 0) emptyCells++;

                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        // include start cell
        dfs(grid, startRow, startCol, emptyCells + 1);

        return result;
    }

    private void dfs(int[][] grid, int r, int c, int remain) {

        // out of bounds or obstacle or visited
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == -1) {
            return;
        }

        // reached end
        if (grid[r][c] == 2) {
            if (remain == 0) result++;
            return;
        }

        // mark visited
        int temp = grid[r][c];
        grid[r][c] = -1;

        // explore 4 directions
        dfs(grid, r + 1, c, remain - 1);
        dfs(grid, r - 1, c, remain - 1);
        dfs(grid, r, c + 1, remain - 1);
        dfs(grid, r, c - 1, remain - 1);

        // backtrack
        grid[r][c] = temp;
    }
}