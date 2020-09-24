/* Daily Temperatures
 * Example:
 * Input: T = [73, 74, 75, 71, 69, 72, 76, 73]
 * Output: [1, 1, 4, 2, 1, 1, 0, 0]
 * */

import java.util.Stack;

public class LeetCode0739 {
    public static void main(String args[]){
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(T);
        for(int i = 0; i< res.length; i++)
            System.out.println(res[i]);
    }

    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < T.length; i++){
            while(!stack.empty() && T[i] > T[stack.peek()])
                result[stack.peek()] = i - stack.pop();
            stack.push(i);
        }
        return result;
    }
}
