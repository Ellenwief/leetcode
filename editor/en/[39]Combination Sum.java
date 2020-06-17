//Given a set of candidate numbers (candidates) (without duplicates) and a targe
//t number (target), find all unique combinations in candidates where the candidat
//e numbers sums to target. 
//
// The same repeated number may be chosen from candidates unlimited number of ti
//mes. 
//
// Note: 
//
// 
// All numbers (including target) will be positive integers. 
// The solution set must not contain duplicate combinations. 
// 
//
// Example 1: 
//
// 
//Input: candidates = [2,3,6,7], target = 7,
//A solution set is:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8,
//A solution set is:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
// 
// Related Topics Array Backtracking


import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        findAll(list, candidates, target, 0);
        return list;
    }

    private void findAll(List<List<Integer>> list, int[] cand, int target, int sum, Integer ...nums) {
        if(sum > target) return;
        if(target == sum) {
            List<Integer> l = Arrays.asList(nums);
            l.sort(null);
            if(!list.contains(l)) {
                list.add(l);
            }
        }
        else {
            for(int c : cand) {
                Integer[] arr = Arrays.copyOf(nums, nums.length + 1);
                arr[nums.length] = c;
                findAll(list, cand, target, sum + c, arr);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
