//Given a m x n matrix, if an element is 0, set its entire row and column to 0. 
//Do it in-place. 
//
// Example 1: 
//
// 
//Input: 
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//Output: 
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// Example 2: 
//
// 
//Input: 
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//Output: 
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
//
// Follow up: 
//
// 
// A straight forward solution using O(mn) space is probably a bad idea. 
// A simple improvement uses O(m + n) space, but still not the best solution. 
// Could you devise a constant space solution? 
// 
// Related Topics Array


import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> rows = this.findRows(matrix);
        List<Integer> cols = this.findCols(matrix);
        for(Integer r : rows) {
            Arrays.fill(matrix[r], 0);
        }
        for(Integer col : cols) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }

    private List<Integer> findRows(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = 0;
        int col = 0;
        while(row < matrix.length) {
            if(matrix[row][col] == 0) {
                list.add(row);
                row++;
                col = 0;

            }
            else if(++col >= matrix[0].length) {
                row++;
                col = 0;
            }
        }
        return list;
    }

    private List<Integer> findCols(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = 0;
        int col = 0;
        while(col < matrix[0].length) {
            if(matrix[row][col] == 0) {
                list.add(col);
                col++;
                row = 0;
            }
            else if(++row >= matrix.length) {
                col++;
                row = 0;
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
