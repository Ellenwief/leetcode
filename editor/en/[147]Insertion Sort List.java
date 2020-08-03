//Sort a linked list using insertion sort. 
//
// 
// 
//
// 
//A graphical example of insertion sort. The partial sorted list (black) initial
//ly contains only the first element in the list. 
//With each iteration one element (red) is removed from the input data and inser
//ted in-place into the sorted list 
// 
//
// 
// 
//
// Algorithm of Insertion Sort: 
//
// 
// Insertion sort iterates, consuming one input element each repetition, and gro
//wing a sorted output list. 
// At each iteration, insertion sort removes one element from the input data, fi
//nds the location it belongs within the sorted list, and inserts it there. 
// It repeats until no input elements remain. 
// 
//
// 
//Example 1: 
//
// 
//Input: 4->2->1->3
//Output: 1->2->3->4
// 
//
// Example 2: 
//
// 
//Input: -1->5->3->4->0
//Output: -1->0->3->4->5
// 
// Related Topics Linked List Sort 
// 👍 637 👎 588


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
    public ListNode insertionSortList(ListNode head) {
        ListNode root = head;
        ListNode node = head;
        while(node != null && node.next != null) {
            ListNode next = node.next;
            if(next.val < node.val) {
                node.next = next.next;
                root = this.sort(root, next);
            }
            node = next;
        }
        return root;
    }

    private ListNode sort(ListNode root, ListNode target) {
        if(target.val < root.val) {
            target.next = root;
            return target;
        }
        ListNode prev = root;
        ListNode node = root.next;
        while(node != null) {
            if(target.val < node.val) {
                prev.next = target;
                target.next = node;
                break;
            }
            prev = node;
            node = node.next;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
