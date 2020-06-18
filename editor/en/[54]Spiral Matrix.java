//Given a matrix of m x n elements (m rows, n columns), return all elements of t
//he matrix in spiral order. 
//
// Example 1: 
//
// 
//Input:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
// 
//Input:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// Related Topics Array


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0) {
            return list;
        }
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        int total = maxRow * maxCol;
        int depth = 0;
        int row = 0;
        int col = 0;
        Direction dir = Direction.top;

        while(list.size() < total) {
            list.add(matrix[row][col]);

            switch(dir) {
                case top:
                    if(col == maxCol - depth - 1) {
                        dir = Direction.right;
                        row++;
                    }
                    else {
                        col++;
                        if (col == maxCol - depth - 1) {
                            dir = Direction.right;
                        }
                    }
                    break;
                case right:
                    if(row == maxRow - depth - 1) {
                        dir = Direction.bottom;
                        col--;
                    }
                    else {
                        row++;
                        if (row == maxRow - depth - 1) {
                            dir = Direction.bottom;
                        }
                    }
                    break;
                case bottom:
                    col--;
                    if(col == depth) {
                        dir = Direction.left;
                    }
                    break;
                case left:
                    row--;
                    if(row == depth) {
                        dir = Direction.top;
                        row++;
                        col++;
                        depth++;
                    }
                    break;
            }
        }
        return list;
    }

    private static enum Direction {
        top, bottom, right, left
    }
}
//leetcode submit region end(Prohibit modification and deletion)
