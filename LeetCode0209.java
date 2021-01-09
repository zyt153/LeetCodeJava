/* Minimum Size Subarray Sum
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * */

public class LeetCode0209 {
    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(s, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0)
            return 0;

        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int subSum = 0;
        for (int i = 0; i < nums.length; i++) {
            subSum += nums[i];
            while (subSum >= s) {
                minLen = Math.min(minLen, i + 1 - left);
                subSum -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
