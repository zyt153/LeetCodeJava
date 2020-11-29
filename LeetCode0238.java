/* Product of Array Except Self
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * Follow up: Could you solve it with constant space complexity?
 * */

public class LeetCode0238 {
    public static void main(String args[]) {
        int[] nums = {1, 2, 3, 4};
        int[] res = productExceptSelf(nums);
        for (int num : res)
            System.out.print(num + ",");
    }

    public static int[] productExceptSelf(int[] nums) {
        /* Time complexity: O(N), Space complexity : O(N)
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] res = new int[length];

        left[0] = 1;
        for (int i = 1; i < length; i++)
            left[i] = left[i - 1] * nums[i - 1];

        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--)
            right[i] = right[i + 1] * nums[i + 1];

        for (int i = 0; i < length; i++) {
            res[i] = left[i] * right[i];
        }

        return res;*/

        // Time complexity: O(N), Space complexity : O(1)
        int length = nums.length;
        int[] res = new int[length];

        res[0] = 1;
        for (int i = 1; i < length; i++)
            res[i] = res[i - 1] * nums[i - 1];

        int right = 1;
        for(int i = length - 1; i >= 0; i--){
            res[i] = res[i] * right;
            right *= nums[i];
        }

        return res;
    }
}
