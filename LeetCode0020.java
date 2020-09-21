/* * Valid Parentheses
 * Example:
 * Input: s = "{[]}"
 * Output: true
 * */

import java.util.HashMap;
import java.util.Stack;

public class LeetCode0020 {
    public static void main(String args[]) {
        String s = "]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        //根据括号构建哈希表
        HashMap<Character, Character> hMap = new HashMap<Character, Character>();
        hMap.put(')', '(');
        hMap.put(']', '[');
        hMap.put('}', '{');

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hMap.containsKey(c)) {
                char top = stack.empty() ? '#' : stack.peek();
                if (top == hMap.get(c))
                    stack.pop();
                else
                    return false;
            } else
                stack.push(c);
        }
        return stack.empty();
    }
}
