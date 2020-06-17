//Given a collection of candidate numbers (candidates) and a target number (targ
//et), find all unique combinations in candidates where the candidate numbers sums
// to target. 
//
// Each number in candidates may only be used once in the combination. 
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
//Input: candidates = [10,1,2,7,6,1,5], target = 8,
//A solution set is:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5,
//A solution set is:
//[
//  [1,2,2],
//  [5]
//]
// 
// Related Topics Array Backtracking


import com.sun.deploy.panel.CacheSettingsDialog;

import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            return;
        }
        for(int i = 0; i < cand.length; i++) {
            int peek = cand[i];
            int[] newCand = new int[cand.length-1];
            System.arraycopy(cand, 0, newCand, 0, i);
            System.arraycopy(cand, i+1, newCand, i, newCand.length - i);
            Integer[] newNums = Arrays.copyOf(nums, nums.length+1);
            newNums[nums.length] = peek;
            findAll(list, newCand, target, sum + peek, newNums);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
