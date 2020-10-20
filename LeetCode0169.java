/* Majority Element
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * */

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode0169 {
    public static void main(String args[]) {
        int[] nums = {3, 3, 4};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (!counts.containsKey(num))
                counts.put(num, 1);
            else
                counts.put(num, counts.get(num) + 1);
        }

        int res = 0;
        for (int num : nums) {
            if (counts.get(num) > nums.length / 2)
                res = num;
        }
        return res;
    }

    //Another approach : Sorting
    public static int majorityElement_Sorting(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
