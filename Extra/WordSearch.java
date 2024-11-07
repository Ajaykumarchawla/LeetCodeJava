package Extra;
// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Example 1:

// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true
// Example 2:

// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true
// Example 3:

// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false

// Constraints:

// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board and word consists of only lowercase and uppercase English letters.

// Follow up: Could you use search pruning to make your solution faster with a larger board?
public class WordSearch {
    private boolean dfs(char[][] board, char[] word, int char_i, int i, int j) {
        if (char_i == word.length) {
            return true;
        } else if (board[i][j] == word[char_i]) {
            if (char_i == word.length - 1) {
                return true;
            }
            char temp = board[i][j];
            board[i][j] = '-';
            int valid = 0;
            if (i > 0) {
                if (dfs(board, word, char_i + 1, i - 1, j) == true)
                    valid = 1;
            }
            if (i < board.length - 1) {
                if (dfs(board, word, char_i + 1, i + 1, j) == true)
                    valid = 1;
            }
            if (j > 0) {
                if (dfs(board, word, char_i + 1, i, j - 1) == true)
                    valid = 1;
            }
            if (j < board[i].length - 1) {
                if (dfs(board, word, char_i + 1, i, j + 1) == true)
                    valid = 1;
            }

            board[i][j] = temp;
            if (valid == 1) {
                return true;
            } else
                return false;
        } else {
            return false;
        }
    }

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, chars, 0, i, j) == true) {
                    return true;
                }

            }
        }
        return false;
    }
}
