/* Partition Equal Subset Sum
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * */

public class LeetCode0416 {
    public static void main(String args[]) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;

        sum = sum / 2;
        int n = nums.length;
        //dp[i][j]=true表示j可以用nums[0]~nums[i]中的数字之和表示
        boolean dp[][] = new boolean[n + 1][sum + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            int curr = nums[i - 1];
            for (int j = 0; j <= sum; j++) {
                //dp[i][j]在两种情况下为真：
                //(1) j can be formed without including i th element
                //(2) j can be formed including i th element
                if (j < curr)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || (dp[i - 1][j - curr]);
            }
        }

        //如果sum/2可以用子集元素之和表示，那剩下的元素组成另外sum/2
        return dp[n][sum];
    }
}
