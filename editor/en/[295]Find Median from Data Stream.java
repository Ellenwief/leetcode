//Median is the middle value in an ordered integer list. If the size of the list
// is even, there is no middle value. So the median is the mean of the two middle 
//value. 
//For example,
//
// [2,3,4], the median is 3 
//
// [2,3], the median is (2 + 3) / 2 = 2.5 
//
// Design a data structure that supports the following two operations: 
//
// 
// void addNum(int num) - Add a integer number from the data stream to the data 
//structure. 
// double findMedian() - Return the median of all elements so far. 
// 
//
// 
//
// Example: 
//
// 
//addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2
// 
//
// 
//
// Follow up: 
//
// 
// If all integer numbers from the stream are between 0 and 100, how would you o
//ptimize it? 
// If 99% of all integer numbers from the stream are between 0 and 100, how woul
//d you optimize it? 
// 
// Related Topics Heap Design


import java.util.ArrayList;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    /** initialize your data structure here. */
    public MedianFinder() {
        this.left = new PriorityQueue<>();
        this.right = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
    }
    
    public void addNum(int num) {
        this.right.offer(num);
        this.left.offer(this.right.poll());

        if(this.right.size() < this.left.size()) {
            this.right.offer(this.left.poll());
        }
    }
    
    public double findMedian() {
        if(this.left.size() == this.right.size()) {
            return (this.left.peek() + this.right.peek()) / 2d;
        }

        return this.right.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
