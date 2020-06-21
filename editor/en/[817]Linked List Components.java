//We are given head, the head node of a linked list containing unique integer va
//lues. 
//
// We are also given the list G, a subset of the values in the linked list. 
//
// Return the number of connected components in G, where two values are connecte
//d if they appear consecutively in the linked list. 
//
// Example 1: 
//
// 
//Input: 
//head: 0->1->2->3
//G = [0, 1, 3]
//Output: 2
//Explanation: 
//0 and 1 are connected, so [0, 1] and [3] are the two connected components.
// 
//
// Example 2: 
//
// 
//Input: 
//head: 0->1->2->3->4
//G = [0, 3, 1, 4]
//Output: 2
//Explanation: 
//0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two
// connected components.
// 
//
// Note: 
//
// 
// If N is the length of the linked list given by head, 1 <= N <= 10000. 
// The value of each node in the linked list will be in the range [0, N - 1]. 
// 1 <= G.length <= 10000. 
// G is a subset of all values in the linked list. 
// 
// Related Topics Linked List


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
    public int numComponents(ListNode head, int[] G) {
        List<Integer> list = Arrays.stream(G).boxed().collect(Collectors.toList());;
        return count(head, list, list.size(), 0);
    }

    private int count(ListNode node, List<Integer> list, int len, int c) {
        if(node == null) {
            return c;
        }
        if(list.contains(node.val)) {
            if(list.size() == len) {
                c++;
            }
            int i = list.indexOf(node.val);
            list.remove(i);
        }
        else if(list.size() != len) {
            len = list.size();
        }
        return count(node.next, list, len, c);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
