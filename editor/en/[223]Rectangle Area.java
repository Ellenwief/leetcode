//Find the total area covered by two rectilinear rectangles in a 2D plane. 
//
// Each rectangle is defined by its bottom left corner and top right corner as s
//hown in the figure. 
//
// 
//
// Example: 
//
// 
//Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
//Output: 45 
//
// Note: 
//
// Assume that the total area is never beyond the maximum possible value of int.
// 
// Related Topics Math


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int[] rect1 = new int[]{Math.min(A, C), Math.min(B, D), Math.max(A, C), Math.max(B, D)};
        int[] rect2 = new int[]{Math.min(E, G), Math.min(F, H), Math.max(E, G), Math.max(F, H)};
        int[] rect3 = new int[]{Math.max(rect1[0], rect2[0]), Math.max(rect1[1], rect2[1]), Math.min(rect1[2], rect2[2]), Math.min(rect1[3], rect2[3])};
        int area = Math.abs(rect1[0] - rect1[2]) * Math.abs(rect1[1] - rect1[3]) +
                Math.abs(rect2[0] - rect2[2]) * Math.abs(rect2[1] - rect2[3]);

        if(rect3[0] < rect3[2] && rect3[1] < rect3[3]) {
            int dup = Math.abs(rect3[0] - rect3[2]) * Math.abs(rect3[1] - rect3[3]);
            return area - dup;
        }

        return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
