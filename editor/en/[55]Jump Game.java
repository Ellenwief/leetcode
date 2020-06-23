//Given an array of non-negative integers, you are initially positioned at the f
//irst index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Determine if you are able to reach the last index. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jum
//p length is 0, which makes it impossible to reach the last index.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10^4 
// 0 <= nums[i][j] <= 10^5 
// 
// Related Topics Array Greedy


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        int[] indice = new int[nums.length];
        indice[nums.length-1] = 1;

        for(int i = nums.length-2; i >= 0; i--) {
            for(int j = 1; j <= nums[i]; j++) {
                int idx = i + j;
                if(idx < nums.length && indice[idx] == 1) {
                    indice[i] = 1;
                    break;
                }
            }
        }

        return indice[0] == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
