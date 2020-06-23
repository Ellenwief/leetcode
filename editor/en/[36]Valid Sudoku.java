//Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be val
//idated according to the following rules: 
//
// 
// Each row must contain the digits 1-9 without repetition. 
// Each column must contain the digits 1-9 without repetition. 
// Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without r
//epetition. 
// 
//
// 
//A partially filled sudoku which is valid. 
//
// The Sudoku board could be partially filled, where empty cells are filled with
// the character '.'. 
//
// Example 1: 
//
// 
//Input:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//Output: true
// 
//
// Example 2: 
//
// 
//Input:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//Output: false
//Explanation: Same as Example 1, except with the 5 in the top left corner being
// 
//    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is 
//invalid.
// 
//
// Note: 
//
// 
// A Sudoku board (partially filled) could be valid but is not necessarily solva
//ble. 
// Only the filled cells need to be validated according to the mentioned rules. 
//
// The given board contain only digits 1-9 and the character '.'. 
// The given board size is always 9x9. 
// 
// Related Topics Hash Table


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board.length == 0 || board.length % 9 != 0 ||
           board[0].length == 0 || board[0].length % 9 != 0) {
            return false;
        }
        return checkValidRow(board) &&
                checkValidCol(board) &&
                checkValidSubBox(board);
    }

    private boolean checkValidRow(char[][] board) {
        int boxCount = board[0].length / 9;
        for(char[] row : board) {
            int[] nums = new int[9];
            for(char c : row) {
                if(c == '.') continue;

                int i = c - '0' - 1;
                if(nums[i] >= boxCount) {
                    return false;
                }
                nums[i] += 1;
            }
        }
        return true;
    }

    private boolean checkValidCol(char[][] board) {
        int maxrow = board.length;
        int maxcol = board[0].length;
        int boxCount = maxrow / 9;
        int row = 0;
        int col = 0;
        int[] nums = new int[9];
        while(row < maxrow && col < maxcol) {
            char c = board[row][col];
            if(c != '.') {
                int i = c - '0' - 1;
                if(nums[i] >= boxCount) {
                    return false;
                }
                nums[i] += 1;
            }

            if(row == maxrow-1) {
                row = 0;
                col++;
                nums = new int[9];
            }
            else {
                row++;
            }
        }
        return true;
    }

    private boolean checkValidSubBox(char[][] board) {
        int maxrow = board.length;
        int maxcol = board[0].length;
        int rboxCount = maxrow / 3;
        int cboxCount = maxcol / 3;
        int row = 0, col = 0;
        int rbox = 1, cbox = 1;
        int[] nums = new int[9];
        while(row < maxrow && col < maxcol) {
            char c = board[row][col];
            if(c != '.') {
                int i = c - '0' - 1;
                if(nums[i] > 0) {
                    return false;
                }
                nums[i] = 1;
            }

            if(col == cbox*3 -1) {
                if(row == rbox*3 - 1) {
                    if(cbox < cboxCount) {
                        // next col
                        row = (rbox - 1) * 3;
                        col = (++cbox - 1) * 3;
                    }
                    else if(rbox < rboxCount) {
                        // next row
                        row = (++rbox - 1) * 3;
                        col = 0;
                        cbox = 1;
                    }
                    else {
                        break;
                    }
                    nums = new int[9];
                }
                else {
                    col = (cbox - 1) * 3;
                    row++;
                }
            }
            else {
                col++;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
