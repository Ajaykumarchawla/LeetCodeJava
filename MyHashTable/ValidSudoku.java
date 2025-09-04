package MyHashTable;
// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// Note:

// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.

// Example 1:

// Input: board = 
// [["5","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: true
// Example 2:

// Input: board = 
// [["8","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: false
// Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

// Constraints:

// board.length == 9
// board[i].length == 9
// board[i][j] is a digit 1-9 or '.'.
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> box = new HashMap<>(), rows = new HashMap<>(), columns = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int key = ((i / 3 * 3) + j / 3);
                if (!box.containsKey(key)) {
                    box.put(key, new HashSet<Character>());
                }
                if (box.get(key).contains(board[i][j])) {
                    return false;
                }

                box.get(key).add((Character) board[i][j]);

                if (!rows.containsKey(i)) {
                    rows.put(i, new HashSet<Character>());
                }
                if (rows.get(i).contains(board[i][j])) {
                    return false;
                }

                rows.get(i).add((Character) board[i][j]);

                if (!columns.containsKey(j)) {
                    columns.put(j, new HashSet<Character>());
                }
                if (columns.get(j).contains(board[i][j])) {
                    return false;
                }
                columns.get(j).add((Character) board[i][j]);
            }
        }
        return true;

    }

    public boolean isValidSudoku2(char[][] board) {
        boolean[][] box = new boolean[9][9], rows = new boolean[9][9], columns = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {

                    int key = ((i / 3 * 3) + j / 3);
                    if (box[key][board[i][j] - '1'] || rows[i][board[i][j] - '1'] || columns[j][board[i][j] - '1']) {
                        return false;
                    } else {
                        box[key][board[i][j] - '1'] = true;
                        rows[i][board[i][j] - '1'] = true;
                        columns[j][board[i][j] - '1'] = true;
                    }
                }
            }
        }
        return true;
    }
}

// Test Cases:
// [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
// [["8","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
