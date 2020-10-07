/* Climbing Stairs
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps
 * */

public class LeetCode0070 {
    public static void main(String args[]) {
        int n = 45;
        System.out.println(climbStairs(n));
        System.out.println(climbStairs1(n));
    }

    public static int climbStairs(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else
            return climbStairs(n - 1) + climbStairs(n - 2);
    }

    //Fibonacci Number
    public static int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
