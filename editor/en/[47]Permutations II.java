//Given a collection of numbers that might contain duplicates, return all possib
//le unique permutations. 
//
// Example: 
//
// 
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// 
// Related Topics Backtracking


import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        findAllPermutations(nums, nums.length, list);
        return list;
    }

    private void findAllPermutations(int[] nums, int len, List<List<Integer>> list) {
        if(len == 1) {
            addPermutation(nums, list);
            return;
        }

        for(int i = 0; i < len; i++) {
            findAllPermutations(nums, len-1, list);
            addPermutation(nums, list);

            if(i < len-1) {
                if(len % 2 == 1) {
                    swap(nums, 0, len-1);
                }
                else {
                    swap(nums, i, len-1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void addPermutation(int[] nums, List<List<Integer>> list) {
        List<Integer> permutation = Arrays.stream(nums).boxed().collect(Collectors.toList());
        if(!list.contains(permutation)) {
            list.add(permutation);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
