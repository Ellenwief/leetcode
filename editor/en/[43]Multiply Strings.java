//Given two non-negative integers num1 and num2 represented as strings, return t
//he product of num1 and num2, also represented as a string. 
//
// Example 1: 
//
// 
//Input: num1 = "2", num2 = "3"
//Output: "6" 
//
// Example 2: 
//
// 
//Input: num1 = "123", num2 = "456"
//Output: "56088"
// 
//
// Note: 
//
// 
// The length of both num1 and num2 is < 110. 
// Both num1 and num2 contain only digits 0-9. 
// Both num1 and num2 do not contain any leading zero, except the number 0 itsel
//f. 
// You must not use any built-in BigInteger library or convert the inputs to int
//eger directly. 
// 
// Related Topics Math String


import java.util.Arrays;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
// *. Karatsuba algorithm 참고
// *. https://en.wikipedia.org/wiki/Karatsuba_algorithm
class Solution {
    public String multiply(String num1, String num2) {
        int[] product = new int[num1.length() + num2.length()];
        int base = 10;
        int n = 0;
        int p = num1.length();

        for(int i = num2.length()-1; i >= 0; i--) {
            int carry = 0;
            int m = 0;
            for(int j = num1.length()-1; j >= 0; j--) {
                int a = num1.charAt(j) - '0';
                int b = num2.charAt(i) - '0';
                int idx = n + m;
                product[idx] += carry + a*b;
                carry = product[idx] / base;
                product[idx] = product[idx] % base;
                m++;
            }
            product[n+p] = carry;
            n++;
        }

        String result = "";
        for(int i = product.length-1; i >= 0; i--) {
            result += product[i];
        }
        result = result.replaceAll("^0*", "");
        if(result.length() == 0) {
            return "0";
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
