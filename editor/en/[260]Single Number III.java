//Given an array of numbers nums, in which exactly two elements appear only once
// and all the other elements appear exactly twice. Find the two elements that app
//ear only once. 
//
// Example: 
//
// 
//Input:  [1,2,1,3,2,5]
//Output: [3,5] 
//
// Note: 
//
// 
// The order of the result is not important. So in the above example, [5, 3] is 
//also correct. 
// Your algorithm should run in linear runtime complexity. Could you implement i
//t using only constant space complexity? 
// Related Topics Bit Manipulation


import java.util.ArrayList;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums) {
            if(list.contains(num)) {
                list.remove(new Integer(num));
            }
            else {
                list.add(num);
            }
        }

        int[] newNums = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            newNums[i] = list.get(i);
        }
        return newNums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
