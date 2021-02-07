/* 3Sum Closest
 * Example:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * */

package Array;

import java.util.Arrays;

public class LeetCode0016 {
    public static void main(String args[]) {
        int[] nums = {1,2,4,8,16,32,64,128};
        int target = 82;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (nums[i] + sum >= target) {
                    if (Math.abs(target - (nums[i] + sum)) < Math.abs(minDiff))
                        minDiff = target - (nums[i] + sum);
                    k--;
                } else {
                    if (Math.abs(target - (nums[i] + sum)) < Math.abs(minDiff))
                        minDiff = target - (nums[i] + sum);
                    j++;
                }
            }
        }

        return target - minDiff;
    }
}
