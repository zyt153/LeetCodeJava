/* Sort Colors
 * Example:
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * */

package Array;

import java.util.Arrays;

public class LeetCode0075 {
    public static void main(String args[]){
        int[] nums = {1,2,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int index = 0;

        while (start < end && index <= end){
            if (nums[index] == 0){
                nums[index] = nums[start];
                nums[start] = 0;
                start ++;
                index ++;
            }
            else if (nums[index] == 2){
                nums[index] = nums[end];
                nums[end] = 2;
                end --;
            }
            else
                index ++;
        }

    }
}
