//Design your implementation of the linked list. You can choose to use the singl
//y linked list or the doubly linked list. A node in a singly linked list should h
//ave two attributes: val and next. val is the value of the current node, and next
// is a pointer/reference to the next node. If you want to use the doubly linked l
//ist, you will need one more attribute prev to indicate the previous node in the 
//linked list. Assume all nodes in the linked list are 0-indexed. 
//
// Implement these functions in your linked list class: 
//
// 
// get(index) : Get the value of the index-th node in the linked list. If the in
//dex is invalid, return -1. 
// addAtHead(val) : Add a node of value val before the first element of the link
//ed list. After the insertion, the new node will be the first node of the linked 
//list. 
// addAtTail(val) : Append a node of value val to the last element of the linked
// list. 
// addAtIndex(index, val) : Add a node of value val before the index-th node in 
//the linked list. If index equals to the length of linked list, the node will be 
//appended to the end of linked list. If index is greater than the length, the nod
//e will not be inserted. 
// deleteAtIndex(index) : Delete the index-th node in the linked list, if the in
//dex is valid. 
// 
//
// 
//
// Example: 
//
// 
//Input: 
//["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","ge
//t"]
//[[],[1],[3],[1,2],[1],[1],[1]]
//Output:  
//[null,null,null,null,2,null,3]
//
//Explanation:
//MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
//linkedList.get(1);            // returns 2
//linkedList.deleteAtIndex(1);  // now the linked list is 1->3
//linkedList.get(1);            // returns 3
// 
//
// 
// Constraints: 
//
// 
// 0 <= index,val <= 1000 
// Please do not use the built-in LinkedList library. 
// At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and 
//deleteAtIndex. 
// 
// Related Topics Linked List Design


//leetcode submit region begin(Prohibit modification and deletion)
class MyLinkedList {
    List<Integer> list;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.list = new ArrayList<>();
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < this.list.size()) {
            return this.list.get(index);
        }
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        this.list.add(0, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        this.list.add(val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < this.list.size()) {
            this.list.add(index, val);
        }
        else {
            this.list.add(val);
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < this.list.size()) {
            this.list.remove(index);
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)
