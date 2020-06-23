//Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the previou
//s row. 
// 
//
// Example 1: 
//
// 
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//Output: false 
// Related Topics Array Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) {
            return false;
        }
        int maxrow = matrix.length;
        int maxcol = matrix[0].length;
        int row = 0;
        int col = 0;
        while(row < maxrow && col < maxcol) {
            if(target == matrix[row][col]) {
                return true;
            }
            else if(target > matrix[row][maxcol-1]) {
                row++;
            }
            else if(target > matrix[row][col]) {
                col++;
            }
            else {
                break;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
