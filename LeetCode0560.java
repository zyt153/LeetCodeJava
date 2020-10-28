/* Subarray Sum Equals K
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * */

import java.util.HashMap;
import java.util.Map;

public class LeetCode0560 {
    public static void main(String args[]) {
        int[] nums = {0, 0, 0, 0, 0};
        int k = 0;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        //<sum, number of exists>
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (count.containsKey(sum - k))
                res += count.get(sum - k);
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
