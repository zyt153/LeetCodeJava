/* Subsets
 * Example:
 * Input: nums = [1,2,3]
 * Output:[[3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], []]
 * */

package Array;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0078 {
    public static void main(String args[]) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> current = new ArrayList<Integer>();
        generateSubsets(0, nums, current, subsets);
        return subsets;
    }

    public static void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(i + 1, nums, current, subsets);
            current.remove(current.size() - 1);
        }
    }
}
