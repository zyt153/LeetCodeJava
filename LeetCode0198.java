/* House Robber
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Total amount you can rob = 2 + 9 + 1 = 12.
 * */

public class LeetCode0198 {
    public static void main(String args[]) {
        int[] nums = {100, 1, 1, 100};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        else {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++)
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            return dp[nums.length - 1];
        }
    }
}
