/* Burst Balloons
 * Input: nums = [3,1,5,8]
 * Output: 167
 * Explanation:
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * */

public class LeetCode0312 {
    public static void main(String args[]) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(maxCoins(nums));
    }

    // https://leetcode-cn.com/problems/burst-balloons/solution/chuo-qi-qiu-dong-tai-gui-hua-wen-ti-by-lidada/
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        // 将原数组复制，补充nums[-1]=nums[n]=1
        int[] copy = new int[n + 2];
        copy[0] = 1;
        copy[n + 1] = 1;
        for (int i = 1; i <= n; i++)
            copy[i] = nums[i - 1];

        // 令dp[start][end]表示从start到end之间的气球戳破之后能得到的最大值
        // 本题就是求解dp[0][n + 1]
        int[][] dp = new int[n + 2][n + 2];
        for (int start = n + 1; start >= 0; start--) {
            for (int end = start; end <= n + 1; end++) {
                // 因为已经将前后都补全，因此如果气球数再小于三个就不戳了
                if (end - start < 2)
                    continue;
                // 递推公式：dp[start][end]=max(dp[start][i]+dp[i][end]+nums[start]*nums[i]*nums[end])
                for (int k = start + 1; k < end; k++)
                    dp[start][end] = Math.max(dp[start][end], dp[start][k] + dp[k][end] + copy[start] * copy[end] * copy[k]);
            }
        }
        return dp[0][n + 1];
    }
}
