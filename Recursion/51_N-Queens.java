import java.util.*;

class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(0, board, result, n);
        return result;
    }

    private void backtrack(int row, char[][] board, List<List<String>> result, int n) {

        // base case
        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {

                // place queen
                board[row][col] = 'Q';

                // explore next row
                backtrack(row + 1, board, result, n);

                // backtrack
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {

        // check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();

        for (char[] row : board) {
            res.add(new String(row));
        }

        return res;
    }
}