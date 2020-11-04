/* Shortest Unsorted Continuous Subarray
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * */

import java.util.Arrays;
import java.util.Stack;

public class LeetCode0581 {
    public static void main(String args[]) {
        int[] nums = {2, 1};
        System.out.println(findUnsortedSubarray(nums));
    }

    //利用stack
    public static int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int start = nums.length;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] < nums[stack.peek()])
                start = Math.min(start, stack.pop());
            stack.push(i);      //顺序正确则入栈
        }

        stack.clear();

        for (int i = nums.length - 1; i >= 0; i--) {    //反向寻找end
            while (!stack.empty() && nums[i] > nums[stack.peek()])
                end = Math.max(end, stack.pop());
            stack.push(i);      //顺序正确则入栈
        }

        return end - start > 0 ? end - start + 1 : 0;
    }

    //利用sort函数
    public static int findUnsortedSubarray_sort(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int start = nums.length;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copy[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return end - start > 0 ? end - start + 1 : 0;
    }
}
