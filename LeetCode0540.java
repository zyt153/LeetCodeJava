/* Single Element in a Sorted Array
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * */

public class LeetCode0540 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int middle = left + (right - left) / 2;
            if (middle % 2 == 1)
                middle--;
            if (nums[middle] != nums[middle + 1])
                right = middle;
            else
                left = middle + 2;
        }
        return nums[left];
    }
}
