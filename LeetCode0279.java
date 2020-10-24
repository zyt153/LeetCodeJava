/* Perfect Squares
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * */

public class LeetCode0279 {
    public static void main(String args[]) {
        int n = 13;
        System.out.println(numSquares(n));
    }

    public static int numSquares(int n) {
        if (n <= 3)
            return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = n;      //Max value
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}
