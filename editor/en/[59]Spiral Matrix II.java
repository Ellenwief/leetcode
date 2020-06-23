//Given a positive integer n, generate a square matrix filled with elements from
// 1 to n2 in spiral order. 
//
// Example: 
//
// 
//Input: 3
//Output:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
// 
// Related Topics Array


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int row = 0;
        int col = 0;
        int num = 1;
        int depth = 1;
        int maxNum = n * n;
        Direction dir = Direction.top;

        while(num <= maxNum) {
            matrix[row][col] = num++;

            switch(dir) {
                case top:
                    if(col < n-depth) {
                        col++;
                    }
                    else {
                        row++;
                        dir = Direction.right;
                    }
                    break;

                case right:
                    if(row < n-depth) {
                        row++;
                    }
                    else {
                        col--;
                        dir = Direction.bottom;
                    }
                    break;

                case bottom:
                    if(col >= depth) {
                        col--;
                    }
                    else {
                        row--;
                        dir = Direction.left;
                    }
                    break;

                case left:
                    if(row > depth) {
                        row--;
                    }
                    else {
                        col++;
                        depth++;
                        dir = Direction.top;
                    }
                    break;
            }
        }

        return matrix;
    }

    private static enum Direction {
        top, bottom, right, left
    }
}
//leetcode submit region end(Prohibit modification and deletion)
