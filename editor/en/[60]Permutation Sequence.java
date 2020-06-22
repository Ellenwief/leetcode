//The set [1,2,3,...,n] contains a total of n! unique permutations. 
//
// By listing and labeling all of the permutations in order, we get the followin
//g sequence for n = 3: 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// Given n and k, return the kth permutation sequence. 
//
// Note: 
//
// 
// Given n will be between 1 and 9 inclusive. 
// Given k will be between 1 and n! inclusive. 
// 
//
// Example 1: 
//
// 
//Input: n = 3, k = 3
//Output: "213"
// 
//
// Example 2: 
//
// 
//Input: n = 4, k = 9
//Output: "2314"
// 
// Related Topics Math Backtracking


import java.util.Arrays;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getPermutation(int n, int k) {
        int[] nums = this.generateNums(n);
        int step = 0;
        while(++step < k && this.hasNextPermutation(nums));

        return Arrays.stream(nums)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private int[] generateNums(int n) {
        int[] nums = new int[n];
        for(int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }
        return nums;
    }

    private boolean hasNextPermutation(int[] nums) {
        int start = 0;
        int last = nums.length-1;
        if(start >= last) {
            return false;
        }

        int i = last;
        while(true) {
            int ii = i--;
            if(nums[i] < nums[ii]) {
                int j = last;
                while(nums[i] >= nums[j]) {
                    if(--j <= 0) break;
                }
                swap(nums, i, j);
                reverse(nums, ii, last);
                return true;
            }
            if(i == start) {
                reverse(nums, start, last);
                return false;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int last) {
        for(int i = start; i < last; i++) {
            for(int j = start; j < last; j++) {
                if(nums[j] > nums[j+1]) {
                    this.swap(nums, j, j+1);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
