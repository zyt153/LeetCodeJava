/* 4Sum
 * Example:
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:[  [-1,  0, 0, 1],  [-2, -1, 1, 2],  [-2,  0, 0, 2]  ]
 * */

package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode0018 {
    public static void main(String args[]) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int N = nums.length;

        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 1; j < N - 2; j++) {
                int k = j + 1;
                int l = N - 1;

                while (k < l) {

                    int sum = nums[i] + nums[j] + nums[k] + nums[l];

                    if (target == sum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        //Skip same elements

                        while (k < l && nums[k] == nums[k + 1]) k++;
                        while (k < l && nums[l] == nums[l - 1]) l--;
                        while (i < N - 3 && nums[i] == nums[i + 1]) i++;
                        while (j < N - 2 && nums[j] == nums[j + 1]) j++;

                        k++;
                        l--;

                    } else if (sum > target) {
                        l--;
                    } else {
                        k++;
                    }

                }

            }
        }
        return res;

    }
}
