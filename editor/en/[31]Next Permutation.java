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


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        int totalStep = this.factorial(nums.length);
        int step = 0;
        int fixed = 0;
        int len = nums.length;
        for(int i = 0; i < len-1; i++) {
            int pos = i+1;
            int remain = len - pos;
            int f = this.factorial(remain);
            int p = this.currentPos(nums, i);
            if(p < remain) {
                fixed = i;
            }
            step += f * p;
        }

        if(step + 1 == totalStep) {
            Arrays.sort(nums);
            return;
        }
        else {
            this.rearrange(nums, fixed);
        }
    }

    private int factorial(int n) {
        if(n == 1) {
            return 1;
        }
        return n * this.factorial(n - 1);
    }

    private int currentPos(int[] nums, int i) {
        int[] remain = Arrays.copyOfRange(nums, i, nums.length);
        Arrays.sort(remain);
        for(int n = 0; n < remain.length; n++) {
            if(remain[n] == nums[i]) {
                return n;
            }
        }
        return -1;
    }

    private void rearrange(int[] nums, int i) {
        int[] remain = Arrays.copyOfRange(nums, i, nums.length);
        TreeSet<Integer> tree = new TreeSet<>(Arrays.stream(remain).boxed().collect(Collectors.toList()));
        int p = 0;
        Arrays.sort(remain);
        while(!tree.isEmpty()) {
            if(nums[i] == tree.pollFirst()) {
                if(tree.isEmpty()) {
                    Arrays.sort(nums);
                    return;
                }
                nums[i] = tree.pollFirst();
                break;
            }
        }
        int fixed = i;
        for(int n = 0; n < remain.length; n++) {
            if(nums[fixed] == remain[n]) {
                continue;
            }
            nums[++i] = remain[n];
            if(i == nums.length-1) {
                break;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
