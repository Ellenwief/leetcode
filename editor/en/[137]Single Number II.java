//Given a non-empty array of integers, every element appears three times except 
//for one, which appears exactly once. Find that single one. 
//
// Note: 
//
// Your algorithm should have a linear runtime complexity. Could you implement i
//t without using extra memory? 
//
// Example 1: 
//
// 
//Input: [2,2,3,2]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: [0,1,0,1,0,1,99]
//Output: 99 
// Related Topics Bit Manipulation 
// 👍 1775 👎 348


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            int count = map.getOrDefault(i, 0);
            if(++count == 3) {
                map.remove(i);
            }
            else {
                map.put(i, count);
            }
        }
        return map.keySet().iterator().next();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
