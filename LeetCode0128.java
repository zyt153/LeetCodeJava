/* Longest Consecutive Sequence
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * */

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode0128 {
    public static void main(String args[]) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        /* Use sort： O(nlogn)
        Arrays.sort(nums);

        int longest = 1;
        int current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    current += 1;
                } else {
                    longest = Math.max(longest, current);
                    current = 1;
                }
            }
        }
        return Math.max(longest, current);*/

        //Use hashset: O(n)
        Set<Integer> hashset = new HashSet<>();
        for (int num : nums)
            hashset.add(num);

        int longest = 1;
        int current = 1;

        for (int i = 0; i < nums.length; i++) {
            current = 1;
            if (!hashset.contains(nums[i] - 1)) {
                int currentNum = nums[i];

                while (hashset.contains(currentNum + 1)) {
                    currentNum += 1;
                    current += 1;
                }
            }
            longest = Math.max(longest, current);
        }
        return Math.max(longest, current);
    }
}
