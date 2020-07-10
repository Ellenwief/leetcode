//The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibon
//acci sequence, such that each number is the sum of the two preceding ones, start
//ing from 0 and 1. That is, 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), for N > 1.
// 
//
// Given N, calculate F(N). 
//
// 
//
// Example 1: 
//
// 
//Input: 2
//Output: 1
//Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// Example 2: 
//
// 
//Input: 3
//Output: 2
//Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// Example 3: 
//
// 
//Input: 4
//Output: 3
//Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
//
// Note: 
//
// 0 ≤ N ≤ 30. 
// Related Topics Array


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Map<Integer, Integer> cache;

    public Solution() {
        this.cache = new HashMap<>();
    }

    public int fib(int N) {
        for(int i = 0; i <= N; i++) {
            this.fibElevation(i);
        }
        return this.cache.get(N);
    }

    private int fibElevation(int N) {
        if(cache.containsKey(N)) {
            return cache.get(N);
        }
        else if(N <= 1) {
            this.cache.put(N, N);
            return N;
        }

        int result = fibElevation(N - 1) + fibElevation(N - 2);
        this.cache.put(N, result);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
