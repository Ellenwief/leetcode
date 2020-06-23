//Given a set of distinct integers, nums, return all possible subsets (the power
// set). 
//
// Note: The solution set must not contain duplicate subsets. 
//
// Example: 
//
// 
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics Array Backtracking Bit Manipulation


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++) {
            this.findAll(nums, 0, i, new ArrayList<>(), list);
        }
        return list;
    }

    private void findAll(int[] nums, int start, int last, List<Integer> l, List<List<Integer>> list) {
        if(l.size() == last) {
            list.add(new ArrayList<>(l));
        }

        for(int i = start; i < nums.length; i++) {
            l.add(nums[i]);
            this.findAll(nums, i+1, last, l, list);

            // backtrack
            l.remove(l.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
