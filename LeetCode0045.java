/* Jump Game II
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * */

import java.util.Map;

public class LeetCode0045 {
    public static void main(String args[]) {
        int[] nums = {2, 3, 0, 1, 4, 1};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        // DP Solution: O(n^2)
        /*int length = nums.length;
        if(length <= 1)
            return 0;

        int dp[] = new int[length];     // Store the minimum steps to arrive ith position
        dp[0] = 0;
        for (int i = 1; i < length; i++)
            dp[i] = Integer.MAX_VALUE;

        for (int i = 0;i < length; i++){
            if (i + nums[i] >= length - 1)
                return dp[i] + 1;
            for (int j = i + 1; j <= i + nums[i]; j++){
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[length - 1];*/

        // Greedy Solution: O(n)
        int length = nums.length;
        if (length <= 1)
            return 0;

        int end = 0;
        int steps = 0;
        int maxPosition = 0;        // 当前能够到达的最大下标位置
        for (int i = 0; i < length; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (maxPosition >= length - 1)
                return steps + 1;
            if (i == end) {
                end = maxPosition;
                steps += 1;
            }
        }
        return steps;
    }
}
