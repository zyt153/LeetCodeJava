/* Single Number
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * */

public class LeetCode0136 {
    public static void main(String args[]) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}
