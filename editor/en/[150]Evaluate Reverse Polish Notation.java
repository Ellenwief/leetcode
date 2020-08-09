//Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
//
// Valid operators are +, -, *, /. Each operand may be an integer or another exp
//ression. 
//
// Note: 
//
// 
// Division between two integers should truncate toward zero. 
// The given RPN expression is always valid. That means the expression would alw
//ays evaluate to a result and there won't be any divide by zero operation. 
// 
//
// Example 1: 
//
// 
//Input: ["2", "1", "+", "3", "*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9
// 
//
// Example 2: 
//
// 
//Input: ["4", "13", "5", "/", "+"]
//Output: 6
//Explanation: (4 + (13 / 5)) = 6
// 
//
// Example 3: 
//
// 
//Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//Output: 22
//Explanation: 
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22
// 
// Related Topics Stack


import javafx.scene.input.TouchEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {
        final Set<String> ops = new HashSet<String>() {{
            add("+");
            add("-");
            add("*");
            add("/");
        }};
        Stack<String> stack = new Stack<>();
        int sum = 0;
        for(String token : tokens) {
            if(ops.contains(token)) {
                char op = token.charAt(0);
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                switch(op) {
                    case '+':
                        stack.push(String.valueOf(num1 + num2));
                        break;
                    case '-':
                        stack.push(String.valueOf(num1 - num2));
                        break;
                    case '*':
                        stack.push(String.valueOf(num1 * num2));
                        break;
                    case '/':
                        stack.push(String.valueOf(num1 / num2));
                        break;
                }
            }
            else {
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
