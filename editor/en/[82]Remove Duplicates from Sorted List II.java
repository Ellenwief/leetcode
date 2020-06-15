//Given a sorted linked list, delete all nodes that have duplicate numbers, leav
//ing only distinct numbers from the original list. 
//
// Return the linked list sorted as well. 
//
// Example 1: 
//
// 
//Input: 1->2->3->3->4->4->5
//Output: 1->2->5
// 
//
// Example 2: 
//
// 
//Input: 1->1->1->2->3
//Output: 2->3
// 
// Related Topics Linked List


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

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
    public ListNode deleteDuplicates(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode root = null;
        ListNode prev = null;
        ListNode removed = null;
        ListNode node = head;

        while(node != null) {
            if(!list.contains(node.val)) {
                if(root == null) {
                    root = new ListNode(node.val);
                    removed = root;
                }
                else {
                    prev = removed;
                    removed.next = new ListNode(node.val);
                    removed = removed.next;
                }
                list.add(node.val);
            }
            else if(root != null && root.val == node.val) {
                root = removed = prev = null;
            }
            else if(removed != null && removed.val == node.val) {
                prev.next = null;
                removed = prev;
            }
            node = node.next;
        }

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
