/* Longest Increasing Subsequence
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * */

import java.util.Arrays;

public class LeetCode0300 {
    public static void main(String args[]) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

    //DP
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        int[] maxLength = new int[nums.length];
        ;
        maxLength[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    max = Math.max(max, maxLength[j]);
            }
            maxLength[i] = max + 1;
            res = Math.max(maxLength[i], res);
        }
        return res;
    }

    //DP with Binary Search
    public static int lengthOfLISII(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
