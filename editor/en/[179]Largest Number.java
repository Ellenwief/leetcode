//Given a list of non negative integers, arrange them such that they form the la
//rgest number. 
//
// Example 1: 
//
// 
//Input: [10,2]
//Output: "210" 
//
// Example 2: 
//
// 
//Input: [3,30,34,5,9]
//Output: "9534330"
// 
//
// Note: The result may be very large, so you need to return a string instead of
// an integer. 
// Related Topics Sort


import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        String result = Arrays.stream(nums)
                .boxed()
                .sorted((n1, n2) -> {
                    String s1 = String.valueOf(n1);
                    String s2 = String.valueOf(n2);
                    return (s2 + s1).compareTo(s1 + s2);
                })
                .map(String::valueOf)
                .collect(Collectors.joining());

        result = result.replaceAll("^0+", "");
        if(result.length() == 0) {
            return "0";
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
