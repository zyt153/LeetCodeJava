/* Longest Consecutive Sequence
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * */

import java.util.*;

public class LeetCode0239 {
    public static void main(String args[]) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        for (int num : res)
            System.out.print(num + ",");
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0)
            return new int[0];

        int[] output = new int[n - k + 1];
        /* Use heap: Time Limit Exceeded
        Queue<Integer> maxheap = new PriorityQueue<>((n1, n2) -> n2 - n1);

        for (int i = 0; i < k; i++)
            maxheap.add(nums[i]);

        for (int i = 0; i < output.length; i++) {
            output[i] = maxheap.peek();
            maxheap.remove(nums[i]);
            if (i + k < nums.length)
                maxheap.offer(nums[i + k]);
        }
        return output;
        */

        // Use deque
        int j = 0;
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i])
                q.removeLast();
            q.addLast(i);

            if (q.getFirst() == i - k)
                q.removeFirst();

            if(i >= k - 1){
                output[j] = nums[q.getFirst()];
                j += 1;
            }
        }
        return output;
    }
}
