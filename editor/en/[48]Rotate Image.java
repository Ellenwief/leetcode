//You are given an n x n 2D matrix representing an image. 
//
// Rotate the image by 90 degrees (clockwise). 
//
// Note: 
//
// You have to rotate the image in-place, which means you have to modify the inp
//ut 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation. 
//
// Example 1: 
//
// 
//Given input matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//rotate the input matrix in-place such that it becomes:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// Example 2: 
//
// 
//Given input matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//rotate the input matrix in-place such that it becomes:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics Array


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        int maxLine = matrix.length / 2;
        for(int i = 0; i < maxLine; i++) {
            this.rotateLine(matrix, i);
        }
    }

    private static enum Direction {
        top, bottom, right, left
    }

    private void rotateLine(int[][] matrix, int line) {
        int len = matrix.length;
        int size = len - line*2;
        if(size <= 0) {
            return;
        }
        int[] temp = new int[size];
        int[] temp2 = new int[size];
        int swap = 0;
        int col = 0;
        // top -> right
        this.backupMatData(matrix, temp2, line, Direction.top);
        this.backupMatData(matrix, temp, line, Direction.right);
        this.inputMatData(matrix, temp2, line, Direction.right);
        // right -> bottom
        this.backupMatData(matrix, temp2, line, Direction.bottom);
        this.inputMatData(matrix, temp, line, Direction.bottom);
        // bottom -> left
        this.restoreEdge(temp2, temp, Direction.bottom);
        this.backupMatData(matrix, temp, line, Direction.left);
        this.inputMatData(matrix, temp2, line, Direction.left);
        // left -> top
        this.restoreEdge(temp, temp2, Direction.left);
        this.inputMatData(matrix, temp, line, Direction.top);
    }

    private void backupMatData(int[][] matrix, int[] temp, int line, Direction dir) {
        int max = matrix.length - line - 1;
        switch(dir) {
            case top:
            case bottom: {
                int row = dir == Direction.top? line : max;
                for(int i = 0, col = line; col <= max; col++) {
                    temp[i++] = matrix[row][col];
                }
                break;
            }
            case left:
            case right: {
                int col = dir == Direction.left? line : max;
                for(int i = 0, row = max; row >= line; row--) {
                    temp[i++] = matrix[row][col];
                }
                break;
            }
        }
    }

    private void inputMatData(int[][] matrix, int[] inp, int line, Direction dir) {
        int max = matrix.length - line - 1;
        switch(dir) {
            case top:
            case bottom: {
                int row = dir == Direction.top? line : max;
                for(int i = 0, col = line; col <= max; col++) {
                    matrix[row][col] = inp[i++];
                }
                break;
            }
            case left:
            case right: {
                int col = dir == Direction.left? line : max;
                for(int i = 0, row = line; row <= max; row++) {
                    matrix[row][col] = inp[i++];
                }
                break;
            }
        }
    }

    private void restoreEdge(int[] src, int[] ref, Direction dir) {
        switch(dir) {
            case top:
                break;
            case bottom:
                src[src.length-1] = ref[0];
                break;
            case left:
                src[0] = ref[0];
                break;
            case right:
                break;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
