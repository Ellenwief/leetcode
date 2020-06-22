//Implement next permutation, which rearranges numbers into the lexicographicall
//y next greater permutation of numbers. 
//
// If such arrangement is not possible, it must rearrange it as the lowest possi
//ble order (ie, sorted in ascending order). 
//
// The replacement must be in-place and use only constant extra memory. 
//
// Here are some examples. Inputs are in the left-hand column and its correspond
//ing outputs are in the right-hand column. 
//
// 1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics Array


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        rearrangeNextPermutation(nums, 0, nums.length-1);
    }

    private boolean rearrangeNextPermutation(int[] nums, int start, int last) {
        if(start == last) {
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

    private void swap(int[] nums, int src, int dest) {
        int temp = nums[src];
        nums[src] = nums[dest];
        nums[dest] = temp;
    }

    private void reverse(int[] nums, int src, int dest) {
        for(int i = src; i < dest; i++) {
            for(int j = src; j < dest; j++) {
                if(nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
