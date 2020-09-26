/* Decode String
 * Example:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode0394 {
    public static void main(String args[]) {
        String s = "3[a10[c]]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']')
                stack.push(s.charAt(i));
            else {
                List<Character> decode = new ArrayList();
                while (stack.peek() != '[')
                    decode.add(stack.pop());
                stack.pop();

                int k = 0;
                int b = 1;
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    k = k + (stack.pop() - '0') * b;
                    b *= 10;
                }

                while (k > 0) {
                    for (int j = decode.size() - 1; j >= 0; j--)
                        stack.push(decode.get(j));
                    k --;
                }
            }
        }

        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }
}
