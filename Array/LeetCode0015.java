/* 3Sum
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:[ [-1, 0, 1], [-1, -1, 2] ]
 * */

package Array;

import java.util.*;

public class LeetCode0015 {
    public static void main(String args[]) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet(); //set is to avoid duplicates
        if (nums.length < 3)
            return new ArrayList(res);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (nums[i] + sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if (nums[i] + sum > 0) {
                    k--;
                } else if (nums[i] + sum < 0) {
                    j++;
                }
            }
        }
        return new ArrayList(res);
    }
}
