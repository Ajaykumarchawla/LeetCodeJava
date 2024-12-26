package Extra;
// 130. Surrounded Regions

// Solved
// Medium
// Topics
// Companies
// You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

// Connect: A cell is connected to adjacent cells horizontally or vertically.
// Region: To form a region connect every 'O' cell.
// Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
// A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.

// Example 1:

// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

// Explanation:

// In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

// Example 2:

// Input: board = [["X"]]

// Output: [["X"]]

// Constraints:

// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] is 'X' or 'O'.
public class SurroundedRegions {
    private void remove(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'Y';
        int[][] connect = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int k = 0; k < connect.length; k++) {
            int newi = i + connect[k][0], newj = j + connect[k][1];
            remove(board, newi, newj);
        }
    }

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int j = 0, jn = board[0].length - 1;
            if (board[i][j] == 'O') {
                remove(board, i, j);
            }
            if (board[i][jn] == 'O') {
                remove(board, i, jn);
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            int i = 0, in = board.length - 1;
            if (board[i][j] == 'O') {
                remove(board, i, j);
            }
            if (board[in][j] == 'O') {
                remove(board, in, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }

}