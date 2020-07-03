//Given a binary tree, flatten it to a linked list in-place. 
//
// For example, given the following tree: 
//
// 
//    1
//   / \
//  2   5
// / \   \
//3   4   6
// 
//
// The flattened tree should look like: 
//
// 
//1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
// 
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
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        flatten(root, list);

        TreeNode next = null;
        for(TreeNode node : list) {
            if(root == node) {
                root.left = null;
                next = root;
            }
            else {
                next.right = node;
                next.left = null;
                next = node;
            }
        }
    }

    private void flatten(TreeNode node, List<TreeNode> list) {
        if(node == null) {
            return;
        }

        list.add(node);

        flatten(node.left, list);
        flatten(node.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
