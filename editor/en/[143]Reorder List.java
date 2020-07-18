//Given a singly linked list L: L0→L1→…→Ln-1→Ln, 
//reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// You may not modify the values in the list's nodes, only nodes itself may be c
//hanged. 
//
// Example 1: 
//
// 
//Given 1->2->3->4, reorder it to 1->4->2->3. 
//
// Example 2: 
//
// 
//Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
// 
// Related Topics Linked List


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

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
    public void reorderList(ListNode head) {
        ListNode prev = null;
        ListNode root = head;
        ListNode node = head;
        while(node != null) {
            if(node.next == null) {
                if(prev == null) {
                    break;
                }
                prev.next = null;
                node.next = root.next;
                root.next = node;
                // new loop, next
                root = node.next;
                node = root;

                if(root == null) {
                    break;
                }
            }
            prev = node;
            node = node.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
