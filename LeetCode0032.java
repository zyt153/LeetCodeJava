/* Longest Valid Parentheses
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * */

import java.util.Stack;

public class LeetCode0032 {
    public static void main(String args[]) {
        String s = "()";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (stack.peek() == -1 || s.charAt(stack.peek()) == ')')
                    stack.push(i);
                else {
                    stack.pop();
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
