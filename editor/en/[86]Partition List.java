//Given a linked list and a value x, partition it such that all nodes less than 
//x come before nodes greater than or equal to x. 
//
// You should preserve the original relative order of the nodes in each of the t
//wo partitions. 
//
// Example: 
//
// 
//Input: head = 1->4->3->2->5->2, x = 3
//Output: 1->2->2->4->3->5
// 
// Related Topics Linked List Two Pointers


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = null, leftHead = null;
        ListNode right = null, rightHead = null;
        ListNode node = head;

        while(node != null) {
            if(node.val < x) {
                if(left == null) {
                    left = new ListNode(node.val);
                    leftHead = left;
                }
                else {
                    left.next = new ListNode(node.val);
                    left = left.next;
                }
            }
            else {
                if(right == null) {
                    right = new ListNode(node.val);
                    rightHead = right;
                }
                else {
                    right.next = new ListNode(node.val);
                    right = right.next;
                }
            }
            node = node.next;
        }

        if(leftHead != null) {
            left.next = rightHead;
            return leftHead;
        }

        return rightHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
