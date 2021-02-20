/* Find Minimum in Rotated Sorted Array
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * */

public class LeetCode0153 {
    public static void main(String[] args) {
        int[] nums = {3,1,2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int middle = left + (right - left) / 2;
            if (nums[middle] > nums[right])
                left = middle + 1;
            else
                right = middle;
        }
        return nums[left];
    }
}
