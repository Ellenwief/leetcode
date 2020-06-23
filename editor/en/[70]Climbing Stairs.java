//You are climbing a stair case. It takes n steps to reach to the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top? 
//
// Note: Given n will be a positive integer. 
//
// Example 1: 
//
// 
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
// Related Topics Dynamic Programming


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        int[] nums = new int[n+1];
        return findSumTarget(0, n, nums);
    }

    private int findSumTarget(int sum, int target, int[] nums) {
        if(sum > target) {
            return 0;
        }
        else if(sum == target) {
            return 1;
        }
        else if(nums[sum] > 0) {
            return nums[sum];
        }

        nums[sum] = findSumTarget(sum + 1, target, nums) + findSumTarget(sum + 2, target, nums);
        return nums[sum];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
