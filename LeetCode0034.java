/* Find First and Last Position of Element in Sorted Array
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * */

package Array;

import java.util.Arrays;

public class LeetCode0034 {
    public static void main(String args[]) {
        int[] nums = {1};
        //int[] nums = new int[0];
        int target = 0;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0)
            return res;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int c = (r + l) / 2;
            if (nums[c] >= target) {
                r = c;
            } else {
                l = c + 1;
            }
        }
        if (nums[l] != target)
            return res;
        if (nums.length == 1)
            return new int[]{l, l};
        res[0] = l;

        r = nums.length - 1;
        while (l <= r) {
            int c = (r + l) / 2;
            if (nums[c] > target) {
                r = c - 1;
            } else {
                l = c + 1;
            }
        }
        res[1] = l - 1;
        return res;
    }
}
