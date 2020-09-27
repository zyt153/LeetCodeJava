/* Largest Rectangle in Histogram
 * Example:
 * Input: [2,1,5,6,2,3]
 * Output: 10
 * */

import java.util.Stack;

public class LeetCode0084 {
    public static void main(String args[]) {
        int[] height = {2, 1, 5, 6, 4, 3};
        System.out.println(largestRectangleArea(height));
    }

    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        //单调递增栈
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < len; ++i) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = i - stack.peek() - 1;
                max = Math.max(max, w * h);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int h = heights[stack.pop()];
            int w = len - stack.peek() - 1;
            max = Math.max(max, w * h);
        }
        return max;
    }
}
