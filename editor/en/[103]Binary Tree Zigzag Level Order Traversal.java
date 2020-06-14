//Given a binary tree, return the zigzag level order traversal of its nodes' val
//ues. (ie, from left to right, then right to left for the next level and alternat
//e between). 
//
// 
//For example: 
//Given binary tree [3,9,20,null,null,15,7], 
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 
// 
//return its zigzag level order traversal as: 
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics Stack Tree Breadth-first Search


//leetcode submit region begin(Prohibit modification and deletion)
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        insert(root, 1, false, list);
        return list;
    }

    private void insert(TreeNode node, int depth, boolean flip, List<List<Integer>> list) {
        if(node == null) {
            return;
        }
        if(list.size() < depth) {
            list.add(new ArrayList<Integer>());
        }

        if(flip) {
            list.get(depth-1).add(0, node.val);
        }
        else {
            list.get(depth-1).add(node.val);
        }

        insert(node.left, depth+1, !flip, list);
        insert(node.right, depth+1, !flip, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
