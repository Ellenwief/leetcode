//Given a string, determine if it is a palindrome, considering only alphanumeric
// characters and ignoring cases. 
//
// Note: For the purpose of this problem, we define empty string as valid palind
//rome. 
//
// Example 1: 
//
// 
//Input: "A man, a plan, a canal: Panama"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "race a car"
//Output: false
// 
// Related Topics Two Pointers String


import javax.swing.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        String palindrome = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int len = palindrome.length();
        for(int i = 0; i < len/2; i++) {
            if(palindrome.charAt(i) != palindrome.charAt(len - i - 1)) {
                System.out.println("i: "+ palindrome.charAt(i) +", last: "+ palindrome.charAt(len - i - 1));
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
