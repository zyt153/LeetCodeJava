/* Remove Duplicates from Sorted Array
* Example 1:
* Given nums = [1,1,2],
* Your function should return length = 2,
* with the first two elements of nums being 1 and 2 respectively.
* */

import java.util.Arrays;

public class LeetCode0026 {
    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int NonDupPoint = 1;
        for(int i = 1; i < nums.length; i ++){
            if (nums[i] != nums[i-1]){
                nums[NonDupPoint] = nums[i];
                NonDupPoint ++;
            }
        }
        //System.out.println(Arrays.toString(nums));
        return NonDupPoint;
    }
}
