//Given a binary tree, return all root-to-leaf paths. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// 
//Input:
//
//   1
// /   \
//2     3
// \
//  5
//
//Output: ["1->2->5", "1->3"]
//
//Explanation: All root-to-leaf paths are: 1->2->5, 1->3
// Related Topics Tree Depth-first Search


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        this.insert(root, "", paths);
        return paths;
    }

    private void insert(TreeNode node, String path, List<String> paths) {
        if(node == null) return;
        String currentPath = path.length() > 0? path +"->"+ node.val : String.valueOf(node.val);
        if(node.left == null && node.right == null) {
            paths.add(currentPath);
            return;
        }

        this.insert(node.left, currentPath, paths);
        this.insert(node.right, currentPath, paths);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
